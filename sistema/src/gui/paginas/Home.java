package gui.paginas;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Painel responsável por mostrar a primeira página da aplicação, nesse caso está mostrando apenas a logo da loja
public class Home extends JPanel{
    public Home(){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        try {
            URL caminhoImgCentral = getClass().getResource("/gui/arquivos/logo_luthieria.jpg");

            ImageIcon imgCentral = new ImageIcon(caminhoImgCentral);

            int novoComp = (int) (imgCentral.getIconHeight() * 0.2);
            int novaLarg = (int) (imgCentral.getIconWidth() * 0.2);
            
            Image mascara = imgCentral.getImage();
            
            Image mascaraResized = mascara.getScaledInstance(novoComp, novaLarg, Image.SCALE_SMOOTH);
            
            ImageIcon imgCentralResized = new ImageIcon(mascaraResized);

            JLabel labelImgCentral = new JLabel(imgCentralResized);

            add(labelImgCentral);

        } catch (Exception e) {
            System.out.println("Erro ao carregar a imagem central: " + e.getMessage());
        }
    }
}
