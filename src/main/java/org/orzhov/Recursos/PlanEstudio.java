package org.orzhov.Recursos;

public class PlanEstudio {
    private String clave;
    private String nombre;
    private String nivel;
    private int id;

    public PlanEstudio(String clave, String nombre, String nivel, int id) {
        this.clave = clave;
        this.nombre = nombre;
        this.nivel = nivel;
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public int getId() {
        return id;
    }
}
