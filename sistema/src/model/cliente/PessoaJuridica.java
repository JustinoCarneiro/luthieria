package model.cliente;

import java.util.UUID;

public class PessoaJuridica extends Cliente{
    private String razaoSocial;
    private String inscricaoEstadual;
    private String cnpj;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(UUID id, String nomeCompleto, String telefoneCelular,
            String email, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String razaoSocial, String inscricaoEstadual, String cnpj) {
        super(id, nomeCompleto, telefoneCelular, email, endereco, numeroLocal,
                complemento, bairro, cidade, estado);
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

    @Override
    public String toString() {
        return "PessoaJuridica { " +
                "id=" + getId() +
                ", nomeCompleto='" + getNomeCompleto() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefoneCelular='" + getTelefoneCelular() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", numeroLocal='" + getNumeroLocal() + '\'' +
                ", complemento='" + getComplemento() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", inscricaoEstadual='" + getInscricaoEstadual() + '\'' +
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                '}';
    }
}
