package gui.paginas.forms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inicio.Luthier;
import model.instrumento.Aerofone;
import model.instrumento.Cordofone;
import model.instrumento.Idiofone;
import model.instrumento.Instrumento;
import model.instrumento.Membranofone;

public class InstrumentoForms extends JPanel {
    private JTextField nomeField;
    private JTextField nomesAdicionaisField;
    private JTextField modeloField;
    private JTextField categoriaField;
    private JTextField procedenciaField;
    private JTextField descricaoField;
    private JTextField dataFabricacaoField;
    private JTextField fabricanteField;
    private JTextField fabricacaoPaisField;
    private JTextField fabricacaoCidadeField;
    private JTextField fabricacaoEstadoField;
    private JTextField fabricacaoLocalidadeField;
    private JTextField materialField;
    private JTextField pesoField;
    private JTextField alturaField;
    private JTextField estadoConservacaoField;
    private JTextField marcasInscricoesField;
    private JTextField statusField;

    private JTextField metodoExecucao;
    private JTextField tipoIdiofone;

    private JTextField tipoMembrana;
    private JTextField metodoTocarMembrana;
    private JTextField ajusteTensao;

    private JTextField numeroCordas;
    private JTextField tipoCordas;
    private JTextField metodoExecucaoCorda;

    private JTextField tipoBocal;
    private JTextField metodoProducaoSom;
    private JTextField ajusteAfinacao;

    private JButton salvarButton;

    private FormCloseListener closeListener;

