package model;

import java.util.UUID;

public class Notificacao {
    private UUID id;
    private OrdemServico ordemServico;
    
    
    public Notificacao(UUID id, OrdemServico ordemServico) {
        this.id = id;
        this.ordemServico = ordemServico;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
   
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }
    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
}
