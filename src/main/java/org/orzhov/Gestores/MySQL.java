package org.orzhov.Gestores;

import org.orzhov.Excepciones.GestorInvalidoException;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {
    private Connection conexion;

    public MySQL(String nombre, String usuario, String clave) throws GestorInvalidoException {
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombre + "?serverTimezone=UTC", usuario, clave);
            System.out.println("Conexión creada exitosamente");
        } catch (Exception ex) {
            throw new GestorInvalidoException("(MySQL) Error al crear la conexión");
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