    public InstrumentoForms(Instrumento instrumento, FormCloseListener closeListener){
        setLayout(new GridLayout(18, 2, 10, 10));

        this.closeListener = closeListener;

        nomeField = new JTextField(20);
        nomesAdicionaisField = new JTextField(20);
        modeloField = new JTextField(20);
        categoriaField = new JTextField(20);
        procedenciaField = new JTextField(20);
        descricaoField = new JTextField(20);
        dataFabricacaoField = new JTextField(10);
        fabricanteField = new JTextField(20);
        fabricacaoPaisField = new JTextField(20);
        fabricacaoCidadeField = new JTextField(20);
        fabricacaoEstadoField = new JTextField(20);
        fabricacaoLocalidadeField = new JTextField(20);
        materialField = new JTextField(20);
        pesoField = new JTextField(10);
        alturaField = new JTextField(10);
        estadoConservacaoField = new JTextField(20);
        marcasInscricoesField = new JTextField(20);
        statusField = new JTextField(10);

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Nomes Adicionais:"));
        add(nomesAdicionaisField);
        add(new JLabel("Modelo:"));
        add(modeloField);
        add(new JLabel("Categoria:"));
        add(categoriaField);
        add(new JLabel("Procedência:"));
        add(procedenciaField);
        add(new JLabel("Descrição:"));
        add(descricaoField);
        add(new JLabel("Data de Fabricação:"));
        add(dataFabricacaoField);
        add(new JLabel("Fabricante:"));
        add(fabricanteField);
        add(new JLabel("País de Fabricação:"));
        add(fabricacaoPaisField);
        add(new JLabel("Cidade de Fabricação:"));
        add(fabricacaoCidadeField);
        add(new JLabel("Estado de Fabricação:"));
        add(fabricacaoEstadoField);
        add(new JLabel("Localidade de Fabricação:"));
        add(fabricacaoLocalidadeField);
        add(new JLabel("Material:"));
        add(materialField);
        add(new JLabel("Peso:"));
        add(pesoField);
        add(new JLabel("Altura:"));
        add(alturaField);
        add(new JLabel("Estado de Conservação:"));
        add(estadoConservacaoField);
        add(new JLabel("Marcas e Inscrições:"));
        add(marcasInscricoesField);
        add(new JLabel("Status:"));
        add(statusField);

        preencherDadosInstrumento(instrumento);

        if (instrumento instanceof Idiofone) {
            metodoExecucao = new JTextField(20);
            tipoIdiofone = new JTextField(20);

            add(new JLabel("Método de Execução:"));
            add(metodoExecucao);
            add(new JLabel("Tipo de Idiofone:"));
            add(tipoIdiofone);

            preencherDadosIdiofone((Idiofone) instrumento);

        } else if (instrumento instanceof Cordofone) {
            numeroCordas = new JTextField(20);
            tipoCordas = new JTextField(20);
            metodoExecucaoCorda = new JTextField(20);

            add(new JLabel("Número de Cordas:"));
            add(numeroCordas);
            add(new JLabel("Tipo de Cordas:"));
            add(tipoCordas);
            add(new JLabel("Método de Execução:"));
            add(metodoExecucaoCorda);

            preencherDadosCordofone((Cordofone) instrumento);

        } else if (instrumento instanceof Membranofone) {
            tipoMembrana = new JTextField(20);
            metodoTocarMembrana = new JTextField(20);
            ajusteTensao = new JTextField(20);

            add(new JLabel("Tipo de Membrana:"));
            add(tipoMembrana);
            add(new JLabel("Método de Tocar Membrana:"));
            add(metodoTocarMembrana);
            add(new JLabel("Ajuste de Tensão:"));
            add(ajusteTensao);

            preencherDadosMembranofone((Membranofone) instrumento);

        } else if (instrumento instanceof Aerofone) {
            tipoBocal = new JTextField(20);
            metodoProducaoSom = new JTextField(20);
            ajusteAfinacao = new JTextField(20);

            add(new JLabel("Tipo de Bocal:"));
            add(tipoBocal);
            add(new JLabel("Método de Produção de Som:"));
            add(metodoProducaoSom);
            add(new JLabel("Ajuste de Afinação:"));
            add(ajusteAfinacao);

            preencherDadosAerofone((Aerofone) instrumento);
        }

        salvarButton = new JButton("Salvar");
        add(salvarButton);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes(instrumento);
            }
        });
    }

    private void preencherDadosInstrumento(Instrumento instrumento) {
        nomeField.setText(instrumento.getNome());
        nomesAdicionaisField.setText(instrumento.getNomesAdicionais());
        modeloField.setText(instrumento.getModelo());
        categoriaField.setText(instrumento.getCategoria());
        procedenciaField.setText(instrumento.getProcedencia());
        descricaoField.setText(instrumento.getDescricao());
        
        if (instrumento.getDataFabricacao() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataFabricacaoField.setText(instrumento.getDataFabricacao().format(formatter));
        } else {
            dataFabricacaoField.setText("Data não disponível");
        }

        fabricanteField.setText(instrumento.getFabricante());
        fabricacaoPaisField.setText(instrumento.getFabricacaoPais());
        fabricacaoCidadeField.setText(instrumento.getFabricacaoCidade());
        fabricacaoEstadoField.setText(instrumento.getFabricacaoEstado());
        fabricacaoLocalidadeField.setText(instrumento.getFabricacaoLocalidade());
        materialField.setText(instrumento.getMaterial());
        pesoField.setText(String.valueOf(instrumento.getPeso()));
        alturaField.setText(String.valueOf(instrumento.getAltura()));
        estadoConservacaoField.setText(instrumento.getEstadoConservacao());
        marcasInscricoesField.setText(instrumento.getMarcasInscricoes());
        statusField.setText(instrumento.getStatus());
    }

    private void preencherDadosIdiofone(Idiofone idiofone) {
        metodoExecucao.setText(idiofone.getMetodoExecucao());
        tipoIdiofone.setText(idiofone.getTipoIdiofone());
    }
    
    private void preencherDadosCordofone(Cordofone cordofone) {
        numeroCordas.setText(String.valueOf(cordofone.getNumeroCordas()));
        tipoCordas.setText(cordofone.getTipoCordas());
        metodoExecucaoCorda.setText(cordofone.getMetodoExecucaoCorda());
    }

    private void preencherDadosMembranofone(Membranofone membranofone) {
        tipoMembrana.setText(membranofone.getTipoMembrana());
        metodoTocarMembrana.setText(membranofone.getMetodoTocarMembrana());
        ajusteTensao.setText(membranofone.getAjusteTensao());
    }

    private void preencherDadosAerofone(Aerofone aerofone) {
        tipoBocal.setText(aerofone.getTipoBocal());
        metodoProducaoSom.setText(aerofone.getMetodoProducaoSom());
        ajusteAfinacao.setText(aerofone.getAjusteAfinacao());
    }

    private void salvarAlteracoes(Instrumento instrumento) {
        instrumento.setNome(nomeField.getText());
        instrumento.setNomesAdicionais(nomesAdicionaisField.getText());
        instrumento.setModelo(modeloField.getText());
        instrumento.setCategoria(categoriaField.getText());
        instrumento.setProcedencia(procedenciaField.getText());
        instrumento.setDescricao(descricaoField.getText());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        instrumento.setDataFabricacao(LocalDate.parse(dataFabricacaoField.getText(), formatter));
        
        instrumento.setFabricante(fabricanteField.getText());
        instrumento.setFabricacaoPais(fabricacaoPaisField.getText());
        instrumento.setFabricacaoCidade(fabricacaoCidadeField.getText());
        instrumento.setFabricacaoEstado(fabricacaoEstadoField.getText());
        instrumento.setFabricacaoLocalidade(fabricacaoLocalidadeField.getText());
        instrumento.setMaterial(materialField.getText());
        instrumento.setPeso(Double.parseDouble(pesoField.getText()));
        instrumento.setAltura(Double.parseDouble(alturaField.getText()));
        instrumento.setEstadoConservacao(estadoConservacaoField.getText());
        instrumento.setMarcasInscricoes(marcasInscricoesField.getText());
        instrumento.setStatus(statusField.getText());

        if (instrumento instanceof Idiofone) {
            Idiofone idiofone = (Idiofone) instrumento;
            idiofone.setMetodoExecucao(metodoExecucao.getText());
            idiofone.setTipoIdiofone(tipoIdiofone.getText());
        } else if (instrumento instanceof Cordofone) {
            Cordofone cordofone = (Cordofone) instrumento;
            cordofone.setNumeroCordas(Integer.parseInt(numeroCordas.getText()));
            cordofone.setTipoCordas(tipoCordas.getText());
            cordofone.setMarcasInscricoes(metodoExecucaoCorda.getText());
        } else if (instrumento instanceof Membranofone) {
            Membranofone membranofone = (Membranofone) instrumento;
            membranofone.setTipoMembrana(tipoMembrana.getText());
            membranofone.setMetodoTocarMembrana(metodoTocarMembrana.getText());
            membranofone.setAjusteTensao(ajusteTensao.getText());
        } else if (instrumento instanceof Aerofone) {
            Aerofone aerofone = (Aerofone) instrumento;
            aerofone.setTipoBocal(tipoBocal.getText());
            aerofone.setMetodoProducaoSom(metodoProducaoSom.getText());
            aerofone.setAjusteAfinacao(ajusteAfinacao.getText());
        }

        if (instrumento.getId() != null) {
            new Luthier().alterar(instrumento);
            JOptionPane.showMessageDialog(this, "Dados do instrumento alterados com sucesso!");
        } else {
            new Luthier().inserir(instrumento);
            JOptionPane.showMessageDialog(this, "Novo instrumento inserido com sucesso!");
        }

        onFormClose();
    }

    private void onFormClose() {
        if (closeListener != null) {
            closeListener.onClose();
        }
    }
}
