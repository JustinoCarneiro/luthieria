package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

//Classe que define os atributos específicos de um idiofone que é um instrumento musical, assim como getters e setters
public class Idiofone extends Instrumento{
    private String metodoExecucao;
    private String tipoIdiofone;
    
    public Idiofone(){
        super();
    }

    public Idiofone(UUID id, String nome, String nomesAdicionais, String modelo, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, String metodoExecucao,
            String tipoIdiofone) {
        super(id, nome, nomesAdicionais, modelo, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
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

    //Método responsável por entregar o instrumento, quando necessário, como string
    @Override
    public String toString() {
        return "Idiofone{" +
                "metodoExecucao='" + metodoExecucao + "'" +
                ", tipoIdiofone='" + tipoIdiofone + "'" +
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
