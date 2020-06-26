package org.orzhov.Recursos;

public class Equipo {
    private int idEquipo;
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Equipo(int idEquipo, int idCategoria, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
