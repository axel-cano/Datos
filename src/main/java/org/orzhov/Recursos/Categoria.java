package org.orzhov.Recursos;

public class Categoria {
    private int clave;
    private String nombre;
    private String descripcion;

    public Categoria(int clave, String nombre, String descripcion) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
