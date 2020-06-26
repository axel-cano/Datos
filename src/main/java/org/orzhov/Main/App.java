package org.orzhov.Main;

import org.json.simple.JSONObject;
import org.orzhov.Archivos.LecturaExcel;
import org.orzhov.Archivos.LecturaJSON;
import org.orzhov.Archivos.ObtenerRecursos;
import org.orzhov.CRUD.Actualizar;
import org.orzhov.CRUD.Alta;
import org.orzhov.CRUD.Borrar;
import org.orzhov.CRUD.Lectura;
import org.orzhov.Excepciones.ConfigFormatoInvalidoException;
import org.orzhov.Excepciones.GestorInvalidoException;
import org.orzhov.Gestores.MySQL;
import org.orzhov.Gestores.PostgresSQL;
import org.orzhov.Gestores.SQLite;

import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws ConfigFormatoInvalidoException {
        String config = System.getProperty("configFile");
        Connection bd = crearConexion();

        if (bd != null) {
            try {
                controladorArchivoDeConfiguración(bd, config);
            } catch (Exception ex) {
                System.out.println("El archivo de configuración es invalido");
            }
        }
    }


    private static Connection crearConexion() {
        String config = System.getProperty("configFile");

        if (config != null && !config.equals("")) {
            try {
                LecturaJSON json = new LecturaJSON(config);
                JSONObject objecto = json.getObjectos().get(0);
                String hosts, nombre, usuario, clave;

                hosts = objecto.get("hosts").toString();
                nombre = objecto.get("nombre").toString();
                usuario = objecto.get("usuario").toString();
                clave = objecto.get("clave").toString();

                return seleccionarGestor(hosts, nombre, usuario, clave);
            } catch (Exception ex) {
                System.out.println("Error al intentar crear la conexión");
                return null;
            }
        } else {
            try (Scanner sc = new Scanner(System.in)) {
                String hosts, nombre, usuario, clave;

                System.out.println("Hosts: ");
                hosts = sc.nextLine();

                System.out.println("Nombre: ");
                nombre = sc.nextLine();

                System.out.println("Usuario: ");
                usuario = sc.nextLine();

                System.out.println("Clave: ");
                clave = sc.nextLine();

                return seleccionarGestor(hosts, nombre, usuario, clave);
            } catch (Exception ex) {
                System.out.println("Error al intentar crear la conexión");
                return null;
            }
        }
    }


    private static Connection seleccionarGestor(String hosts, String nombre, String usuario, String clave) {
        if (!hosts.equals("")) {
            String[] hostsLista = hosts.split(" ");

            try {
                PostgresSQL bd = new PostgresSQL(hostsLista, nombre, usuario, clave);
                return bd.getConexion();
            } catch (GestorInvalidoException ex) {
                SQLite bd = new SQLite();
                bd.crearTablas(bd.getConexion());
                return bd.getConexion();
            }
        } else {
            try {
                MySQL bd = new MySQL(nombre, usuario, clave);
                return bd.getConexion();
            } catch (GestorInvalidoException ex) {
                SQLite bd = new SQLite();
                bd.crearTablas(bd.getConexion());
                return bd.getConexion();
            }
        }
    }


    private static void controladorArchivoDeConfiguración(Connection conexion, String ruta) throws ConfigFormatoInvalidoException {
        try {
            LecturaJSON json = new LecturaJSON(ruta);
            JSONObject objecto = json.getObjectos().get(0);
            String archivo, recurso, accion;

            archivo = objecto.get("ruta").toString();
            recurso = objecto.get("recursos").toString();
            accion = objecto.get("accion").toString();

            if (accion.equals("lectura")) {
                Lectura.leerColumnas(conexion, recurso);
            } else if (accion.equals("borrar")) {
                String id;
                Scanner sc = new Scanner(System.in);
                System.out.println("ID: ");
                id = sc.nextLine();

                switch (recurso) {
                    case "aula":
                        Borrar.borrarColumnas(conexion, "aulas", "id_aula", id);
                        break;
                    case "carrera":
                        Borrar.borrarColumnas(conexion, "carrera", "idcarrera", id);
                        break;
                    case "categoria":
                        Borrar.borrarColumnas(conexion, "categorias_equipo", "id_categoria", id);
                        break;
                    case "equipo":
                        Borrar.borrarColumnas(conexion, "equipo", "id_equipo", id);
                        break;
                    case "grupo":
                        Borrar.borrarColumnas(conexion, "grupos", "clv_grupo", id);
                        break;
                    case "materia":
                        Borrar.borrarColumnas(conexion, "materia_usuario", "clv_materia", id);
                        break;
                    case "planestudios":
                        Borrar.borrarColumnas(conexion, "plan_estudios", "clv_plan", id);
                        break;
                    case "usuario":
                        Borrar.borrarColumnas(conexion, "usuarios", "clv_usuario", id);
                        break;
                }
            } else if (accion.equals("alta")) {
                if (archivo.contains("json")) {
                    ObtenerRecursos recursos = new ObtenerRecursos(new LecturaJSON(archivo));
                    switch (recurso) {
                        case "aula":
                            Alta.cargarAulas(conexion, recursos.getAulas());
                            break;
                        case "carrera":
                            Alta.cargarCarreras(conexion, recursos.getCarreras());
                            break;
                        case "categoria":
                            Alta.cargarCategorias(conexion, recursos.getCategorias());
                            break;
                        case "equipo":
                            Alta.cargarEquipos(conexion, recursos.getEquipos());
                            break;
                        case "grupo":
                            Alta.cargarGrupos(conexion, recursos.getGrupos());
                            break;
                        case "materia":
                            Alta.cargarMaterias(conexion, recursos.getMaterias());
                            break;
                        case "planestudios":
                            Alta.cargarPlanEstudio(conexion, recursos.getPlanEstudios());
                            break;
                        case "usuario":
                            Alta.cargarUsuarios(conexion, recursos.getUsuarios());
                            break;
                    }
                } else if (archivo.contains("xlsx")) {
                    ObtenerRecursos recursos = new ObtenerRecursos(new LecturaExcel(archivo));

                    switch (recurso) {
                        case "aula":
                            Alta.cargarAulas(conexion, recursos.getAulas());
                            break;
                        case "carrera":
                            Alta.cargarCarreras(conexion, recursos.getCarreras());
                            break;
                        case "categoria":
                            Alta.cargarCategorias(conexion, recursos.getCategorias());
                            break;
                        case "equipo":
                            Alta.cargarEquipos(conexion, recursos.getEquipos());
                            break;
                        case "grupo":
                            Alta.cargarGrupos(conexion, recursos.getGrupos());
                            break;
                        case "materia":
                            Alta.cargarMaterias(conexion, recursos.getMaterias());
                            break;
                        case "planestudios":
                            Alta.cargarPlanEstudio(conexion, recursos.getPlanEstudios());
                            break;
                        case "usuario":
                            Alta.cargarUsuarios(conexion, recursos.getUsuarios());
                            break;
                    }
                }
            } else if (accion.equals("actualizar")) {
                String id;
                Scanner sc = new Scanner(System.in);
                System.out.println("ID: ");
                id = sc.nextLine();

                if (archivo.contains("json")) {
                    ObtenerRecursos recursos = new ObtenerRecursos(new LecturaJSON(archivo));
                    switch (recurso) {
                        case "aula":
                            Actualizar.actualizarAulas(conexion, recursos.getAulas(), id);
                            break;
                        case "carrera":
                            Actualizar.actualizarCarreras(conexion, recursos.getCarreras(), id);
                            break;
                        case "categoria":
                            Actualizar.actualizarCategorias(conexion, recursos.getCategorias(), id);
                            break;
                        case "equipo":
                            Actualizar.actualizarEquipos(conexion, recursos.getEquipos(), id);
                            break;
                        case "grupo":
                            Actualizar.actualizarGrupos(conexion, recursos.getGrupos(), id);
                            break;
                        case "planestudios":
                            Actualizar.actualizarPlanEstudio(conexion, recursos.getPlanEstudios(), id);
                            break;
                        case "usuario":
                            Actualizar.actualizarUsuarios(conexion, recursos.getUsuarios(), id);
                            break;
                    }
                } else if (archivo.contains("xlsx")) {
                    ObtenerRecursos recursos = new ObtenerRecursos(new LecturaExcel(archivo));

                    switch (recurso) {
                        case "aula":
                            Actualizar.actualizarAulas(conexion, recursos.getAulas(), id);
                            break;
                        case "carrera":
                            Actualizar.actualizarCarreras(conexion, recursos.getCarreras(), id);
                            break;
                        case "categoria":
                            Actualizar.actualizarCategorias(conexion, recursos.getCategorias(), id);
                            break;
                        case "equipo":
                            Actualizar.actualizarEquipos(conexion, recursos.getEquipos(), id);
                            break;
                        case "grupo":
                            Actualizar.actualizarGrupos(conexion, recursos.getGrupos(), id);
                            break;
                        case "planestudios":
                            Actualizar.actualizarPlanEstudio(conexion, recursos.getPlanEstudios(), id);
                            break;
                        case "usuario":
                            Actualizar.actualizarUsuarios(conexion, recursos.getUsuarios(), id);
                            break;
                    }
                }

            }


        } catch (Exception ex) {
            throw new ConfigFormatoInvalidoException("Archivo no valido");
        }
    }

}
