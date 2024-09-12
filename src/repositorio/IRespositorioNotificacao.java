package repositorio;

import model.Notificacao;

public interface IRespositorioNotificacao {
    public void inserir(Notificacao notificacao);
    public void remover(String idNotificacao);
    public void alterar(String idNotificacao, Notificacao notificacao);
}
