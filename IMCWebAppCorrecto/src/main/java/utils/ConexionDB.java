package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/imc_db";
    private static final String USER = "root"; // Cambia esto por tu usuario de MySQL
    private static final String PASS = "root"; // Cambia esto por tu contraseña

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver MySQL: " + ex.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
