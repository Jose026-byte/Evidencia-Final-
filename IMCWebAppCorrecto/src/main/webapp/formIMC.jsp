<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario) sesion.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("login.jsp?error=DebeIniciarSesion");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calcular IMC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h2 class="mt-5">Cálculo de IMC</h2>
    <p>Usuario: <strong><%= usuario.getNombreCompleto() %></strong></p>

    <form action="CalculoIMCServlet" method="post">
        <div class="mb-3">
            <label>Peso (kg):</label>
            <input type="number" step="0.1" name="peso" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Calcular IMC</button>
        <a href="LogoutServlet" class="btn btn-danger">Cerrar sesión</a>
    </form>
</body>
</html>

