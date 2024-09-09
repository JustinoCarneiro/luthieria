package model;

import java.util.UUID;

public class Notificacao {
    private UUID id;
    private String nomeInstrumento;
    private String nomePropietario;
    private String statusInstrumento;
    private String observacaoStatus;
    private String previsaoEntrega;
    private Integer ordemServico;
    private String necessidadeMateriais;
    
    public Notificacao(UUID id, String nomeInstrumento, String nomePropietario, String statusInstrumento,
            String observacaoStatus, String previsaoEntrega, Integer ordemServico, String necessidadeMateriais) {
        this.id = id;
        this.nomeInstrumento = nomeInstrumento;
        this.nomePropietario = nomePropietario;
        this.statusInstrumento = statusInstrumento;
        this.observacaoStatus = observacaoStatus;
        this.previsaoEntrega = previsaoEntrega;
        this.ordemServico = ordemServico;
        this.necessidadeMateriais = necessidadeMateriais;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNomeInstrumento() {
        return nomeInstrumento;
    }
    public void setNomeInstrumento(String nomeInstrumento) {
        this.nomeInstrumento = nomeInstrumento;
    }
    public String getNomePropietario() {
        return nomePropietario;
    }
    public void setNomePropietario(String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }
    public String getStatusInstrumento() {
        return statusInstrumento;
    }
    public void setStatusInstrumento(String statusInstrumento) {
        this.statusInstrumento = statusInstrumento;
    }
    public String getObservacaoStatus() {
        return observacaoStatus;
    }
    public void setObservacaoStatus(String observacaoStatus) {
        this.observacaoStatus = observacaoStatus;
    }
    public String getPrevisaoEntrega() {
        return previsaoEntrega;
    }
    public void setPrevisaoEntrega(String previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }
    public Integer getOrdemServico() {
        return ordemServico;
    }
    public void setOrdemServico(Integer ordemServico) {
        this.ordemServico = ordemServico;
    }
    public String getNecessidadeMateriais() {
        return necessidadeMateriais;
    }
    public void setNecessidadeMateriais(String necessidadeMateriais) {
        this.necessidadeMateriais = necessidadeMateriais;
    }

}
