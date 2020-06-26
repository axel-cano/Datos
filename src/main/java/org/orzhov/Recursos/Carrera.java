package org.orzhov.Recursos;

public class Carrera {
    private int clave;
    private String nombre;

    public Carrera(int clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
}
