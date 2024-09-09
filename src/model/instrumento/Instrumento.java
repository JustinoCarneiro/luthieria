package model.instrumento;

import java.util.UUID;

public abstract class Instrumento {
    protected UUID id;
    protected String nome;
    protected String nomesAdicionais;
    protected String categoria;
    protected String procedencia;
    protected String descricao;
    protected String dataFabricacao;
    protected String fabricante;
    protected String fabricacaoPais;
    protected String fabricacaoCidade;
    protected String fabricacaoEstado;
    protected String fabricacaoLocalidade;
    protected String material;
    protected String peso;
    protected String altura;
    protected String estadoConservacao;
    protected String marcasInscricoes;
    protected String status;

    public Instrumento(UUID id, String nome, String nomesAdicionais, String categoria, String procedencia,
            String descricao, String dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, String peso, String altura,
            String estadoConservacao, String marcasInscricoes, String status) {
        this.id = id;
        this.nome = nome;
        this.nomesAdicionais = nomesAdicionais;
        this.categoria = categoria;
        this.procedencia = procedencia;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.fabricante = fabricante;
        this.fabricacaoPais = fabricacaoPais;
        this.fabricacaoCidade = fabricacaoCidade;
        this.fabricacaoEstado = fabricacaoEstado;
        this.fabricacaoLocalidade = fabricacaoLocalidade;
        this.material = material;
        this.peso = peso;
        this.altura = altura;
        this.estadoConservacao = estadoConservacao;
        this.marcasInscricoes = marcasInscricoes;
        this.status = status;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomesAdicionais() {
        return nomesAdicionais;
    }
    public void setNomesAdicionais(String nomesAdicionais) {
        this.nomesAdicionais = nomesAdicionais;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getProcedencia() {
        return procedencia;
    }
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDataFabricacao() {
        return dataFabricacao;
    }
    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getFabricacaoPais() {
        return fabricacaoPais;
    }
    public void setFabricacaoPais(String fabricacaoPais) {
        this.fabricacaoPais = fabricacaoPais;
    }
    public String getFabricacaoCidade() {
        return fabricacaoCidade;
    }
    public void setFabricacaoCidade(String fabricacaoCidade) {
        this.fabricacaoCidade = fabricacaoCidade;
    }
    public String getFabricacaoEstado() {
        return fabricacaoEstado;
    }
    public void setFabricacaoEstado(String fabricacaoEstado) {
        this.fabricacaoEstado = fabricacaoEstado;
    }
    public String getFabricacaoLocalidade() {
        return fabricacaoLocalidade;
    }
    public void setFabricacaoLocalidade(String fabricacaoLocalidade) {
        this.fabricacaoLocalidade = fabricacaoLocalidade;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getEstadoConservacao() {
        return estadoConservacao;
    }
    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }
    public String getMarcasInscricoes() {
        return marcasInscricoes;
    }
    public void setMarcasInscricoes(String marcasInscricoes) {
        this.marcasInscricoes = marcasInscricoes;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
