package com.asesoftware.prueba.model;

import java.io.Serializable;
import java.util.Objects;

public class MecanicoId implements Serializable {
    private String tipoDocumento;
    private Integer documento;

    // Getters, setters, equals, and hashCode
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MecanicoId that = (MecanicoId) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(documento, that.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, documento);
    }
}

