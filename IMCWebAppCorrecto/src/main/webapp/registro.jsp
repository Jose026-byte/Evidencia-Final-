<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario - IMC App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h2 class="mt-5">Registro de Usuario</h2>

    <% if(request.getParameter("error") != null) { %>
        <div class="alert alert-danger">Error al registrar usuario. Revisa los datos ingresados.</div>
    <% } %>

    <form action="RegistroServlet" method="post">
        <div class="mb-3">
            <label>Nombre completo:</label>
            <input type="text" name="nombreCompleto" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Nombre de usuario:</label>
            <input type="text" name="nombreUsuario" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Contraseña:</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Edad:</label>
            <input type="number" name="edad" min="15" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Sexo:</label>
            <select name="sexo" class="form-control">
                <option>Masculino</option>
                <option>Femenino</option>
            </select>
        </div>
        <div class="mb-3">
            <label>Estatura (m):</label>
            <input type="number" step="0.01" name="estatura" min="1" max="2.5" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Registrar</button>
        <a href="login.jsp" class="btn btn-link">¿Ya tienes cuenta? Inicia sesión</a>
    </form>
</body>
</html>
