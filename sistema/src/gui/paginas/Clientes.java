package gui.paginas;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import model.cliente.Cliente;
import repositorio.RepositorioCliente;

public class Clientes extends JPanel{

    public Clientes(){
        setLayout(new BorderLayout());


        String[] columnNames = {"Nome Completo", "Email", "Telefone", "Detalhes"};

        List<Cliente> clientes = new RepositorioCliente().listar();

        Object[][] data = new Object[clientes.size()][columnNames.length];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = cliente.getNomeCompleto();
            data[i][1] = cliente.getEmail();
            data[i][2] = cliente.getTelefoneCelular();
            data[i][3] = "Ver Detalhes";
        }

        JTable table = new JTable(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };

        table.setIntercellSpacing(new java.awt.Dimension(10, 10));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);

        add(panel, BorderLayout.CENTER);
    }
}
