package model.instrumento;

import java.util.UUID;

public class Cordofone extends Instrumento{
    private Integer numeroCordas;
    private String tipoCordas;
    private String metodoExecucaoCorda;
    
    public Cordofone(UUID id, String nome, String nomesAdicionais, String categoria, String procedencia,
            String descricao, String dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, Integer numeroDeCordas,
            String tipoDeCordas, String metodoExecucaoCorda) {
        super(id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.numeroCordas = numeroDeCordas;
        this.tipoCordas = tipoDeCordas;
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }

    public Integer getNumeroDeCordas() {
        return numeroCordas;
    }

    public void setNumeroDeCordas(Integer numeroCordas) {
        this.numeroCordas = numeroCordas;
    }

    public String getTipoDeCordas() {
        return tipoCordas;
    }

    public void setTipoDeCordas(String tipoCordas) {
        this.tipoCordas = tipoCordas;
    }

    public String getMetodoExecucaoCorda() {
        return metodoExecucaoCorda;
    }

    public void setMetodoExecucaoCorda(String metodoExecucaoCorda) {
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }
}
