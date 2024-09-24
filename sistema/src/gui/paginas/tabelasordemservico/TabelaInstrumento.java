package gui.paginas.tabelasordemservico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JRadioButton;

import gui.paginas.forms.FormCloseListener;
import gui.paginas.forms.InstrumentoForms;
import gui.paginas.tabelasordemservico.botoes.ButtonEditor;
import gui.paginas.tabelasordemservico.botoes.ButtonRenderer;
import gui.paginas.tabelasordemservico.botoes.RadioButtonEditor;
import gui.paginas.tabelasordemservico.botoes.RadioButtonRenderer;
import inicio.Luthier;
import model.instrumento.Aerofone;
import model.instrumento.Cordofone;
import model.instrumento.Idiofone;
import model.instrumento.Instrumento;
import model.instrumento.Membranofone;
import repositorio.RepositorioInstrumento;

public class TabelaInstrumento extends JPanel{
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> filtroTipoInstrumento;
    private JTextField campoPesquisa;
    private ButtonGroup group;
    
    public TabelaInstrumento(){

        setLayout(new BorderLayout());

        JPanel panelSelecao = new JPanel();

        filtroTipoInstrumento = new JComboBox<>(new String[]{"Todos", "Idiofones", "Membranofones", "Cordofones", "Aerofones"});
        campoPesquisa = new JTextField(20);

        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabelaInstrumentos();
            }
        });

        panelSelecao.add(filtroTipoInstrumento);
        panelSelecao.add(campoPesquisa);
        panelSelecao.add(botaoPesquisar);

        add(panelSelecao, BorderLayout.NORTH);

        String[] columnNames = {"Nome", "Modelo", "Fabricante", "Detalhes", "Selecionar"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 3;
            }
        };

        table.getColumn("Detalhes").setCellRenderer(new ButtonRenderer("Ver Detalhes"));
        table.getColumn("Detalhes").setCellEditor(new ButtonEditor(new JButton("Ver Detalhes"), this));

        table.getColumn("Selecionar").setCellRenderer(new RadioButtonRenderer());
        table.getColumn("Selecionar").setCellEditor(new RadioButtonEditor());

        group = new ButtonGroup();

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT) {
                    JRadioButton radioButton = new JRadioButton();
                    group.add(radioButton);
                    tableModel.setValueAt(radioButton, e.getFirstRow(), 4);
                }
            }
        });

        table.setIntercellSpacing(new java.awt.Dimension(10, 10));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BorderLayout());
        panelTabela.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelTabela.add(scrollPane, BorderLayout.CENTER);
        panelTabela.setBackground(Color.WHITE);

        add(panelTabela, BorderLayout.CENTER);

        atualizarTabelaInstrumentos();

        JButton adicionar = new JButton("Adicionar Instrumento");
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioInstrumento();
            }
        });

        add(adicionar, BorderLayout.SOUTH);
    }

    private void abrirFormularioInstrumento() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Adicionar Instrumento");
        dialog.setModal(true);
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);
    
        JComboBox<String> tipoClienteCombo = new JComboBox<>(new String[]{"Idiofone", "Membranofone", "Cordofone", "Aerofone"});
        JButton botaoContinuar = new JButton("Continuar");
    
        JPanel selecaoPanel = new JPanel();
        selecaoPanel.add(tipoClienteCombo);
        selecaoPanel.add(botaoContinuar);
    
        dialog.add(selecaoPanel, BorderLayout.NORTH);
    
        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instrumento novoInstrumento;
    
                if ("Idiofone".equals(tipoClienteCombo.getSelectedItem())) {
                    novoInstrumento = new Idiofone();
                } else if("Membranofone".equals(tipoClienteCombo.getSelectedItem())){
                    novoInstrumento = new Membranofone();
                } else if("Cordofone".equals(tipoClienteCombo.getSelectedItem())){
                    novoInstrumento = new Cordofone();
                } else {
                    novoInstrumento = new Aerofone();
                }

                InstrumentoForms instrumentoForms = new InstrumentoForms(novoInstrumento, new FormCloseListener() {
                    @Override
                    public void onClose() {
                        dialog.dispose();
                        atualizarTabelaInstrumentos();
                    }
                });
    
                dialog.remove(selecaoPanel);
                dialog.add(instrumentoForms, BorderLayout.CENTER);
                dialog.setSize(400, 600); 
    
                dialog.revalidate();
                dialog.repaint(); 
            }
        });
    
        dialog.setVisible(true);
    }

    public void atualizarTabelaInstrumentos() {
        tableModel.setRowCount(0);
        group.clearSelection();

        List<Instrumento> instrumentos = new Luthier().listarInstrumentos();
        String tipoSelecionado = (String) filtroTipoInstrumento.getSelectedItem();
        List<Instrumento> instrumentosFiltrados = instrumentos;
        
        if (tipoSelecionado.equals("Idiofones")) {
            instrumentosFiltrados = instrumentos.stream()
                .filter(instrumento -> instrumento instanceof Idiofone)
                .collect(Collectors.toList());
        } else if (tipoSelecionado.equals("Membranofones")) {
            instrumentosFiltrados = instrumentos.stream()
                .filter(instrumento -> instrumento instanceof Membranofone)
                .collect(Collectors.toList());
        } else if(tipoSelecionado.equals("Cordofones")){
            instrumentosFiltrados = instrumentos.stream()
                .filter(instrumento -> instrumento instanceof Cordofone)
                .collect(Collectors.toList());
        } else if(tipoSelecionado.equals("Aerofones")){
            instrumentosFiltrados = instrumentos.stream()
                .filter(instrumento -> instrumento instanceof Aerofone)
                .collect(Collectors.toList());
        }

        String textoPesquisa = campoPesquisa.getText().toLowerCase();
        if (!textoPesquisa.isEmpty()) {
            instrumentosFiltrados = instrumentosFiltrados.stream()
                .filter(instrumento -> instrumento.getNome().toLowerCase().contains(textoPesquisa) ||
                        instrumento.getModelo().toLowerCase().contains(textoPesquisa) ||
                        instrumento.getFabricante().toLowerCase().contains(textoPesquisa))
                .collect(Collectors.toList());
        }

        if (instrumentosFiltrados.isEmpty()) {
            tableModel.addRow(new Object[]{"Sem instrumentos no momento", "", "", false});
        } else {
            for (Instrumento instrumento : instrumentosFiltrados) {
                JRadioButton radioButton = new JRadioButton();
                group.add(radioButton);
                tableModel.addRow(new Object[]{
                    instrumento.getNome(),
                    instrumento.getModelo(),
                    instrumento.getFabricante(),
                    instrumento.getId(),
                    false
                });
            }
        }
    }

    public Instrumento getInstrumentoSelecionado(){
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1){
            UUID idInstrumento = (UUID) tableModel.getValueAt(selectedRow, 3);
            return new RepositorioInstrumento().buscarPorId(idInstrumento);
        }
        return null;
    }
}
