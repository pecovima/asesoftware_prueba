package com.asesoftware.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "FOTOS")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "ruta", length = 200)
    private String ruta;

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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
}
