package com.asesoftware.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "SERVICIOS_X_MANTENIMIENTOS")
public class ServicioXMantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "tiempo_estimado")
    private Integer tiempoEstimado;

    @ManyToOne
    @JoinColumn(name = "cod_servicio")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "cod_mantenimiento")
    private Mantenimiento mantenimiento;

    // Getters y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Integer tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
}

