package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

public class Idiofone extends Instrumento{
    private String metodoExecucao;
    private String tipoIdiofone;
    
    public Idiofone(UUID id, String nome, String nomesAdicionais, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, String metodoExecucao,
            String tipoIdiofone) {
        super(id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.metodoExecucao = metodoExecucao;
        this.tipoIdiofone = tipoIdiofone;
    }

    public String getMetodoExecucao() {
        return metodoExecucao;
    }

    public void setMetodoExecucao(String metodoExecucao) {
        this.metodoExecucao = metodoExecucao;
    }

    public String getTipoIdiofone() {
        return tipoIdiofone;
    }

    public void setTipoIdiofone(String tipoIdiofone) {
        this.tipoIdiofone = tipoIdiofone;
    }

    @Override
    public String toString() {
        return "Idiofone{" +
                "metodoExecucao='" + metodoExecucao + "'" +
                ", tipoIdiofone='" + tipoIdiofone + "'" +
                ", id=" + getId() +
                ", nome='" + getNome() + "'" +
                ", nomesAdicionais='" + getNomesAdicionais() + "'" +
                ", categoria='" + getCategoria() + "'" +
                ", procedencia='" + getProcedencia() + "'" +
                ", descricao='" + getDescricao() + "'" +
                ", dataFabricacao=" + getDataFabricacao() +
                ", fabricante='" + getFabricante() + "'" +
                ", fabricacaoPais='" + getFabricacaoPais() + "'" +
                ", fabricacaoCidade='" + getFabricacaoCidade() + "'" +
                ", fabricacaoEstado='" + getFabricacaoEstado() + "'" +
                ", fabricacaoLocalidade='" + getFabricacaoLocalidade() + "'" +
                ", material='" + getMaterial() + "'" +
                ", peso=" + getPeso() +
                ", altura=" + getAltura() +
                ", estadoConservacao='" + getEstadoConservacao() + "'" +
                ", marcasInscricoes='" + getMarcasInscricoes() + "'" +
                ", status='" + getStatus() + "'" +
                '}';
    }

}
