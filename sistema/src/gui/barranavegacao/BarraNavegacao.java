package gui.barranavegacao;

import javax.swing.*;

import gui.JanelaPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

public class BarraNavegacao extends JToolBar {

    public BarraNavegacao(JanelaPrincipal frame) {
        setPreferredSize(new Dimension(1200, 70));
        setFloatable (false);
        setBackground(Color.WHITE);

        try {
            URL caminhoLogo = getClass().getResource("/gui/arquivos/logo_luthieria.jpg");

            ImageIcon logo = new ImageIcon(caminhoLogo);

            int novoComp = (int) (logo.getIconHeight() * 0.05);
            int novaLarg = (int) (logo.getIconWidth() * 0.05);
            
            Image mascara = logo.getImage();
            
            Image mascaraResized = mascara.getScaledInstance(novoComp, novaLarg, Image.SCALE_SMOOTH);
            
            ImageIcon logoResized = new ImageIcon(mascaraResized);
            
            JLabel logoLabel = new JLabel(logoResized);

            add(logoLabel);
        } catch (Exception e) {
            System.out.println("Erro ao carregar a imagem da logo: " + e.getMessage());
        }

        add(new Botoes(frame));
    }
}
