package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DAOUsuario;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener credenciales del formulario
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        // Buscar usuario en BD
        DAOUsuario dao = new DAOUsuario();
        Usuario usuario = dao.autenticarUsuario(nombreUsuario, password);

        if (usuario != null) {
            // Iniciar sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("formIMC.jsp");
        } else {
            // Credenciales incorrectas
            response.sendRedirect("login.jsp?error=CredencialesInvalidas");
        }
    }
}
