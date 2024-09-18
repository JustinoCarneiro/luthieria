package model;

import java.time.LocalDate;
import java.util.UUID;

public class OrdemServico {
    private UUID id;
    private String codigo;
    private String tipoServico;
    private UUID idInstrumento;
    private UUID idCliente;
    private double valorServico;
    private String pecas;
    private String statusInstrumento;
    private String observacaoStatus;
    private LocalDate previsaoEntrega;

    public OrdemServico(UUID id, String codigo, String tipoServico, UUID idInstrumento, UUID idCliente,
            double valorServico, String pecas, String statusInstrumento, String observacaoStatus, LocalDate previsaoEntrega) {
        this.id = id;
        this.codigo = codigo;
        this.tipoServico = tipoServico;
        this.idInstrumento = idInstrumento;
        this.idCliente = idCliente;
        this.valorServico = valorServico;
        this.pecas = pecas;
        this.statusInstrumento = statusInstrumento;
        this.observacaoStatus = observacaoStatus;
        this.previsaoEntrega = previsaoEntrega;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    public UUID getIdInstrumento() {
        return idInstrumento;
    }
    public void setIdInstrumento(UUID idInstrumento) {
        this.idInstrumento = idInstrumento;
    }
    public UUID getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
    public double getValorServico() {
        return valorServico;
    }
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
    public String getPecas() {
        return pecas;
    }
    public void setPecas(String pecas) {
        this.pecas = pecas;
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

    public LocalDate getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalDate previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", tipoServico='" + tipoServico + '\'' +
                ", idInstrumento=" + idInstrumento +
                ", idCliente=" + idCliente +
                ", valorServico=" + valorServico +
                ", pecas='" + pecas + '\'' +
                ", statusInstrumento='" + statusInstrumento + '\'' +
                ", observacaoStatus='" + observacaoStatus + '\'' +
                ", previsaoEntrega=" + previsaoEntrega +
                '}';
    }
}
