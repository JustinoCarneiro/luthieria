package gui.paginas.tabelasordemservico.botoes;

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

import gui.paginas.forms.ClienteForms;
import gui.paginas.forms.FormCloseListener;
import gui.paginas.forms.InstrumentoForms;
import gui.paginas.tabelasordemservico.TabelaCliente;
import gui.paginas.tabelasordemservico.TabelaInstrumento;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

//Classe responsável por configurar as ações dos botões que ficam nas tabelas
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JButton button;
    private boolean isPushed;
    private Object itemPanel;
    private UUID itemId;

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
        button.setText("Ver Detalhes");

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return itemId;
    }

    //As ações possíveis são: abrir formulário do cliente ou do instrumento
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isPushed) {
            if (itemPanel instanceof TabelaCliente) {
                RepositorioCliente repositorio = new RepositorioCliente();
                Cliente cliente = repositorio.buscaPorId(itemId);
                abrirFormularioCliente(cliente);

            } else if (itemPanel instanceof TabelaInstrumento) {
                RepositorioInstrumento repositorio = new RepositorioInstrumento();
                Instrumento instrumento = repositorio.buscarPorId(itemId);

                abrirFormularioInstrumento(instrumento); 
            }
        }
        fireEditingStopped();
    }

    //Método auxiliar por chamar o formulário do cliente
    private void abrirFormularioCliente(Cliente cliente) {
        JDialog dialog = new JDialog((JFrame) null, "Formulário Cliente", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);

        ClienteForms clienteForms = new ClienteForms(cliente, new FormCloseListener() {
            //Ao chamar este método, irá atualizar a tabela desto painel passado como argumento no construtor
            @Override
            public void onClose() {
                ((TabelaCliente) itemPanel).atualizarTabelaClientes();
            }
        });

        dialog.add(clienteForms);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    //Método auxiliar por chamar o formulário do instrumento
    private void abrirFormularioInstrumento(Instrumento instrumento) {
        JDialog dialog = new JDialog((JFrame) null, "Formulário Instrumento", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);

        InstrumentoForms instrumentoForms = new InstrumentoForms(instrumento, new FormCloseListener() {
            //Ao chamar este método, irá atualizar a tabela desto painel passado como argumento no construtor
            @Override
            public void onClose() {
                ((TabelaInstrumento) itemPanel).atualizarTabelaInstrumentos();
            }
        });

        dialog.add(instrumentoForms);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}

