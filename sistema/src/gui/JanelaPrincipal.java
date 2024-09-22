package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.barranavegacao.BarraNavegacao;
import gui.paginas.Home;

public class JanelaPrincipal extends JFrame{
    private JPanel panelCentral;

    public JanelaPrincipal(){
        setTitle("Luthieria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(new BarraNavegacao(this), BorderLayout.NORTH);

        panelCentral = new Home();
        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

    public void mostrarPagina(JPanel pagina) {
        remove(panelCentral);
        
        panelCentral = pagina;
        add(panelCentral, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
