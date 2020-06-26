package org.orzhov.Recursos;

public class Usuario {
    private String clave;
    private int idCarrera;
    private String nombre;
    private String nivel;
    private String contrato;


    public Usuario(String clave, int idCarrera, String nombre, String nivel, String contrato) {
        this.clave = clave;
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.nivel = nivel;
        this.contrato = contrato;
    }

    public String getClave() {
        return clave;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public String getContrato() {
        return contrato;
    }
}
