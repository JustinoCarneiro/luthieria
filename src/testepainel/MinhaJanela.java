package testepainel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MinhaJanela extends JFrame{
    public MinhaJanela(String titulo){
        super(titulo);
        JPanel pane = new JPanel();
        JButton botao = new JButton ("Texto botao");
        pane.add(botao);
        setContentPane(pane);
        pack();
        setVisible(true);
    }
}
