package repositorio;

import model.instrumento.Instrumento;

public interface IRepositorioInstrumento {
    public void inserir(Instrumento intrumento);
    public void remover(String idInstrumento);
    public void alterar(String idInstrumento, Instrumento intrumento);
}
