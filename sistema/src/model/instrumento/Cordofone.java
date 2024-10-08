package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

//Classe que define os atributos específicos de um cordofone que é um instrumento musical, assim como getters e setters
public class Cordofone extends Instrumento{
    private Integer numeroCordas;
    private String tipoCordas;
    private String metodoExecucaoCorda;
    
    public Cordofone(){
        super();
    }

    public Cordofone(UUID id, String nome, String nomesAdicionais, String modelo, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status, Integer numeroDeCordas,
            String tipoDeCordas, String metodoExecucaoCorda) {
        super(id, nome, nomesAdicionais, modelo, categoria, procedencia, descricao, dataFabricacao, fabricante, fabricacaoPais,
                fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade, material, peso, altura, estadoConservacao,
                marcasInscricoes, status);
        this.numeroCordas = numeroDeCordas;
        this.tipoCordas = tipoDeCordas;
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }

    public Integer getNumeroCordas() {
        return numeroCordas;
    }

    public void setNumeroCordas(Integer numeroCordas) {
        this.numeroCordas = numeroCordas;
    }

    public String getTipoCordas() {
        return tipoCordas;
    }

    public void setTipoCordas(String tipoCordas) {
        this.tipoCordas = tipoCordas;
    }

    public String getMetodoExecucaoCorda() {
        return metodoExecucaoCorda;
    }

    public void setMetodoExecucaoCorda(String metodoExecucaoCorda) {
        this.metodoExecucaoCorda = metodoExecucaoCorda;
    }

    //Método responsável por entregar o instrumento, quando necessário, como string
    @Override
    public String toString() {
        return "Cordofone{" +
                "numeroCordas=" + numeroCordas +
                ", tipoCordas='" + tipoCordas + "'" +
                ", metodoExecucaoCorda='" + metodoExecucaoCorda + "'" +
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
