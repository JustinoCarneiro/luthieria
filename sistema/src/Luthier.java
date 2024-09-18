import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;

public class Luthier {
    
    RepositorioCliente repositorioCliente;
    RepositorioInstrumento repositorioInstrumento;

    public Luthier() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioInstrumento = new RepositorioInstrumento();
    }

    public void inserir(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.inserir((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.inserir((Instrumento) objeto);
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

    public void remover(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.remover((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.remover((Instrumento) objeto);
        }
    }
}
