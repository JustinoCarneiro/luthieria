package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

//Classe que define os atributos específicos de um aerofone que é um instrumento musical, assim como getters e setters
public class Aerofone extends Instrumento{
    private String tipoBocal;
    private String metodoProducaoSom;
    private String ajusteAfinacao;

    public Aerofone(){
        super();
    }
    
    public Aerofone(UUID id, String nome, String nomesAdicionais, String modelo, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, String tipoBocal,
            String metodoProducaoSom, String ajusteAfinacao) {
        super(id, nome, nomesAdicionais, modelo, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.tipoBocal = tipoBocal;
        this.metodoProducaoSom = metodoProducaoSom;
        this.ajusteAfinacao = ajusteAfinacao;
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

    public String getAjusteAfinacao() {
        return ajusteAfinacao;
    }

    public void setAjusteAfinacao(String ajusteAfinacao) {
        this.ajusteAfinacao = ajusteAfinacao;
    }

    //Método responsável por entregar o instrumento, quando necessário, como string
    @Override
    public String toString() {
        return "Aerofone{" +
                "tipoBocal='" + tipoBocal + "'" +
                ", metodoProducaoSom='" + metodoProducaoSom + "'" +
                ", ajusteAfinacao='" + ajusteAfinacao + "'" +
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
