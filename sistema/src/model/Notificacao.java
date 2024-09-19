package model;

import java.util.UUID;

public class Notificacao {
    private UUID id;
    private UUID idOrdemServico;
    
    public Notificacao(UUID id, UUID idOrdemServico) {
        this.id = id;
        this.idOrdemServico = idOrdemServico;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
   
    public UUID getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(UUID idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }
}
