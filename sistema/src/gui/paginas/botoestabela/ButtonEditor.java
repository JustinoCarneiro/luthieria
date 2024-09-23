package gui.paginas.botoestabela;

import java.util.UUID;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import gui.paginas.Clientes;
import gui.paginas.Instrumentos;
import gui.paginas.forms.ClienteForms;
import gui.paginas.forms.FormCloseListener;
import gui.paginas.forms.InstrumentoForms;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JButton button;
    private boolean isPushed;
    private Object itemPanel;
    private UUID itemId;
    private String actionType;

    public ButtonEditor(JButton button, Object itemPanel) {
        this.button = button;
        this.itemPanel = itemPanel;
        this.button.setOpaque(true);
        this.button.addActionListener(this);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        isPushed = true;
        itemId = (UUID) table.getValueAt(row, 3);

        if (column == 3) {
            button.setText("Ver Detalhes");
            actionType = "detalhes";
        } else if (column == 4) {
            button.setText("Excluir");
            actionType = "excluir";
        }

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return itemId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isPushed) {
            if (itemPanel instanceof Clientes) {

                RepositorioCliente repositorio = new RepositorioCliente();
                Cliente cliente = repositorio.buscaPorId(itemId);

                if ("excluir".equals(actionType)) {
                    ((Clientes) itemPanel).excluirCliente(cliente); 
                } else {
                    abrirFormularioCliente(cliente);
                }
            } else if (itemPanel instanceof Instrumentos) {

                RepositorioInstrumento repositorio = new RepositorioInstrumento();
                Instrumento instrumento = repositorio.buscarPorId(itemId);

                if ("excluir".equals(actionType)) {
                    ((Instrumentos) itemPanel).excluirInstrumento(instrumento);
                } else {
                    abrirFormularioInstrumento(instrumento);
                }
            }
        }
        fireEditingStopped();
    }

    private void abrirFormularioCliente(Cliente cliente) {
        JDialog dialog = new JDialog((JFrame) null, "Formulário Cliente", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);

        ClienteForms clienteForms = new ClienteForms(cliente, new FormCloseListener() {
            @Override
            public void onClose() {
                ((Clientes) itemPanel).atualizarTabelaClientes();
            }
        });

        dialog.add(clienteForms);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private void abrirFormularioInstrumento(Instrumento instrumento) {
        JDialog dialog = new JDialog((JFrame) null, "Formulário Instrumento", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);

        InstrumentoForms instrumentoForms = new InstrumentoForms(instrumento, new FormCloseListener() {
            @Override
            public void onClose() {
                ((Instrumentos) itemPanel).atualizarTabelaInstrumentos();
            }
        });

        dialog.add(instrumentoForms);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
