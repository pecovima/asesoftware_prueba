package com.asesoftware.prueba.model;

import javax.persistence.*;

@Entity
@Table(name = "REPUESTOS")
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre_repuesto", length = 100)
    private String nombreRepuesto;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "unidades_inventario")
    private Integer unidadesInventario;

    @Column(name = "proveedor", length = 300)
    private String proveedor;

    // Getters y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getUnidadesInventario() {
        return unidadesInventario;
    }

    public void setUnidadesInventario(Integer unidadesInventario) {
        this.unidadesInventario = unidadesInventario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
