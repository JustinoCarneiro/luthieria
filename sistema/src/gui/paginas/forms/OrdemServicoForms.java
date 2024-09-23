package gui.paginas.forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inicio.Luthier;
import model.OrdemServico;

public class OrdemServicoForms extends JPanel{
    private JTextField codigoField;
    private JTextField tipoServicoField;
    private JTextField idInstrumentoField;
    private JTextField idClienteField;
    private JTextField valorServicoField;
    private JTextField pecasField;
    private JTextField statusInstrumentoField;
    private JTextField observacaoStatusField;
    private JTextField previsaoEntregaField;

    private JButton salvarButton;
    private FormCloseListener closeListener;

    public OrdemServicoForms(OrdemServico ordemServico, FormCloseListener closeListener) {
        this.closeListener = closeListener;
        setLayout(new GridLayout(10, 2, 10, 10));

        codigoField = new JTextField(20);
        tipoServicoField = new JTextField(20);
        idInstrumentoField = new JTextField(36); 
        idClienteField = new JTextField(36); 
        valorServicoField = new JTextField(10);
        pecasField = new JTextField(50);
        statusInstrumentoField = new JTextField(20);
        observacaoStatusField = new JTextField(100);
        previsaoEntregaField = new JTextField(10); 

        add(new JLabel("Código:"));
        add(codigoField);
        add(new JLabel("Tipo de Serviço:"));
        add(tipoServicoField);
        add(new JLabel("ID Instrumento:"));
        add(idInstrumentoField);
        add(new JLabel("ID Cliente:"));
        add(idClienteField);
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

        if (ordemServico != null) {
            preencherDados(ordemServico);
        }

        salvarButton = new JButton("Salvar");
        add(salvarButton);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes(ordemServico);
            }
        });
    }

    private void preencherDados(OrdemServico ordemServico) {
        codigoField.setText(ordemServico.getCodigo());
        tipoServicoField.setText(ordemServico.getTipoServico());

        if (ordemServico.getIdInstrumento() != null) {
            idInstrumentoField.setText(ordemServico.getIdInstrumento().toString());
        } else {
            idInstrumentoField.setText("");
        }
    
        if (ordemServico.getIdCliente() != null) {
            idClienteField.setText(ordemServico.getIdCliente().toString());
        } else {
            idClienteField.setText("");
        }

        valorServicoField.setText(String.valueOf(ordemServico.getValorServico()));
        pecasField.setText(ordemServico.getPecas());
        statusInstrumentoField.setText(ordemServico.getStatusInstrumento());
        observacaoStatusField.setText(ordemServico.getObservacaoStatus());

        if (ordemServico.getPrevisaoEntrega() != null) {
            previsaoEntregaField.setText(ordemServico.getPrevisaoEntrega().toString());
        } else {
            previsaoEntregaField.setText("");
        }
    }

    private void salvarAlteracoes(OrdemServico ordemServico) {
        ordemServico.setCodigo(codigoField.getText());
        ordemServico.setTipoServico(tipoServicoField.getText());

        if (!idInstrumentoField.getText().isEmpty()) {
        ordemServico.setIdInstrumento(UUID.fromString(idInstrumentoField.getText()));
        }
        
        if (!idClienteField.getText().isEmpty()) {
            ordemServico.setIdCliente(UUID.fromString(idClienteField.getText()));
        }
        
        ordemServico.setValorServico(Double.parseDouble(valorServicoField.getText()));
        ordemServico.setPecas(pecasField.getText());
        ordemServico.setStatusInstrumento(statusInstrumentoField.getText());
        ordemServico.setObservacaoStatus(observacaoStatusField.getText());
        ordemServico.setPrevisaoEntrega(LocalDate.parse(previsaoEntregaField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        if(ordemServico.getId() != null){
            new Luthier().alterar(ordemServico);
            JOptionPane.showMessageDialog(this, "Dados da ordem de serviço alterados com sucesso!");
        } else {
            new Luthier().inserir(ordemServico);
            JOptionPane.showMessageDialog(this, "Nova ordem de serviço inserida com sucesso!");
        }

        onFormClose();
    }

    private void onFormClose() {
        if (closeListener != null) {
            closeListener.onClose();
        }
    }
}
