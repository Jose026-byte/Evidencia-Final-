package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DAOMedicionIMC;
import modelo.MedicionIMC;
import modelo.Usuario;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/CalculoIMCServlet")
public class CalculoIMCServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificar sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp?error=DebeIniciarSesion");
            return;
        }

        // Obtener datos del formulario
        double peso = Double.parseDouble(request.getParameter("peso"));
        double estatura = usuario.getEstatura();
        double imc = peso / (estatura * estatura);
        
        // Guardar medición en la BD
        MedicionIMC medicion = new MedicionIMC();
        medicion.setIdUsuario(usuario.getId());
        medicion.setPeso(peso);
        medicion.setEstatura(estatura);
        medicion.setValorIMC(imc);
        medicion.setFechaMedicion(LocalDate.now());

        DAOMedicionIMC dao = new DAOMedicionIMC();
        dao.registrarMedicion(medicion);

        // Redirigir a la vista de resultados
        response.sendRedirect("resultadoIMC.jsp");
    }
}

