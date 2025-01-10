<%-- 
    Document   : equipos
    Created on : 7/01/2025, 10:54:47 PM
    Author     : Ximena
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos</title>
    </head>
    <body>
        <h1>Lista de Equipos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="equipo" items="${equipos}">
                <tr>
                    <td>${equipo.idEquipo}</td>
                    <td>${equipo.marca}</td>
                    <td>${equipo.modelo}</td>
                    <td>${equipo.precio}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Agregar Equipo</h2>
    <form method="post" action="EquipoServlet">
        <label>Marca: <input type="text" name="marca" /></label><br />
        <label>Modelo: <input type="text" name="modelo" /></label><br />
        <label>Precio: <input type="number" name="precio" /></label><br />
        <button type="submit">Agregar</button>
    </form>
</body>
</html>