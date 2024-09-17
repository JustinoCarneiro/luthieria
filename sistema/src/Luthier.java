import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;
import repositorio.RepositorioCliente;

public class Luthier {
    
    RepositorioCliente repositorioCliente;

    public Luthier() {
        this.repositorioCliente = new RepositorioCliente();
    }

    public void inserir(Cliente cliente){
        repositorioCliente.inserir(cliente);
    }

    public void listar(){
        List<Cliente> clientes = new ArrayList<>();

        clientes = repositorioCliente.listar();

        for(int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i));
        }
    }

    public void remover(Cliente cliente){
        repositorioCliente.remover(cliente);
    }
}
