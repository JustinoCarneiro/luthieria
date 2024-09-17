import java.time.LocalDate;
import java.util.UUID;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;

public class Luthieria {
    public static void main(String[] args) throws Exception {
        Luthier luthier = new Luthier();

        UUID idFisica = UUID.randomUUID();
        UUID idJuridica = UUID.randomUUID();

        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);

        PessoaFisica clienteFisica = new PessoaFisica(
            idFisica,                       
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

        PessoaJuridica clienteJuridica = new PessoaJuridica(
            idJuridica,                      
            "Empresa Exemplo Ltda",        
            LocalDate.of(2000, 1, 1),     
            "987654321",                  
            "contato@empresa.com",         
            "Avenida Exemplo",              
            "456",                         
            "Sala 202",                    
            "Bairro Exemplo",              
            "Cidade Exemplo",             
            "Estado Exemplo",             
            "Razão Social Exemplo",       
            "123.456.789.000",            
            "12.345.678/0001-99"         
        );

        luthier.inserir(clienteFisica);
        luthier.inserir(clienteJuridica);

        luthier.listar();
    }
}
