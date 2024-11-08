<%-- 
    Document   : index
    Created on : 8/11/2024, 09:43:49 AM
    Author     : Ximena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
        <h1>Registro de Ventas</h1>
        <form action="procesarVenta.jsp" method="post">
            <div class="form-group">
                <label for="nombre">Nombre del Producto</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="precio">Precio</label>
                <input type="number" class="form-control" id="precio" name="precio" required>
            </div>
            <div class="form-group">
                <label for="cantidad">Cantidad</label>
                <input type="number" class="form-control" id="cantidad" name="cantidad" required>
            </div>
            <button type="submit" class="btn btn-primary">Calcular la venta</button>
        </form>
    </div>
<jsp:include page="incluides/header.jsp"/>

<jsp:include page="incluides/footer.jsp"/>
