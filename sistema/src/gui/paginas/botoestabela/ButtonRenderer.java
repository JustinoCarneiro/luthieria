package gui.paginas.botoestabela;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//Classe responsável por como os botãos das tabelas devem ser renderizados
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer(String label) {
        setText(label);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 3) {
            setText("Ver Detalhes");
        } else if (column == 4) {
            setText("Excluir");
        }
        return this;
    }
}

