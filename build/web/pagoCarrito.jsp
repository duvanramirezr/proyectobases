<%-- 
    Document   : pagoCarrito
    Created on : 04-abr-2018, 16:27:46
    Author     : LINA
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocio.*" %>
<%@page import="datos.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Venta_Producto vp = new Venta_Producto();
     /* double ValorTotal = 0.0;
         ArrayList<Producto> lista = SistemaVDAO.obtenerProducto();
          for (Producto p : lista) {
              double valor = p.getValor();
              ValorTotal = ValorTotal + valor;
              
          }
          vp.setTotal_producto(ValorTotal);*/
    
    java.util.Date fecha = new Date();
    Pago pago = new Pago();
    //este parametro debe ser dinamico, es decir, se debe generar tipo consecutivo
    //pero lo dejo estatico para el caso
    pago.setId_pago(51551);
    if (request.getParameter("Metodo Pago") == "PSE") {
        pago.setId_metodo_pago(101);
    } else {
        if (request.getParameter("Metodo Pago") == "TCE") {
            pago.setId_metodo_pago(102);
        }
    }
    pago.setFecha_pago("05/06/2018");
    int idped=104;
    
        
    Pedido pedido = negocio.Modelo.getInstance().getSistemaVDAO().obtenerPedido(idped);
    idped = idped +5;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
    </head>
    <body>
        <h1>Pago</h1>
        <div class="topnav">
        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->
        <a class="active" href="index.jsp">Login</a>
        <a class="active" href="servletRegistroCliente.jsp">Registrar Cliente</a>
        <a class="active" href="indexCarrito.jsp">Carro</a>
        <a class="active" href="registrarProductoCarrito.jsp">Registrar producto</a>
</div>
        
        <br >
        <form action="carritoServlet" method="post">
            <input type="hidden" name="accion" value="RealizarPago" />
            <div>
                <table border="1">
                    <tr style="background-color: chocolate">
                        <td colspan="4"><center>Realizar pago</center></td>

                    </tr>
                    <tr style="background-color: chocolate">
                        <td><center>Metodo de Pago</center></td>
                        <%--<td><center>Codigo</center></td>--%>
                        <td><center>Valor Total</center></td>
                        <td><center>Fecha de Pago</center></td>
                        
                        
                        
                    </tr>
                    <%-- Lista de todos los productos %>
                    <%
                                ArrayList<Producto> lista = SistemaVDAO.obtenerProducto();
                                for (Producto p : lista) {
                    --%>
                    <tr>
                        <td><center><select name="txtMetodo" heigth="5"><option value="PSE">PSE></option><option value="TARJETA">TARJETA</option></select></center></td>
                       <%-- <td><input type="text" name="txtCodigoPago" value="" /></td>--%>
                        <td><input type="text" name="txtValor" value="<%=pedido.getTotal_pedido()%>" /></td>
                        <td><input type="text" name="txFecha" value="<%=pago.getFecha_pago()%>" /></td>
                       
                        <%--<a href="añadirCarrito.jsp?id=<%= p.getId_producto()%>">Añadir</a>--%>
                        
                    </tr>
                    <%--
                                }
                    --%>



                </table>
                    <br>    
                    <input type="submit" value="Realizar Pago" name="btnPago"/>

            </div>
        </form>
     
    </body>
</html>

