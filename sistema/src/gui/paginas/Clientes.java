package gui.paginas;

import java.util.List;
import java.util.stream.Collectors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import gui.paginas.botoestabela.ButtonEditor;
import gui.paginas.botoestabela.ButtonRenderer;
import gui.paginas.forms.ClienteForms;
import gui.paginas.forms.FormCloseListener;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import inicio.Luthier;

//Painel responsável por mostrar os clientes inseridos, assim como fazer alterações, remoções e adições com gui
public class Clientes extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> filtroTipoCliente;
    private JTextField campoPesquisa;

    public Clientes() {
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

        //Painel responsável por aplicar filtro no que é listado na tabela
        add(panelSelecao, BorderLayout.NORTH);

        //Cria a tabela
        String[] columnNames = {"Nome Completo", "Email", "Telefone", "Detalhes", "Excluir"};
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

        //Adiciona a tabela num painel de scroll, para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BorderLayout());
        panelTabela.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //Adiciona o painel de scroll num painel
        panelTabela.add(scrollPane, BorderLayout.CENTER);
        panelTabela.setBackground(Color.WHITE);

        //Adicionao painel a tela
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

    //Método auxiliar para abrir o formulário para inserir ou alterar um cliente
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
    
        //Diálogo responsável por selecionar qual tipo de cliente desejo inserir ou alterar
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
                    //Ao chamar este método, irá fechar a janela do formulário e atualizar a tabela deste painel
                    @Override
                    public void onClose() {
                        dialog.dispose();
                        atualizarTabelaClientes();
                    }
                });
    
                dialog.remove(selecaoPanel);

                //Adiciona o formulário do cliente
                dialog.add(clienteForms, BorderLayout.CENTER);
                dialog.setSize(400, 600); 
    
                dialog.revalidate();
                dialog.repaint(); 
            }
        });
    
        dialog.setVisible(true);
    }
    
//Método responsável por atualizar a tabela, em caso de pesquisa, alteração, adição ou remoção de dados    
    public void atualizarTabelaClientes() {
        tableModel.setRowCount(0);

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
            tableModel.addRow(new Object[]{"Sem clientes no momento", "", "", ""});
        } else {
            for (Cliente cliente : clientesFiltrados) {
                tableModel.addRow(new Object[]{
                    cliente.getNomeCompleto(),
                    cliente.getEmail(),
                    cliente.getTelefoneCelular(),
                    cliente.getId(),
                    "Excluir"
                });
            }
        }
    }

    //Método responsável por excluir o cliente selecionado
    public void excluirCliente(Cliente cliente) {
        int resposta = JOptionPane.showConfirmDialog(this, 
            "Deseja realmente excluir este cliente?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            //Chama o controlador Luthier
            new Luthier().remover(cliente);
            atualizarTabelaClientes();
        }
    }
}
