package org.orzhov.Recursos;

public class Materia {
    private String clave;
    private String nombre;
    private int creditos;
    private int cuatrimestre;
    private int posicion;
    private String clavePlan;
    private int horasSemana;
    private String tipoMateria;


    public Materia(String clave, String nombre, int creditos, int cuatrimestre, int posicion, String clavePlan, int horasSemana, String tipoMateria) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cuatrimestre = cuatrimestre;
        this.posicion = posicion;
        this.clavePlan = clavePlan;
        this.horasSemana = horasSemana;
        this.tipoMateria = tipoMateria;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getClavePlan() {
        return clavePlan;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public String getTipoMateria() {
        return tipoMateria;
    }
}
