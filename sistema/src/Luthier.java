import java.util.ArrayList;
import java.util.List;

import model.OrdemServico;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;
import repositorio.RepositorioOrdemServico;

public class Luthier {
    
    RepositorioCliente repositorioCliente;
    RepositorioInstrumento repositorioInstrumento;
    RepositorioOrdemServico repositorioOrdemServico;

    public Luthier() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioInstrumento = new RepositorioInstrumento();
        this.repositorioOrdemServico = new RepositorioOrdemServico();
    }

    public void inserir(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.inserir((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.inserir((Instrumento) objeto);
        } else if(objeto instanceof OrdemServico){
            repositorioOrdemServico.inserir((OrdemServico) objeto);
        }
    }

    public void listarClientes(){
        List<Cliente> clientes = new ArrayList<>();

        clientes = repositorioCliente.listar();

        for(int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i));
        }
    }

    public void listarInstrumentos(){
        List<Instrumento> instrumentos = new ArrayList<>();

        instrumentos = repositorioInstrumento.listar();
    
        for(int i=0; i<instrumentos.size(); i++){
            System.out.println(instrumentos.get(i));
        }
    }

    public void listarOrdensServicos(){
        List<OrdemServico> ordensservicos = new ArrayList<>();

        ordensservicos = repositorioOrdemServico.listar();

        for(int i=0; i<ordensservicos.size(); i++){
            System.out.println(ordensservicos.get(i));
        }
    }

    public void remover(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.remover((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.remover((Instrumento) objeto);
        } else if(objeto instanceof OrdemServico){
            repositorioOrdemServico.remover((OrdemServico) objeto);
        }
    }
}
