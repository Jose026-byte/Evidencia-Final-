<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="modelo.MedicionIMC"%>
<%@page import="modelo.DAOMedicionIMC"%>

<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario) sesion.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("login.jsp?error=DebeIniciarSesion");
        return;
    }

    DAOMedicionIMC dao = new DAOMedicionIMC();
    List<MedicionIMC> historial = dao.obtenerHistorialPorUsuario(usuario.getId());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Historial de IMC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h2 class="mt-5">Historial de IMC</h2>

    <table class="table">
        <thead>
            <tr>
                <th>Peso (kg)</th>
                <th>Estatura (m)</th>
                <th>IMC</th>
                <th>Fecha</th>
            </tr>
        </thead>
        <tbody>
            <% for (MedicionIMC m : historial) { %>
            <tr>
                <td><%= m.getPeso() %></td>
                <td><%= m.getEstatura() %></td>
                <td><%= m.getValorIMC() %></td>
                <td><%= m.getFechaMedicion() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>

