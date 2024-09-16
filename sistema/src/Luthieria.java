import java.time.LocalDate;
import java.util.UUID;
import model.cliente.PessoaFisica;

public class Luthieria {
    public static void main(String[] args) throws Exception {
        Luthier luthier = new Luthier();

        // Gerando um UUID aleatório
        UUID id = UUID.randomUUID();

        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);

        PessoaFisica cliente = new PessoaFisica(
            id,                       
            "João da Silva",          
            dataNascimento,             
            "987654321",               
            "joao@example.com",        
            "Rua Exemplo",             
            "123",                    
            "Apto 101",                
            "Bairro Exemplo",          
            "Cidade Exemplo",         
            "Estado Exemplo",          
            "123.456.789-00"       
        );

        // Inserindo o cliente no repositório
        luthier.inserir(cliente);

        // Listando os clientes
        luthier.listar();
    }
}
