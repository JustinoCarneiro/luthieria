package model.instrumento;

import java.util.UUID;

public class Cordofone extends Instrumento{
    private Integer numeroDeCordas;
    private String tipoDeCordas;
    private String metodoExecucaoCorda;
    
    public Cordofone(UUID id, String nome, String nomesAdicionais, String categoria, String procedencia,
            String descricao, String dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, Integer numeroDeCordas,
            String tipoDeCordas, String metodoExecucaoCorda) {
        super(id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.numeroDeCordas = numeroDeCordas;
        this.tipoDeCordas = tipoDeCordas;
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }

    public Integer getNumeroDeCordas() {
        return numeroDeCordas;
    }

    public void setNumeroDeCordas(Integer numeroDeCordas) {
        this.numeroDeCordas = numeroDeCordas;
    }

    public String getTipoDeCordas() {
        return tipoDeCordas;
    }

    public void setTipoDeCordas(String tipoDeCordas) {
        this.tipoDeCordas = tipoDeCordas;
    }

    public String getMetodoExecucaoCorda() {
        return metodoExecucaoCorda;
    }

    public void setMetodoExecucaoCorda(String metodoExecucaoCorda) {
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }
}
