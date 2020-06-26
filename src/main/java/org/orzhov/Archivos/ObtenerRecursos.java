package org.orzhov.Archivos;

import org.json.simple.JSONObject;
import org.orzhov.Recursos.*;

import java.util.ArrayList;

public class ObtenerRecursos {
    private ArrayList<Aula> aulas = new ArrayList<>();
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private ArrayList<Materia> materias = new ArrayList<>();
    private ArrayList<PlanEstudio> planEstudios = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();


    public ObtenerRecursos(LecturaExcel archivo) {
        ArrayList<ArrayList<String>> filas = archivo.getFilas();

        for (ArrayList<String> fila : filas) {

            switch (fila.get(0).toLowerCase()) {
                case "aula":
                    aulas.add(new Aula(fila.get(1), fila.get(2), fila.get(3), Integer.parseInt(fila.get(4)), fila.get(5), fila.get(6)));
                    break;
                case "carrera":
                    carreras.add(new Carrera(Integer.parseInt(fila.get(1)), fila.get(2)));
                    break;
                case "categoria":
                    categorias.add(new Categoria(Integer.parseInt(fila.get(1)), fila.get(2), fila.get(3)));
                    break;
                case "equipo":
                    equipos.add(new Equipo(Integer.parseInt(fila.get(1)), Integer.parseInt(fila.get(2)), fila.get(3), fila.get(4)));
                    break;
                case "grupo":
                    grupos.add(new Grupo(fila.get(1), Boolean.parseBoolean(fila.get(2))));
                    break;
                case "materia":
                    materias.add(new Materia(fila.get(1), fila.get(2), Integer.parseInt(fila.get(3)), Integer.parseInt(fila.get(4)), Integer.parseInt(fila.get(5)), fila.get(6), Integer.parseInt(fila.get(7)), fila.get(8)));
                    break;
                case "planestudio":
                    planEstudios.add(new PlanEstudio(fila.get(1), fila.get(2), fila.get(3), Integer.parseInt(fila.get(4))));
                    break;
                case "usuarios":
                    usuarios.add(new Usuario(fila.get(1), Integer.parseInt(fila.get(2)), fila.get(3), fila.get(4), fila.get(5)));
            }
        }
    }


    public ObtenerRecursos(LecturaJSON archivo) {
        ArrayList<JSONObject> objectos = archivo.getObjectos();

        for (JSONObject objecto : objectos) {
            switch (objecto.get("recurso").toString().toLowerCase()) {
                case "aula":
                    aulas.add(new Aula(objecto.get("clave").toString(), objecto.get("nombre").toString(), objecto.get("tipo").toString(), Integer.parseInt(objecto.get("capacidad").toString()), objecto.get("descripcion").toString(), objecto.get("ubicacion").toString()));
                    break;
                case "carrera":
                    carreras.add(new Carrera(Integer.parseInt(objecto.get("clave").toString()), objecto.get("nombre").toString()));
                    break;
                case "categoria":
                    categorias.add(new Categoria(Integer.parseInt(objecto.get("clave").toString()), objecto.get("nombre").toString(), objecto.get("descripcion").toString()));
                    break;
                case "equipo":
                    equipos.add(new Equipo(Integer.parseInt(objecto.get("idEquipo").toString()), Integer.parseInt(objecto.get("idCategoria").toString()), objecto.get("nombre").toString(), objecto.get("descripcion").toString()));
                    break;
                case "grupo":
                    grupos.add(new Grupo(objecto.get("clave").toString(), Boolean.parseBoolean(objecto.get("turno").toString())));
                    break;
                case "materia":
                    materias.add(new Materia(objecto.get("clave").toString(), objecto.get("nombre").toString(), Integer.parseInt(objecto.get("creditos").toString()), Integer.parseInt(objecto.get("cuatrimestre").toString()), Integer.parseInt(objecto.get("posicion").toString()), objecto.get("clavePlan").toString(), Integer.parseInt(objecto.get("horasSemana").toString()), objecto.get("tipoMateria").toString()));
                    break;
                case "planestudio":
                    planEstudios.add(new PlanEstudio(objecto.get("clave").toString(), objecto.get("nombre").toString(), objecto.get("nivel").toString(), Integer.parseInt(objecto.get("id").toString())));
                    break;
                case "usuario":
                    usuarios.add(new Usuario(objecto.get("clave").toString(), Integer.parseInt(objecto.get("idCarrera").toString()), objecto.get("nombre").toString(), objecto.get("nivel").toString(), objecto.get("contrato").toString()));
            }
        }
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public ArrayList<PlanEstudio> getPlanEstudios() {
        return planEstudios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
