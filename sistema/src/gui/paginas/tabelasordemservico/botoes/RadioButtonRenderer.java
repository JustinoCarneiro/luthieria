package gui.paginas.tabelasordemservico.botoes;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

//Classe responsável por como os botãos de seleção das tabelas devem ser renderizados
public class RadioButtonRenderer extends JRadioButton implements TableCellRenderer {

    public RadioButtonRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Boolean) {
            setSelected((Boolean) value);
        } else {
            setSelected(false);
        }
        return this;
    }
}
