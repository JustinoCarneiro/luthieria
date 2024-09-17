package repositorio;

import java.util.List;

public interface IRepositorio <Objeto>{
    public void inserir(Objeto objeto);
    public void remover(Objeto objeto);
    public void alterar(Objeto objeto);
    public List<Objeto> listar();
}
