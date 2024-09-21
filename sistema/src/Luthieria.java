import java.time.LocalDate;
import java.util.UUID;

import model.OrdemServico;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import model.instrumento.Aerofone;
import model.instrumento.Cordofone;
import model.instrumento.Idiofone;
import model.instrumento.Membranofone;

/*import javax.swing.JFrame;

import gui.JanelaPrincipal;*/

public class Luthieria {
    public static void main(String[] args) throws Exception {

        /*JanelaPrincipal frame = new JanelaPrincipal ("Teste 3");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);*/

        Luthier luthier = new Luthier();

        UUID idOrdemServico = UUID.randomUUID();
        UUID idFisica = UUID.randomUUID();
        UUID idJuridica = UUID.randomUUID();
        UUID idIdiofone = UUID.randomUUID();
        UUID idCordofone = UUID.randomUUID();
        UUID idAerofone = UUID.randomUUID();
        UUID idMembranofone = UUID.randomUUID();

        LocalDate dataNascimentoFisica = LocalDate.of(1990, 1, 1);
        LocalDate dataFabricacaoIdiofone = LocalDate.of(2023, 1, 1);
        LocalDate dataFabricacaoCordofone = LocalDate.of(2022, 5, 5);
        LocalDate dataFabricacaoAerofone = LocalDate.of(2021, 8, 8);
        LocalDate dataFabricacaoMembranofone = LocalDate.of(2020, 11, 11);

        PessoaFisica clienteFisica = new PessoaFisica(
            idFisica,                       
            "Maria da Dores",          
            dataNascimentoFisica,             
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

        Idiofone idiofone = new Idiofone(
            idIdiofone,
            "Triângulo",
            null,
            "modelo 1",
            "Idiofone",
            "Brasil",
            "Instrumento musical de percussão",
            dataFabricacaoIdiofone,
            "Fabricante Exemplo",
            "Brasil",
            "Cidade Exemplo",
            "Estado Exemplo",
            null,
            "Metal",
            0.5,
            0.3,
            "Ótimo",
            "Sem marcas",
            "Ativo",
            "Agitado com as mãos",
            "Metalofone"
        );

        Cordofone cordofone = new Cordofone(
            idCordofone,
            "Violão",
            null,
            "modelo 2",
            "Cordofone",
            "Brasil",
            "Instrumento musical de cordas",
            dataFabricacaoCordofone,
            "Fabricante Exemplo",
            "Brasil",
            "Cidade Exemplo",
            "Estado Exemplo",
            null,
            "Madeira",
            2.0,
            1.0,
            "Ótimo",
            "Sem marcas",
            "Ativo",
            6,
            "Nylon",
            "Dedilhado"
        );

        Aerofone aerofone = new Aerofone(
            idAerofone,
            "Flauta",
            null,
            "modelo 3",
            "Aerofone",
            "Brasil",
            "Instrumento musical de sopro",
            dataFabricacaoAerofone,
            "Fabricante Exemplo",
            "Brasil",
            "Cidade Exemplo",
            "Estado Exemplo",
            null,
            "Bambu",
            0.2,
            0.5,
            "Ótimo",
            "Sem marcas",
            "Ativo",
            "Bocal transversal",
            "Sopro direto",
            "Parafusos de ajuste"
        );

        Membranofone membranofone = new Membranofone(
            idMembranofone,
            "Tambor",
            null,
            "modelo 4",
            "Membranofone",
            "Brasil",
            "Instrumento musical de percussão com membrana",
            dataFabricacaoMembranofone,
            "Fabricante Exemplo",
            "Brasil",
            "Cidade Exemplo",
            "Estado Exemplo",
            null,
            "Couro",
            1.0,
            0.6,
            "Ótimo",
            "Sem marcas",
            "Ativo",
            "Membrana de animal",
            "Batida com baqueta",
            "Cordas de tensão"
        );


        UUID idInstrumentoString = UUID.fromString("fb83f066-162f-44a2-9fc0-3d8bc5202caf");
        UUID idFisicaString = UUID.fromString("2690581e-3688-4c55-a555-29a1ea5530e9");

        OrdemServico ordemServico = new OrdemServico(
            idOrdemServico,
            "12345", 
            "Conserto",
            idInstrumentoString, 
            idFisicaString, 
            500.0, 
            "Troca de peças", 
            "Em andamento", 
            "Descrição do status", 
            LocalDate.now().plusDays(7) 
        );

        luthier.inserir(clienteFisica);
        luthier.inserir(clienteJuridica);
        luthier.inserir(idiofone);
        luthier.inserir(cordofone);
        luthier.inserir(aerofone);
        luthier.inserir(membranofone);
        luthier.inserir(ordemServico);

        luthier.listarClientes();
        luthier.listarInstrumentos();
        luthier.listarOrdensServicos();

        UUID idOrdemServicoString = UUID.fromString("ed5b6154-7225-4717-8bfd-a86d93c29f21");
        
        System.out.println(idOrdemServico);
        System.out.println(luthier.gerarNotificacao(idOrdemServicoString));
    }
}
