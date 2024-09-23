package model.cliente;

import java.time.LocalDate;
import java.util.UUID;

public class PessoaFisica extends Cliente{
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(UUID id, String nomeCompleto, LocalDate dataNascimento, String telefoneCelular,
            String email, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String cpf) {
                
        super(id, nomeCompleto, telefoneCelular, email, endereco, numeroLocal,
                complemento, bairro, cidade, estado);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "PessoaFisica { " +
                "id=" + getId() +
                ", nomeCompleto='" + getNomeCompleto() + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", telefoneCelular='" + getTelefoneCelular() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", numeroLocal='" + getNumeroLocal() + '\'' +
                ", complemento='" + getComplemento() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                '}';
    }
}
