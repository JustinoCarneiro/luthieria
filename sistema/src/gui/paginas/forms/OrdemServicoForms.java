package gui.paginas.forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inicio.Luthier;
import model.OrdemServico;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

//Painel responsável por inserir ou alterar ordens de serviços
public class OrdemServicoForms extends JPanel{
    private JTextField tipoServicoField;
    private JTextField instrumentoField;
    private JTextField clienteField;
    private JTextField valorServicoField;
    private JTextField pecasField;
    private JTextField statusInstrumentoField;
    private JTextField observacaoStatusField;
    private JTextField previsaoEntregaField;

    private JButton salvarButton;

    //Necessário para efetuar uma ação quando o formulário for fechado
    private FormCloseListener closeListener;

    private Instrumento instrumento;
    private Cliente cliente;

    public OrdemServicoForms(OrdemServico ordemServico, FormCloseListener closeListener) {
        this.closeListener = closeListener;
        setLayout(new GridLayout(9, 2, 10, 10));

        tipoServicoField = new JTextField(20);
        instrumentoField = new JTextField(36); 
        clienteField = new JTextField(36); 
        valorServicoField = new JTextField(10);
        pecasField = new JTextField(50);
        statusInstrumentoField = new JTextField(20);
        observacaoStatusField = new JTextField(100);
        previsaoEntregaField = new JTextField(10); 

        add(new JLabel("Tipo de Serviço:"));
        add(tipoServicoField);

        add(new JLabel("Instrumento:"));
        instrumentoField.setEditable(false);
        instrumentoField.setBackground(Color.LIGHT_GRAY);
        add(instrumentoField);

        add(new JLabel("Cliente:"));
        clienteField.setEditable(false);
        clienteField.setBackground(Color.LIGHT_GRAY);
        add(clienteField);
        
        add(new JLabel("Valor do Serviço:"));
        add(valorServicoField);
        add(new JLabel("Peças:"));
        add(pecasField);
        add(new JLabel("Status do Instrumento:"));
        add(statusInstrumentoField);
        add(new JLabel("Observação do Status:"));
        add(observacaoStatusField);
        add(new JLabel("Previsão de Entrega:"));
        add(previsaoEntregaField);

        preencherDados(ordemServico);

        salvarButton = new JButton("Salvar");
        add(salvarButton);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes(ordemServico);
            }
        });
    }

    //Método auxiliar para preencher dados da ordem de serviço
    private void preencherDados(OrdemServico ordemServico) {
        tipoServicoField.setText(ordemServico.getTipoServico());

        if (ordemServico.getIdInstrumento() != null) {
            instrumento = new RepositorioInstrumento().buscarPorId(ordemServico.getIdInstrumento());

            instrumentoField.setText(instrumento.getNome());
        } else {
            instrumentoField.setText("");
        }
    
        if (ordemServico.getIdCliente() != null) {
            cliente = new RepositorioCliente().buscaPorId(ordemServico.getIdCliente());
            clienteField.setText(cliente.getNomeCompleto());
        } else {
            clienteField.setText("");
        }

        valorServicoField.setText(String.valueOf(ordemServico.getValorServico()));
        pecasField.setText(ordemServico.getPecas());
        statusInstrumentoField.setText(ordemServico.getStatusInstrumento());
        observacaoStatusField.setText(ordemServico.getObservacaoStatus());

        if (ordemServico.getPrevisaoEntrega() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            previsaoEntregaField.setText(ordemServico.getPrevisaoEntrega().format(formatter));
        } else {
            previsaoEntregaField.setText("Data não disponível");
        }
    }

    //Método auxiliar responsável por alterar ou inserir a ordem de serviço
    private void salvarAlteracoes(OrdemServico ordemServico) {
        ordemServico.setTipoServico(tipoServicoField.getText());

        if (!instrumentoField.getText().isEmpty()) {
            ordemServico.setIdInstrumento(instrumento.getId());
        }
        
        if (!clienteField.getText().isEmpty()) {
            ordemServico.setIdCliente(cliente.getId());
        }
        
        try {
            ordemServico.setValorServico(Double.parseDouble(valorServicoField.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor do serviço inválido. Por favor, insira um número válido.");
            return;
        }

        ordemServico.setPecas(pecasField.getText());
        ordemServico.setStatusInstrumento(statusInstrumentoField.getText());
        ordemServico.setObservacaoStatus(observacaoStatusField.getText());

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ordemServico.setPrevisaoEntrega(LocalDate.parse(previsaoEntregaField.getText(), formatter));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data de previsão de entrega inválida. Por favor, use o formato 'dd/MM/yyyy'.");
            return;
        }
        
        if(ordemServico.getId() != null){
            //Chama o controlador Luthier
            new Luthier().alterar(ordemServico);
            JOptionPane.showMessageDialog(this, "Dados da ordem de serviço alterados com sucesso!");
        } else {
            new Luthier().inserir(ordemServico);
            JOptionPane.showMessageDialog(this, "Nova ordem de serviço inserida com sucesso!");
        }

        onFormClose();
    }

    //Método auxiliar para realizar uma ação quando o formulário for fechado
    private void onFormClose() {
        if (closeListener != null) {
            closeListener.onClose();
        }
    }
}
