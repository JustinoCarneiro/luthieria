package repositorio;

import model.OrdemServico;

public interface IRepositorioOrdemServico {
    public void inserir(OrdemServico ordemServico);
    public void remover(String codigoOrdemServico);
    public void alterar(String codigoOrdemServico, OrdemServico ordemServico);
}
