package com.asesoftware.prueba.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Mantenimiento> mantenimientos;
    private Double totalRepuestos;
    private Double totalServicios;
    private Double totalFactura;
    private Double iva;
    private Double totalConIva;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Double getTotalRepuestos() {
        return totalRepuestos;
    }

    public void setTotalRepuestos(Double totalRepuestos) {
        this.totalRepuestos = totalRepuestos;
    }

    public Double getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(Double totalServicios) {
        this.totalServicios = totalServicios;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalConIva() {
        return totalConIva;
    }

    public void setTotalConIva(Double totalConIva) {
        this.totalConIva = totalConIva;
    }
}