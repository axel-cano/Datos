package org.orzhov.Gestores;

import org.orzhov.Excepciones.GestorInvalidoException;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;

public class PostgresSQL {
    private Connection conexion;

    public PostgresSQL(String[] hosts, String nombre, String usuario, String clave) throws GestorInvalidoException {
        try {
            PGSimpleDataSource source = new PGSimpleDataSource();

            source.setServerNames(hosts);
            source.setDatabaseName(nombre);
            source.setUser(usuario);
            source.setPassword(clave);

            this.conexion = source.getConnection();
        } catch (Exception ex) {
            throw new GestorInvalidoException("(PostgresSQL) Error al crear la conexión");
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
