package model.instrumento;

import java.time.LocalDate;
import java.util.UUID;

//Classe que define os atributos genéricos de um instrumento musical, assim como getters e setters
public abstract class Instrumento {
    protected UUID id;
    protected String nome;
    protected String nomesAdicionais;
    protected String modelo;
    protected String categoria;
    protected String procedencia;
    protected String descricao;
    protected LocalDate dataFabricacao;
    protected String fabricante;
    protected String fabricacaoPais;
    protected String fabricacaoCidade;
    protected String fabricacaoEstado;
    protected String fabricacaoLocalidade;
    protected String material;
    protected double peso;
    protected double altura;
    protected String estadoConservacao;
    protected String marcasInscricoes;
    protected String status;

    public Instrumento(){
    }

    public Instrumento(UUID id, String nome, String nomesAdicionais, String modelo, String categoria, String procedencia,
            String descricao, LocalDate dataFabricacao, String fabricante, String fabricacaoPais, String fabricacaoCidade,
            String fabricacaoEstado, String fabricacaoLocalidade, String material, double peso, double altura,
            String estadoConservacao, String marcasInscricoes, String status) {
        this.id = id;
        this.nome = nome;
        this.nomesAdicionais = nomesAdicionais;
        this.modelo = modelo;
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
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }
    public void setDataFabricacao(LocalDate dataFabricacao) {
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
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
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
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
