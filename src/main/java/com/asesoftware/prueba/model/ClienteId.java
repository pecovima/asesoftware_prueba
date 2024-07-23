package com.asesoftware.prueba.model;

import java.io.Serializable;
import java.util.Objects;

public class ClienteId implements Serializable {
    private String tipoDocumento;
    private Integer documento;

    public ClienteId(String cc, int i) {
    }

    public ClienteId() {

    }

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
        ClienteId clienteId = (ClienteId) o;
        return Objects.equals(tipoDocumento, clienteId.tipoDocumento) &&
                Objects.equals(documento, clienteId.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, documento);
    }
}
