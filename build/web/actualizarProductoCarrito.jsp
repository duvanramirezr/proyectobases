<%-- 
    Document   : actualizarProductoCarrito
    Created on : 02-abr-2018, 16:08:18
    Author     : LINA
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocio.*" %>
<%@page import="datos.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%-- Obtenemos el id o el codigo del producto que deseamos modificar o actualizar --%>
<%
    Producto p = SistemaVDAO.obtenerProducto(Integer.parseInt(request.getParameter("id")));
    
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
    </head>
    <body>
        <h1>Modificar Producto</h1>
        <div>
            <a href="indexCarrito.jsp">Inicio</a> |
            <a href="registrarProductoCarrito.jsp">Registrar Producto</a> |
         <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="carritoServlet">
            <div>
                <%-- Indica al controlador que vamos hacer una modificacion --%>
                <input type="hidden" name="accion" value="ModificarProducto" />
                <table border="1">
                    <tr>
                        <td>Codigo</td>
                        <%-- Escribimos el codigo del producto a modificar --%>
                        <td><input type="text" name="txtCodigo" value="<%= p.getId_producto()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <%-- Escribimos el nombre del producto a modificar --%>
                        <td><input type="text" name="txtNombre" value="<%= p.getNombre()%>" /></td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <%-- Escribimos la categoria del producto a modificar --%>
                        <td><input type="text" name="txtCategoria" value="<%= p.getId_categoria()%>" /></td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <%-- Escribimos el valor del producto a modificar --%>
                        <td><input type="text" name="txtValor" value="<%= p.getValor()%>" /></td>
                    </tr>
                    <tr>
                        <td>Detalle</td>
                        <%-- Escribimos el detalle del producto a modificar --%>
                        <td><input type="text" name="txtDetalle" value="<%= p.getDetalle()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Actualizar" name="btnActualizar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
