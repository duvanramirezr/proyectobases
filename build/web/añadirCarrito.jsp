<%-- 
    Document   : añadirCarrito
    Created on : 02-abr-2018, 16:49:03
    Author     : LINA
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="negocio.*" %>
<%@page import="datos.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%-- Obtenemos el id o el codigo del producto que deseamos añadir al carrito --%>
<%
    Producto p= SistemaVDAO.obtenerProducto(Integer.parseInt(request.getParameter("id")));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de Compras</title>
    </head>
    <body>
        <h1>Añadir</h1>
        <div>
            <a href="indexCarrito.jsp">Inicio</a> |
            <a href="registrarProductoCarrito.jsp">Registrar Producto</a> |
        </div>
        <br >
        <form method="post" action="carritoServlet">
            <div>
                <input type="hidden" name="accion" value="AnadirCarrito" />
                <table border="1">
                    <tr>
                        <td>Codigo</td>
                        <td><input type="text" name="txtCodigo" value="<%= p.getId_producto()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="<%= p.getNombre()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td><input type="text" name="txtCategoria" value="<%= p.getId_categoria()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <td><input type="text" name="txtValor" value="<%= p.getValor()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Detalle</td>
                        <td><input type="text" name="txtDetalle" value="<%= p.getDetalle()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Cantidad Pedir</td>
                        <td><input type="text" name="txtCantidad" value="0" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Añadir" name="btnAnadir" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
