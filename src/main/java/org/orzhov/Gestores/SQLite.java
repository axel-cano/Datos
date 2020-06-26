package org.orzhov.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {
    private Connection conexion;

    public SQLite() {
        try {
            String sqlite = "jdbc:sqlite:files/bd.sql";
            this.conexion = DriverManager.getConnection(sqlite);
        } catch (Exception ex) {
            System.out.println("SQlite tuvo que ser creado en memoria");
            try {
                this.conexion = DriverManager.getConnection("jdbc:sqlite::memory:");
            } catch (SQLException ex1) {
                System.out.println("SQlite no pudo ser creado en memoria");

            }
        }
    }


    public void crearTablas(Connection conexion) {
        try {
            Statement statement = conexion.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DROP TABLE IF EXISTS aulas;");
            statement.executeUpdate("DROP TABLE IF EXISTS carrera;");
            statement.executeUpdate("DROP TABLE IF EXISTS categorias_equipo;");
            statement.executeUpdate("DROP TABLE IF EXISTS equipo;");
            statement.executeUpdate("DROP TABLE IF EXISTS grupos;");
            statement.executeUpdate("DROP TABLE IF EXISTS materias;");
            statement.executeUpdate("DROP TABLE IF EXISTS plan_estudios;");
            statement.executeUpdate("DROP TABLE IF EXISTS usuarios;");


            statement.executeUpdate("CREATE TABLE aulas(\n" +
                    "    id_aula VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    nombre VARCHAR(100) NOT NULL,\n" +
                    "    tipo VARCHAR(20) NOT NULL,\n" +
                    "    capacidad INT(11) NOT NULL,\n" +
                    "    descripcion VARCHAR(100) NULL,\n" +
                    "    ubicacion VARCHAR(20) NULL\n" +
                    ");");

            statement.executeUpdate("CREATE TABLE carrera(\n" +
                    "    idcarrera TINYINT NOT NULL PRIMARY KEY,\n" +
                    "    nombre_carrera VARCHAR(100)\n" +
                    ");");

            statement.executeUpdate("CREATE TABLE categorias_equipo(\n" +
                    "    id_categoria INT(11) NOT NULL PRIMARY KEY,\n" +
                    "    nombre VARCHAR(100) NOT NULL,\n" +
                    "    descripcion VARCHAR(300)\n" +
                    ");");

            statement.executeUpdate("CREATE TABLE equipo(\n" +
                    "    id_equipo INT(11) NOT NULL PRIMARY KEY,\n" +
                    "    id_categoria INT(11) NOT NULL,\n" +
                    "    nombre VARCHAR(100) NOT NULL,\n" +
                    "    descripcion VARCHAR(100) NOT NULL,\n" +
                    "    CONSTRAINT FK_equipo_categoriaequipo_id_categoria FOREIGN KEY (id_categoria) REFERENCES categorias_equipo(id_categoria)\n" +
                    ");\n");

            statement.executeUpdate("CREATE TABLE grupos(\n" +
                    "    clv_grupo VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    turno BOOLEAN  \n" +
                    ");");

            statement.executeUpdate("CREATE TABLE plan_estudios(\n" +
                    "    clv_plan VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    nombre_plan VARCHAR(45) NOT NULL,\n" +
                    "    nivel VARCHAR(3) NOT NULL, -- falta el check\n" +
                    "    idcarrera TINYINT NOT NULL, \n" +
                    "    CONSTRAINT FK_planestudios_carrera_idcarrera FOREIGN KEY (idcarrera) REFERENCES carrera (idcarrera)      \n" +
                    "    );");

            statement.executeUpdate("CREATE TABLE usuarios(\n" +
                    "    clv_usuario VARCHAR(50) NOT NULL PRIMARY KEY,\n" +
                    "    idcarrera TINYINT NOT NULL,\n" +
                    "    nombre_usuario VARCHAR(50),\n" +
                    "    nivel_ads VARCHAR(5) NOT NULL, -- falta el check\n" +
                    "    contrato VARCHAR(3) NOT NULL,   -- falta el check\n" +
                    "    CONSTRAINT FK_usuarios_carrera_idcarrera FOREIGN KEY (idcarrera) REFERENCES carrera(idcarrera)  ON DELETE NO ACTION ON UPDATE CASCADE\n" +
                    ");");
        } catch (Exception SQLException) {
            System.out.println("Inaccesible");
        }
    }


    public Connection getConexion() {
        return conexion;
    }
}
