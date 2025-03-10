package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DAOUsuario;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los datos del formulario
        String nombreCompleto = request.getParameter("nombreCompleto");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));

        // Validaciones básicas
        if (edad < 15 || estatura < 1 || estatura > 2.5) {
            response.sendRedirect("registro.jsp?error=DatosInvalidos");
            return;
        }

        // Encriptar la contraseña con BCrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Crear objeto Usuario
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(hashedPassword);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setEstatura(estatura);

        // Guardar en la base de datos
        DAOUsuario dao = new DAOUsuario();
        boolean registrado = dao.registrarUsuario(usuario);

        // Redirigir según el resultado
        if (registrado) {
            response.sendRedirect("login.jsp?success=RegistroExitoso");
        } else {
            response.sendRedirect("registro.jsp?error=RegistroFallido");
        }
    }
}

