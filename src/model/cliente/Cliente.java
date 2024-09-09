package model.cliente;

import java.util.UUID;

public abstract class Cliente {
    private UUID id;
    protected String nomeCompleto;
    protected String dataNascimento;
    protected String telefoneFixo;
    protected String telefoneCelular;
    protected String email;
    protected String cep;
    protected String endereco;
    protected String numeroLocal;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected String país;
    protected String cepCobranca;
    protected String enderecoCobranca;
    protected String numeroLocalCobranca;
    protected String complementoCobranca;
    protected String bairroCobranca;
    protected String cidadeCobranca;
    protected String estadoCobranca;
    protected String paísCobranca;

    public Cliente(UUID id, String nomeCompleto, String dataNascimento, String telefoneFixo, String telefoneCelular,
            String email, String cep, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String país, String cepCobranca, String enderecoCobranca,
            String numeroLocalCobranca, String complementoCobranca, String bairroCobranca, String cidadeCobranca,
            String estadoCobranca, String paísCobranca){
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroLocal = numeroLocal;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.país = país;
        this.cepCobranca = cepCobranca;
        this.enderecoCobranca = enderecoCobranca;
        this.numeroLocalCobranca = numeroLocalCobranca;
        this.complementoCobranca = complementoCobranca;
        this.bairroCobranca = bairroCobranca;
        this.cidadeCobranca = cidadeCobranca;
        this.estadoCobranca = estadoCobranca;
        this.paísCobranca = paísCobranca;
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
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTelefoneFixo() {
        return telefoneFixo;
    }
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
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
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
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
    public String getPaís() {
        return país;
    }
    public void setPaís(String país) {
        this.país = país;
    }
    public String getCepCobranca() {
        return cepCobranca;
    }
    public void setCepCobranca(String cepCobranca) {
        this.cepCobranca = cepCobranca;
    }
    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }
    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }
    public String getNumeroLocalCobranca() {
        return numeroLocalCobranca;
    }
    public void setNumeroLocalCobranca(String numeroLocalCobranca) {
        this.numeroLocalCobranca = numeroLocalCobranca;
    }
    public String getComplementoCobranca() {
        return complementoCobranca;
    }
    public void setComplementoCobranca(String complementoCobranca) {
        this.complementoCobranca = complementoCobranca;
    }
    public String getBairroCobranca() {
        return bairroCobranca;
    }
    public void setBairroCobranca(String bairroCobranca) {
        this.bairroCobranca = bairroCobranca;
    }
    public String getCidadeCobranca() {
        return cidadeCobranca;
    }
    public void setCidadeCobranca(String cidadeCobranca) {
        this.cidadeCobranca = cidadeCobranca;
    }
    public String getEstadoCobranca() {
        return estadoCobranca;
    }
    public void setEstadoCobranca(String estadoCobranca) {
        this.estadoCobranca = estadoCobranca;
    }
    public String getPaísCobranca() {
        return paísCobranca;
    }
    public void setPaísCobranca(String paísCobranca) {
        this.paísCobranca = paísCobranca;
    }
}
