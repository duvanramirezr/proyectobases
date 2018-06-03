<%-- 
    Document   : registrarProductoCarrito
    Created on : 02-abr-2018, 16:02:59
    Author     : LINA
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="negocio.*" %>
<%@page import="servlet.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
    </head>
    <body>
        
        <div class="topnav">
        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->
        <a class="active" href="index.jsp">Login</a>
        <a class="active" href="servletRegistroCliente.jsp">Registrar Cliente</a>
        <a class="active" href="indexCarrito.jsp">Carro</a>
        <a class="active" href="registrarProductoCarrito.jsp">Registrar producto</a>
</div>
        <br >   
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form action="carritoServlet" method="post">
            <div>
                <input type="hidden" name="accion" value="RegistrarProducto" />
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="txtCodigo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td><input type="text" name="txtCategoria" value="0" /></td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <td><input type="text" name="txtValor" value="0" /></td>
                    </tr>
                    <tr>
                        <td>Detalle</td>
                        <td><input type="text" name="txtDetalle" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                </table>
            </div>
        </form>
        
    </body>
</html>
