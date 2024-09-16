package model.cliente;

import java.time.LocalDate;
import java.util.UUID;

public class PessoaFisica extends Cliente{
    private String cpf;

    public PessoaFisica(UUID id, String nomeCompleto, LocalDate dataNascimento, String telefoneCelular,
            String email, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String cpf) {
                
        super(id, nomeCompleto, dataNascimento, telefoneCelular, email, endereco, numeroLocal,
                complemento, bairro, cidade, estado);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                '}';
    }
}
