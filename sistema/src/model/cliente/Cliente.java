package model.cliente;

import java.util.UUID;

public abstract class Cliente {
    private UUID id;
    protected String nomeCompleto;
    protected String telefoneCelular;
    protected String email;
    protected String endereco;
    protected String numeroLocal;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String estado;

    public Cliente(){
    }

    public Cliente(UUID id, String nomeCompleto, String telefoneCelular,
            String email, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado){
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.endereco = endereco;
        this.numeroLocal = numeroLocal;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getTelefoneCelular() {
        return telefoneCelular;
    }
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNumeroLocal() {
        return numeroLocal;
    }
    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
