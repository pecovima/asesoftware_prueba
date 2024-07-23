package com.asesoftware.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "REPUESTOS_X_MANTENIMIENTOS")
public class RepuestoXMantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "unidades")
    private Integer unidades;

    @Column(name = "tiempo_estimado")
    private Integer tiempoEstimado;

    @ManyToOne
    @JoinColumn(name = "cod_mantenimiento")
    private Mantenimiento mantenimiento;

    @ManyToOne
    @JoinColumn(name = "cod_repuesto")
    private Repuesto repuesto;

    // Getters y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Integer tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }
}

