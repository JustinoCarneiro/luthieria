package model.instrumento;

import java.util.UUID;

public class Aerofone extends Instrumento{
    private String tipoBocal;
    private String metodoProducaoSom;
    private String ajusteAfinação;
    
    public Aerofone(UUID id, String nome, String nomesAdicionais, String categoria, String procedencia,
            String descricao, String dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, String tipoBocal,
            String metodoProducaoSom, String ajusteAfinação) {
        super(id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.tipoBocal = tipoBocal;
        this.metodoProducaoSom = metodoProducaoSom;
        this.ajusteAfinação = ajusteAfinação;
    }

    public String getTipoBocal() {
        return tipoBocal;
    }

    public void setTipoBocal(String tipoBocal) {
        this.tipoBocal = tipoBocal;
    }

    public String getMetodoProducaoSom() {
        return metodoProducaoSom;
    }

    public void setMetodoProducaoSom(String metodoProducaoSom) {
        this.metodoProducaoSom = metodoProducaoSom;
    }

    public String getAjusteAfinação() {
        return ajusteAfinação;
    }

    public void setAjusteAfinação(String ajusteAfinação) {
        this.ajusteAfinação = ajusteAfinação;
    }
}
