package org.orzhov.Recursos;

public class Aula {
    private String clave;
    private String nombre;
    private String tipo;
    private int capacidad;
    private String descripcion;
    private String ubicacion;

    public Aula(String clave, String nombre, String tipo, int capacidad, String descripcion, String ubicacion) {
        this.clave = clave;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
