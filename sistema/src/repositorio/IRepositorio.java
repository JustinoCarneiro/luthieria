package repositorio;

import java.util.List;

//Interface responsável por declarar os métodos CRUD utilizados nas outras entidades
public interface IRepositorio <Objeto>{
    public void inserir(Objeto objeto);
    public void remover(Objeto objeto);
    public void alterar(Objeto objeto);
    public List<Objeto> listar();
}
