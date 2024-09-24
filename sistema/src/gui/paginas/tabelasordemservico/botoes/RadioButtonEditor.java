package gui.paginas.tabelasordemservico.botoes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Classe responsável por configurar as ações dos botões de seleção que ficam nas tabelas
public class RadioButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JRadioButton radioButton;

    public RadioButtonEditor() {
        radioButton = new JRadioButton();
        radioButton.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        if (value instanceof Boolean) {
            radioButton.setSelected((Boolean) value);
        } else {
            radioButton.setSelected(false);
        }
        return radioButton;
    }

    @Override
    public Object getCellEditorValue() {
        return radioButton.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
    }
}
