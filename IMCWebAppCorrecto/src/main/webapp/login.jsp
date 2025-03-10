<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión - IMC App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h2 class="mt-5">Iniciar Sesión</h2>

    <% if(request.getParameter("error") != null) { %>
        <div class="alert alert-danger">Usuario o contraseña incorrectos.</div>
    <% } %>

    <% if(request.getParameter("success") != null) { %>
        <div class="alert alert-success">Registro exitoso. Ahora puedes iniciar sesión.</div>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="mb-3">
            <label>Nombre de usuario:</label>
            <input type="text" name="nombreUsuario" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Contraseña:</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Ingresar</button>
        <a href="registro.jsp" class="btn btn-link">¿No tienes cuenta? Regístrate</a>
    </form>
</body>
</html>

