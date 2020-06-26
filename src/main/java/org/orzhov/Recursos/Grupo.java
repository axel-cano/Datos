package org.orzhov.Recursos;

public class Grupo {
    private String clave;
    private boolean turno;

    public Grupo(String clave, boolean turno) {
        this.clave = clave;
        this.turno = turno;
    }

    public String getClave() {
        return clave;
    }

    public boolean getTurno() {
        return turno;
    }
}
