package com.asesoftware.prueba.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MANTENIMIENTOS")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cod_placa", referencedColumnName = "placa")
    private Vehiculo vehiculo;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "mec_documento", referencedColumnName = "documento"),
            @JoinColumn(name = "mec_tipo_documento", referencedColumnName = "tipo_documento")
    })
    private Mecanico mecanico;

    // Getters y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }
}

