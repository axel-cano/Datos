package org.orzhov.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Borrar {
    public static void borrarColumnas(Connection conexion, String nombreTabla, String nombreColumna, String id) {
        try {
            PreparedStatement preparacion;
            ResultSet resultado;

            String sentencia = "DELETE FROM " + nombreTabla + " WHERE " + nombreColumna + " = '" + id + "';";
            preparacion = conexion.prepareStatement(sentencia);
            preparacion.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Revisa el estado de la conexión");
        }
    }
}
