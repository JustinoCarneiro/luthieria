package repositorio;

import java.util.UUID;
import java.util.List;

public interface IRepositorio <Objeto>{
    public void inserir(Objeto objeto);
    public void remover(Objeto objeto);
    public void alterar(UUID id, Objeto objeto);
    public List<Objeto> listar();
}
