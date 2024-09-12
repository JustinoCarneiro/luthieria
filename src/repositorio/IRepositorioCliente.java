package repositorio;

import model.cliente.Cliente;

public interface IRepositorioCliente {
    public void inserir(Cliente cliente);
    public void remover(String idCliente);
    public void alterar(String idCliente, Cliente cliente);
}
