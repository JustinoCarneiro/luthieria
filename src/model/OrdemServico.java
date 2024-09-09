package model;

import java.util.UUID;
import java.util.Vector;

import model.cliente.Cliente;
import model.instrumento.Instrumento;

public class OrdemServico {
    private UUID id;
    private Integer codigo;
    private String tipoServico;
    private Instrumento instrumento;
    private Cliente cliente;
    private double valorServico;
    private Vector<String> pecas;

    public OrdemServico(UUID id, Integer codigo, String tipoServico, Instrumento instrumento, Cliente cliente,
            double valorServico, Vector<String> pecas) {
        this.id = id;
        this.codigo = codigo;
        this.tipoServico = tipoServico;
        this.instrumento = instrumento;
        this.cliente = cliente;
        this.valorServico = valorServico;
        this.pecas = pecas;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    public Instrumento getInstrumento() {
        return instrumento;
    }
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getValorServico() {
        return valorServico;
    }
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
    public Vector<String> getPecas() {
        return pecas;
    }
    public void setPecas(Vector<String> pecas) {
        this.pecas = pecas;
    }


}
