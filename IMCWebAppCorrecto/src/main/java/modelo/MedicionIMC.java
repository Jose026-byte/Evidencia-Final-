package modelo;

import java.time.LocalDate;

public class MedicionIMC {
    private int id;
    private int idUsuario;
    private double peso;
    private double estatura;
    private double valorIMC;
    private LocalDate fechaMedicion;

    // Constructor vacío
    public MedicionIMC() {}

    // Constructor con parámetros
    public MedicionIMC(int id, int idUsuario, double peso, double estatura, double valorIMC, LocalDate fechaMedicion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.peso = peso;
        this.estatura = estatura;
        this.valorIMC = valorIMC;
        this.fechaMedicion = fechaMedicion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public double getValorIMC() { return valorIMC; }
    public void setValorIMC(double valorIMC) { this.valorIMC = valorIMC; }

    public LocalDate getFechaMedicion() { return fechaMedicion; }
    public void setFechaMedicion(LocalDate fechaMedicion) { this.fechaMedicion = fechaMedicion; }
}
