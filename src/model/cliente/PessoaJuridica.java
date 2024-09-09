package model.cliente;

import java.util.UUID;

public class PessoaJuridica extends Cliente{
    private String razaoSocial;
    private String inscricaoEstadual;
    private String cnpj;

    public PessoaJuridica(UUID id, String nomeCompleto, String dataNascimento, String telefoneFixo, String telefoneCelular,
            String email, String cep, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String país, String cepCobranca, String enderecoCobranca,
            String numeroLocalCobranca, String complementoCobranca, String bairroCobranca, String cidadeCobranca,
            String estadoCobranca, String paísCobranca, String razaoSocial, String inscricaoEstadual, String cnpj) {
        super(id, nomeCompleto, dataNascimento, telefoneFixo, telefoneCelular, email, cep, endereco, numeroLocal,
                complemento, bairro, cidade, estado, país, cepCobranca, enderecoCobranca, numeroLocalCobranca,
                complementoCobranca, bairroCobranca, cidadeCobranca, estadoCobranca, paísCobranca);
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnpj = cnpj;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
