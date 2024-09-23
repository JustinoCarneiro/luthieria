package gui.paginas.forms;

import javax.swing.*;

import inicio.Luthier;

import java.awt.*;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import model.cliente.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ClienteForms extends JPanel {
    private JTextField nomeCompletoField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private JTextField numeroLocalField;
    private JTextField complementoField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;

    private JTextField cpfField;
    private JTextField dataNascimentoField;

    private JTextField razaoSocialField;
    private JTextField inscricaoEstadualField;
    private JTextField cnpjField;

    private JButton salvarButton;

    private FormCloseListener closeListener;

    public ClienteForms(Cliente cliente, FormCloseListener closeListener) {
        setLayout(new GridLayout(13, 2, 10, 10));

        this.closeListener = closeListener;

        nomeCompletoField = new JTextField(20);
        emailField = new JTextField(20);
        telefoneField = new JTextField(15);
        enderecoField = new JTextField(30);
        numeroLocalField = new JTextField(10);
        complementoField = new JTextField(20);
        bairroField = new JTextField(20);
        cidadeField = new JTextField(20);
        estadoField = new JTextField(2);

        add(new JLabel("Nome Completo:"));
        add(nomeCompletoField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Telefone:"));
        add(telefoneField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(new JLabel("Número:"));
        add(numeroLocalField);
        add(new JLabel("Complemento:"));
        add(complementoField);
        add(new JLabel("Bairro:"));
        add(bairroField);
        add(new JLabel("Cidade:"));
        add(cidadeField);
        add(new JLabel("Estado:"));
        add(estadoField);

        if (cliente instanceof PessoaFisica) {
            cpfField = new JTextField(11);
            dataNascimentoField = new JTextField(10);

            add(new JLabel("CPF:"));
            add(cpfField);
            add(new JLabel("Data de Nascimento:"));
            add(dataNascimentoField);

            preencherDadosPessoaFisica((PessoaFisica) cliente);
        } else if (cliente instanceof PessoaJuridica) {
            razaoSocialField = new JTextField(30);
            inscricaoEstadualField = new JTextField(20);
            cnpjField = new JTextField(14);

            add(new JLabel("Razão Social:"));
            add(razaoSocialField);
            add(new JLabel("Inscrição Estadual:"));
            add(inscricaoEstadualField);
            add(new JLabel("CNPJ:"));
            add(cnpjField);

            preencherDadosPessoaJuridica((PessoaJuridica) cliente);
        }

        salvarButton = new JButton("Salvar");
        add(salvarButton);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes(cliente);
            }
        });
    }

    private void preencherDadosPessoaFisica(PessoaFisica pessoaFisica) {
        nomeCompletoField.setText(pessoaFisica.getNomeCompleto());
        emailField.setText(pessoaFisica.getEmail());
        telefoneField.setText(pessoaFisica.getTelefoneCelular());
        enderecoField.setText(pessoaFisica.getEndereco());
        numeroLocalField.setText(pessoaFisica.getNumeroLocal());
        complementoField.setText(pessoaFisica.getComplemento());
        bairroField.setText(pessoaFisica.getBairro());
        cidadeField.setText(pessoaFisica.getCidade());
        estadoField.setText(pessoaFisica.getEstado());
        cpfField.setText(pessoaFisica.getCpf());

        if (pessoaFisica.getDataNascimento() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimentoField.setText(pessoaFisica.getDataNascimento().format(formatter));
        } else {
            dataNascimentoField.setText("Data não disponível");
        }
    }

    private void preencherDadosPessoaJuridica(PessoaJuridica pessoaJuridica) {
        nomeCompletoField.setText(pessoaJuridica.getNomeCompleto());
        emailField.setText(pessoaJuridica.getEmail());
        telefoneField.setText(pessoaJuridica.getTelefoneCelular());
        enderecoField.setText(pessoaJuridica.getEndereco());
        numeroLocalField.setText(pessoaJuridica.getNumeroLocal());
        complementoField.setText(pessoaJuridica.getComplemento());
        bairroField.setText(pessoaJuridica.getBairro());
        cidadeField.setText(pessoaJuridica.getCidade());
        estadoField.setText(pessoaJuridica.getEstado());
        razaoSocialField.setText(pessoaJuridica.getRazaoSocial());
        inscricaoEstadualField.setText(pessoaJuridica.getInscricaoEstadual());
        cnpjField.setText(pessoaJuridica.getCnpj());
    }

    private void salvarAlteracoes(Cliente cliente) {
        cliente.setNomeCompleto(nomeCompletoField.getText());
        cliente.setEmail(emailField.getText());
        cliente.setTelefoneCelular(telefoneField.getText());
        cliente.setEndereco(enderecoField.getText());
        cliente.setNumeroLocal(numeroLocalField.getText());
        cliente.setComplemento(complementoField.getText());
        cliente.setBairro(bairroField.getText());
        cliente.setCidade(cidadeField.getText());
        cliente.setEstado(estadoField.getText());

        if (cliente instanceof PessoaFisica) {
            PessoaFisica pessoaFisica = (PessoaFisica) cliente;
            pessoaFisica.setCpf(cpfField.getText());
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                pessoaFisica.setDataNascimento(LocalDate.parse(dataNascimentoField.getText(), formatter));
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Data de nascimento inválida.");
            }
        } else if (cliente instanceof PessoaJuridica) {
            PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
            pessoaJuridica.setRazaoSocial(razaoSocialField.getText());
            pessoaJuridica.setInscricaoEstadual(inscricaoEstadualField.getText());
            pessoaJuridica.setCnpj(cnpjField.getText());
        }

        if (cliente.getId() != null) {
            new Luthier().alterar(cliente);
            JOptionPane.showMessageDialog(this, "Dados do cliente alterados com sucesso!");
        } else {
            new Luthier().inserir(cliente);
            JOptionPane.showMessageDialog(this, "Novo cliente inserido com sucesso!");
        }

        onFormClose();
    }

    private void onFormClose() {
        if (closeListener != null) {
            closeListener.onClose();
        }
    }
}
