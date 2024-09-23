package gui.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.paginas.botoestabela.ButtonEditor;
import gui.paginas.botoestabela.ButtonRenderer;
import gui.paginas.forms.FormCloseListener;
import gui.paginas.forms.OrdemServicoForms;
import inicio.Luthier;
import model.OrdemServico;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

public class OrdensServicos extends JPanel{

    private JTable table;
    private DefaultTableModel tableModel;

    public OrdensServicos() {
        setLayout(new BorderLayout());
        String[] columnNames = {"Código", "Instrumento", "Cliente", "Detalhes", "Excluir"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 3;
            }
        };

        table.getColumn("Detalhes").setCellRenderer(new ButtonRenderer("Ver Detalhes"));
        table.getColumn("Detalhes").setCellEditor(new ButtonEditor(new JButton("Ver Detalhes"), this));

        table.getColumn("Excluir").setCellRenderer(new ButtonRenderer("Excluir"));
        table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JButton("Excluir"), this));

        table.setIntercellSpacing(new java.awt.Dimension(10, 10));
        table.setRowHeight(30);

            JScrollPane scrollPane = new JScrollPane(table);

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BorderLayout());
        panelTabela.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelTabela.add(scrollPane, BorderLayout.CENTER);
        panelTabela.setBackground(Color.WHITE);

        add(panelTabela, BorderLayout.CENTER);

        atualizarTabelaOrdensServicos();

        JButton adicionar = new JButton("Adicionar Ordem de Serviço");
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioOrdemServico();
            }
        });

        add(adicionar, BorderLayout.SOUTH);
    }

    private void abrirFormularioOrdemServico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Adicionar Ordem Servico");
        dialog.setModal(true);
        dialog.setSize(400, 600); 
        dialog.setLocationRelativeTo(this);

        OrdemServico ordemServico = new OrdemServico();

        OrdemServicoForms ordemServicoForms = new OrdemServicoForms(ordemServico, new FormCloseListener() {
            @Override
            public void onClose() {
                dialog.dispose();
                atualizarTabelaOrdensServicos();
            }
        });
        
        dialog.add(ordemServicoForms, BorderLayout.CENTER);
        dialog.revalidate();
        dialog.repaint(); 
        dialog.setVisible(true);
    }

    public void atualizarTabelaOrdensServicos() {
        tableModel.setRowCount(0);

        List<OrdemServico> ordensServicos = new Luthier().listarOrdensServicos();
        
        if (ordensServicos.isEmpty()) {
            tableModel.addRow(new Object[]{"Sem ordens de serviço no momento", "", "", ""});
        } else {
            for (OrdemServico ordemServico : ordensServicos) {
                Instrumento instrumento = new RepositorioInstrumento().buscarPorId(ordemServico.getIdInstrumento());
                Cliente cliente = new RepositorioCliente().buscaPorId(ordemServico.getIdCliente());

                tableModel.addRow(new Object[]{
                    ordemServico.getCodigo(),
                    instrumento.getNome(),
                    cliente.getNomeCompleto(),
                    ordemServico.getId(),
                    "Excluir"
                });
            }
        }
    }

    public void excluirOrdemServico(OrdemServico ordemServico) {
        int resposta = JOptionPane.showConfirmDialog(this, 
            "Deseja realmente excluir esta ordem de serviço?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            new Luthier().remover(ordemServico);
            atualizarTabelaOrdensServicos();
        }
    }
}
