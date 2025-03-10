package modelo;

import utils.ConexionDB;
import java.sql.*;

public class DAOUsuario {
    
    public boolean registrarUsuario(Usuario u) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "INSERT INTO usuario(nombre_completo, nombre_usuario, password, edad, sexo, estatura) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombreCompleto());
            ps.setString(2, u.getNombreUsuario());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getEdad());
            ps.setString(5, u.getSexo());
            ps.setDouble(6, u.getEstatura());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario autenticarUsuario(String usuario, String password) {
        Usuario u = null;
        try (Connection con = ConexionDB.conectar()) {
            String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
                u.setNombreUsuario(usuario);
                u.setPassword(rs.getString("password"));
                u.setEdad(rs.getInt("edad"));
                u.setSexo(rs.getString("sexo"));
                u.setEstatura(rs.getDouble("estatura"));
            }
        } catch (SQLException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
        }
        return u;
    }
}
