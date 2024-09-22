package gui.barranavegacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.JanelaPrincipal;
import gui.paginas.Clientes;
import gui.paginas.Home;
import gui.paginas.Instrumentos;
import gui.paginas.OrdensServicos;

public class Botoes extends JPanel{

    public Botoes(JanelaPrincipal frame){

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnHome = new JButton("Home");
        btnHome.setPreferredSize(new Dimension(180, 40));
        btnHome.addActionListener(e -> frame.mostrarPagina(new Home()));
        btnHome.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnHome, gbc);

        JButton btnCliente = new JButton("Clientes");
        btnCliente.setPreferredSize(new Dimension(180, 40));
        btnCliente.addActionListener(e -> frame.mostrarPagina(new Clientes()));
        btnCliente.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        add(btnCliente, gbc);

        JButton btnInstrumentos = new JButton("Instrumentos");
        btnInstrumentos.setPreferredSize(new Dimension(180, 40));
        btnInstrumentos.addActionListener(e -> frame.mostrarPagina(new Instrumentos()));
        btnInstrumentos.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 2;
        add(btnInstrumentos, gbc);

        JButton btnOrdensServicos = new JButton("Ordens de serviços");
        btnOrdensServicos.setPreferredSize(new Dimension(180, 40));
        btnOrdensServicos.addActionListener(e -> frame.mostrarPagina(new OrdensServicos()));
        btnOrdensServicos.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 3;
        add(btnOrdensServicos, gbc);
    }
}
