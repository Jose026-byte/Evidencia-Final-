package modelo;

public class Usuario {
    private int id;
    private String nombreCompleto;
    private String nombreUsuario;
    private String password;
    private int edad;
    private String sexo;
    private double estatura;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(int id, String nombreCompleto, String nombreUsuario, String password, int edad, String sexo, double estatura) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }
}
