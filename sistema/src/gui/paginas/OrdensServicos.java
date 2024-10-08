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
import gui.paginas.tabelasordemservico.TabelaCliente;
import gui.paginas.tabelasordemservico.TabelaInstrumento;
import inicio.Luthier;
import model.OrdemServico;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

//Painel reponsável por mostrar as ordens de serviços inseridos, assim como fazer alterações, remoções e adições com gui.
//Também de gerar as notificações relacionadas a ordem de serviço
public class OrdensServicos extends JPanel{

    private JTable table;
    private DefaultTableModel tableModel;
    private Cliente cliente;
    private Instrumento instrumento;

    public OrdensServicos() {
        setLayout(new BorderLayout());

        //Cria a tabela
        String[] columnNames = {"Código", "Instrumento", "Cliente", "Detalhes", "Excluir", "Gerar notificação"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 3 || column == 5;
            }
        };

        table.getColumn("Detalhes").setCellRenderer(new ButtonRenderer("Ver Detalhes"));
        table.getColumn("Detalhes").setCellEditor(new ButtonEditor(new JButton("Ver Detalhes"), this));

        table.getColumn("Excluir").setCellRenderer(new ButtonRenderer("Excluir"));
        table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JButton("Excluir"), this));

        table.getColumn("Gerar notificação").setCellRenderer(new ButtonRenderer("Notificação"));
        table.getColumn("Gerar notificação").setCellEditor(new ButtonEditor(new JButton("Notificação"), this));

        table.setIntercellSpacing(new java.awt.Dimension(10, 10));
        table.setRowHeight(30);

        //Adiciona a tabela num painel de scroll, para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BorderLayout());
        panelTabela.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //Adiciona o painel de scroll num painel
        panelTabela.add(scrollPane, BorderLayout.CENTER);
        panelTabela.setBackground(Color.WHITE);

        add(panelTabela, BorderLayout.CENTER);

        atualizarTabelaOrdensServicos();

        JButton adicionar = new JButton("Adicionar Ordem de Serviço");
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Chama método para selecionar cliente
                abrirSelecaoCliente();
            }
        });

        add(adicionar, BorderLayout.SOUTH);
    }

    //Método auxiliar responsável por selecionar o cliente relacionado a ordem de serviço a ser criada
    private void abrirSelecaoCliente() {
        JDialog dialogSelecionar = new JDialog();
        dialogSelecionar.setTitle("Selecionar Cliente");
        dialogSelecionar.setModal(true);
        dialogSelecionar.setSize(600, 400);
        dialogSelecionar.setLocationRelativeTo(this);
        
        TabelaCliente tabelaCliente = new TabelaCliente();
        
        dialogSelecionar.add(tabelaCliente, BorderLayout.CENTER);
    
        JButton confirmar = new JButton("Confirmar Seleção");
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteSelecionado = tabelaCliente.getClienteSelecionado();

                if (clienteSelecionado != null) {
                    cliente = clienteSelecionado; 
                    dialogSelecionar.dispose();

                    //Chama método para selecionar instrumento
                    abrirSelecaoInstrumento();
                } else {
                    JOptionPane.showMessageDialog(dialogSelecionar, 
                        "Por favor, selecione um cliente.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(confirmar);
        
        dialogSelecionar.add(panelBotoes, BorderLayout.SOUTH);
        
        dialogSelecionar.setVisible(true);
    }
    
    //Método auxiliar responsável por selecionar o instrumento relacionado a ordem de serviço a ser criada
    private void abrirSelecaoInstrumento(){
        JDialog dialogSelecionar = new JDialog();
        dialogSelecionar.setTitle("Selecionar Instrumento");
        dialogSelecionar.setModal(true);
        dialogSelecionar.setSize(600, 400);
        dialogSelecionar.setLocationRelativeTo(this);

        TabelaInstrumento tabelaInstrumento = new TabelaInstrumento();

        dialogSelecionar.add(tabelaInstrumento, BorderLayout.CENTER);

        JButton confirmar = new JButton("Confirmar Seleção");
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instrumento instrumentoSelecionado = tabelaInstrumento.getInstrumentoSelecionado();

                if (instrumentoSelecionado != null) {
                    instrumento = instrumentoSelecionado; 
                    dialogSelecionar.dispose();

                    //Chama método para inserir ordem de serviço
                    abrirFormularioOrdemServico();
                } else {
                    JOptionPane.showMessageDialog(dialogSelecionar, 
                        "Por favor, selecione um instrumento.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(confirmar);

        dialogSelecionar.add(panelBotoes, BorderLayout.SOUTH);
        dialogSelecionar.setVisible(true);
    }
    
    //Método responsável por inserir ou alterar uma ordem de serviço
    private void abrirFormularioOrdemServico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Adicionar Ordem Serviço");
        dialog.setModal(true);
        dialog.setSize(400, 600); 
        dialog.setLocationRelativeTo(this);

        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setIdCliente(cliente.getId());
        ordemServico.setIdInstrumento(instrumento.getId());

        OrdemServicoForms ordemServicoForms = new OrdemServicoForms(ordemServico, new FormCloseListener() {
            //Ao chamar este método, irá fechar a janela do formulário e atualizar a tabela deste painel
            @Override
            public void onClose() {
                dialog.dispose();
                atualizarTabelaOrdensServicos();
            }
        });
        
        //Adiciona o formulário da ordem de serviço
        dialog.add(ordemServicoForms, BorderLayout.CENTER);
        dialog.revalidate();
        dialog.repaint(); 
        dialog.setVisible(true);
    }

    //Método responsável por atualizar a tabela, em caso de alteração, adição ou remoção de dados
    public void atualizarTabelaOrdensServicos() {
        tableModel.setRowCount(0);

        List<OrdemServico> ordensServicos = new Luthier().listarOrdensServicos();
        
        if (ordensServicos.isEmpty()) {
            tableModel.addRow(new Object[]{"Sem ordens de serviço no momento", "", "", ""});
        } else {
            for (OrdemServico ordemServico : ordensServicos) {
                Instrumento instrumento = new RepositorioInstrumento().buscarPorId(ordemServico.getIdInstrumento());
                Cliente cliente = new RepositorioCliente().buscaPorId(ordemServico.getIdCliente());

                if (instrumento == null) {
                    System.out.println("Instrumento não encontrado para a ordem de serviço " + ordemServico.getCodigo());
                    continue; 
                }
            
                if (cliente == null) {
                    System.out.println("Cliente não encontrado para a ordem de serviço " + ordemServico.getCodigo());
                    continue; 
                }

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

    //Método responsável por excluir a ordem de serviço selecionada
    public void excluirOrdemServico(OrdemServico ordemServico) {
        int resposta = JOptionPane.showConfirmDialog(this, 
            "Deseja realmente excluir esta ordem de serviço?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            //Chama o controlador Luthier
            new Luthier().remover(ordemServico);
            atualizarTabelaOrdensServicos();
        }
    }
}
