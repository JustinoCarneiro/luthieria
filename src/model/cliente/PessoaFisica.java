package model.cliente;

import java.util.UUID;

public class PessoaFisica extends Cliente{
    private String cpf;

    public PessoaFisica(UUID id, String nomeCompleto, String dataNascimento, String telefoneFixo, String telefoneCelular,
            String email, String cep, String endereco, String numeroLocal, String complemento, String bairro,
            String cidade, String estado, String país, String cepCobranca, String enderecoCobranca,
            String numeroLocalCobranca, String complementoCobranca, String bairroCobranca, String cidadeCobranca,
            String estadoCobranca, String paísCobranca, String cpf) {
                
        super(id, nomeCompleto, dataNascimento, telefoneFixo, telefoneCelular, email, cep, endereco, numeroLocal,
                complemento, bairro, cidade, estado, país, cepCobranca, enderecoCobranca, numeroLocalCobranca,
                complementoCobranca, bairroCobranca, cidadeCobranca, estadoCobranca, paísCobranca);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
