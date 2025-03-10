package modelo;

import utils.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMedicionIMC {

    public boolean registrarMedicion(MedicionIMC medicion) {
        try (Connection con = ConexionDB.conectar()) {
            String sql = "INSERT INTO medicion_imc (id_usuario, peso, estatura, valor_imc, fecha_medicion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, medicion.getIdUsuario());
            ps.setDouble(2, medicion.getPeso());
            ps.setDouble(3, medicion.getEstatura());
            ps.setDouble(4, medicion.getValorIMC());
            ps.setDate(5, Date.valueOf(medicion.getFechaMedicion()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar medición: " + e.getMessage());
            return false;
        }
    }

    public List<MedicionIMC> obtenerHistorialPorUsuario(int idUsuario) {
        List<MedicionIMC> historial = new ArrayList<>();
        try (Connection con = ConexionDB.conectar()) {
            String sql = "SELECT * FROM medicion_imc WHERE id_usuario = ? ORDER BY fecha_medicion DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MedicionIMC medicion = new MedicionIMC();
                medicion.setId(rs.getInt("id"));
                medicion.setIdUsuario(rs.getInt("id_usuario"));
                medicion.setPeso(rs.getDouble("peso"));
                medicion.setEstatura(rs.getDouble("estatura"));
                medicion.setValorIMC(rs.getDouble("valor_imc"));
                medicion.setFechaMedicion(rs.getDate("fecha_medicion").toLocalDate());
                historial.add(medicion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener historial de IMC: " + e.getMessage());
        }
        return historial;
    }
}
