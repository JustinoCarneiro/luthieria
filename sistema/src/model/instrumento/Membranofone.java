package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

public class Membranofone extends Instrumento{
    private String tipoMembrana;
    private String metodoTocarMembrana;
    private String ajusteTensao;
    
    public Membranofone(){
        super();
    }

    public Membranofone(UUID id, String nome, String nomesAdicionais, String modelo, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, String tipoMembrana,
            String metodoTocarMembrana, String ajusteTensao) {
        super(id, nome, nomesAdicionais, modelo, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.tipoMembrana = tipoMembrana;
        this.metodoTocarMembrana = metodoTocarMembrana;
        this.ajusteTensao = ajusteTensao;
    }

    public String getTipoMembrana() {
        return tipoMembrana;
    }

    public void setTipoMembrana(String tipoMembrana) {
        this.tipoMembrana = tipoMembrana;
    }

    public String getMetodoTocarMembrana() {
        return metodoTocarMembrana;
    }

    public void setMetodoTocarMembrana(String metodoTocarMembrana) {
        this.metodoTocarMembrana = metodoTocarMembrana;
    }

    public String getAjusteTensao() {
        return ajusteTensao;
    }

    public void setAjusteTensao(String ajusteTensao) {
        this.ajusteTensao = ajusteTensao;
    }

    @Override
    public String toString() {
        return "Membranofone{" +
                "tipoMembrana='" + tipoMembrana + "'" +
                ", metodoTocarMembrana='" + metodoTocarMembrana + "'" +
                ", ajusteTensao='" + ajusteTensao + "'" +
                ", id=" + getId() +
                ", nome='" + getNome() + "'" +
                ", nomesAdicionais='" + getNomesAdicionais() + "'" +
                ", modelo='" + getModelo() + "'" +
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
