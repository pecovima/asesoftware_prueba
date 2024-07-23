package com.asesoftware.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {
    @Id
    @Column(name = "placa", length = 6)
    private String placa;

    @Column(name = "color", length = 20)
    private String color;

    @ManyToOne
    @JoinColumn(name = "cod_marca", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cli_documento", referencedColumnName = "documento"),
            @JoinColumn(name = "cli_tipo_documento", referencedColumnName = "tipo_documento")
    })
    private Cliente cliente;

    // Getters y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

