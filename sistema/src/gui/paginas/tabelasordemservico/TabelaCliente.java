package gui.paginas.tabelasordemservico;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JRadioButton;
import gui.paginas.forms.ClienteForms;
import gui.paginas.forms.FormCloseListener;
import gui.paginas.tabelasordemservico.botoes.ButtonEditor;
import gui.paginas.tabelasordemservico.botoes.ButtonRenderer;
import gui.paginas.tabelasordemservico.botoes.RadioButtonEditor;
import gui.paginas.tabelasordemservico.botoes.RadioButtonRenderer;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import repositorio.RepositorioCliente;
import inicio.Luthier;

public class TabelaCliente extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> filtroTipoCliente;
    private JTextField campoPesquisa;
    private ButtonGroup group;

    public TabelaCliente() {

        setLayout(new BorderLayout());

        JPanel panelSelecao = new JPanel();
    
        filtroTipoCliente = new JComboBox<>(new String[]{"Todos", "Pessoa Física", "Pessoa Jurídica"});
        campoPesquisa = new JTextField(20);

        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabelaClientes();
            }
        });

        panelSelecao.add(filtroTipoCliente);
        panelSelecao.add(campoPesquisa);
        panelSelecao.add(botaoPesquisar);

        add(panelSelecao, BorderLayout.NORTH);

        String[] columnNames = {"Nome Completo", "Email", "Telefone", "Detalhes", "Selecionar"};
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

        atualizarTabelaClientes();

        JButton adicionar = new JButton("Adicionar Cliente");
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioCliente();
            }
        });

        add(adicionar, BorderLayout.SOUTH);
    }

    private void abrirFormularioCliente() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Adicionar Cliente");
        dialog.setModal(true);
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);
    
        JComboBox<String> tipoClienteCombo = new JComboBox<>(new String[]{"Pessoa Física", "Pessoa Jurídica"});
        JButton botaoContinuar = new JButton("Continuar");
    
        JPanel selecaoPanel = new JPanel();
        selecaoPanel.add(tipoClienteCombo);
        selecaoPanel.add(botaoContinuar);
    
        dialog.add(selecaoPanel, BorderLayout.NORTH);
    
        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente novoCliente;
    
                if ("Pessoa Física".equals(tipoClienteCombo.getSelectedItem())) {
                    novoCliente = new PessoaFisica();
                } else {
                    novoCliente = new PessoaJuridica();
                }

                ClienteForms clienteForms = new ClienteForms(novoCliente, new FormCloseListener() {
                    @Override
                    public void onClose() {
                        dialog.dispose();
                        atualizarTabelaClientes();
                    }
                });
    
                dialog.remove(selecaoPanel);
                dialog.add(clienteForms, BorderLayout.CENTER);
                dialog.setSize(400, 600); 
    
                dialog.revalidate();
                dialog.repaint(); 
            }
        });
    
        dialog.setVisible(true);
    }

    public void atualizarTabelaClientes() {
        tableModel.setRowCount(0);
        group.clearSelection();

        List<Cliente> clientes = new Luthier().listarClientes();
        String tipoSelecionado = (String) filtroTipoCliente.getSelectedItem();
        List<Cliente> clientesFiltrados = clientes;

        if (tipoSelecionado.equals("Pessoa Física")) {
            clientesFiltrados = clientes.stream()
                .filter(cliente -> cliente instanceof PessoaFisica)
                .collect(Collectors.toList());
        } else if (tipoSelecionado.equals("Pessoa Jurídica")) {
            clientesFiltrados = clientes.stream()
                .filter(cliente -> cliente instanceof PessoaJuridica)
                .collect(Collectors.toList());
        }

        String textoPesquisa = campoPesquisa.getText().toLowerCase();
        if (!textoPesquisa.isEmpty()) {
            clientesFiltrados = clientesFiltrados.stream()
                .filter(cliente -> cliente.getNomeCompleto().toLowerCase().contains(textoPesquisa) ||
                        cliente.getEmail().toLowerCase().contains(textoPesquisa) ||
                        cliente.getTelefoneCelular().toLowerCase().contains(textoPesquisa))
                .collect(Collectors.toList());
        }

        if (clientesFiltrados.isEmpty()) {
            tableModel.addRow(new Object[]{"Sem clientes no momento", "", "", "", false});
        } else {
            for (Cliente cliente : clientesFiltrados) {
                tableModel.addRow(new Object[]{
                    cliente.getNomeCompleto(),
                    cliente.getEmail(),
                    cliente.getTelefoneCelular(),
                    cliente.getId(),
                    false
                });
            }
        }
    }
    
    public Cliente getClienteSelecionado() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            UUID idCliente = (UUID) tableModel.getValueAt(selectedRow, 3);  
            return new RepositorioCliente().buscaPorId(idCliente);
        }
        return null;
    }
}
