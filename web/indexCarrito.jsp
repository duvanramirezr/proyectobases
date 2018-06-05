<%-- 
    Document   : indexCarrito
    Created on : 01-abr-2018, 19:22:32
    Author     : LINA
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Importaciones que son necesarias para que se muestre el JSP --%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocio.*" %>
<%@page import="datos.*" %>
<%@page import="java.util.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
          <title>NATAME</title>
        <!--LAS SIGUIENTES LINEAS SE USAN PARA LLAMAR EL CSS QUE SE DEFINIO PARA MEJORAR LA INTERFAZ-->

        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
       
        <div class="topnav">
        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->
        <a class="active" href="index.jsp">Login</a>
        <a class="active" href="servletRegistroCliente.jsp">Registrar Cliente</a>
        <a class="active" href="indexCarrito.jsp">Carro</a>
        <a class="active" href="registrarProductoCarrito.jsp">Registrar producto</a>
</div>
        <div class="limiter">
        <!--EN ESTE BLOQUE SE ENCUENTRA LA INFORMACION DE PRODUCTOS DISPONIBLES-->
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div>
				<span class="login100-form-title p-b-41">
					LISTA DE PRODUCTOS
				</span>
				
                                    <!--EN ESTA SECCION SE DEFININEN LA TABLA QUE TIENE LISTADO LOS PRODUCTOS DISPONIBLES-->
        <form class="login100-form validate-form p-b-33 p-t-5" action="carritoServlet" method="post" >
            <input type="hidden" name="accion" value="RealizarVenta" />
            <div>
                <table border="1">
                    <tr >
                    <td class="barra-tabla"><center>Codigo</center></td>
                    <td class="barra-tabla"><center>Nombre</center></td>
                    <td class="barra-tabla"><center>Categoria</center></td>
                    <td class="barra-tabla"><center>Valor</center></td>
                    <td class="barra-tabla"><center>Detalle</center></td>
                    <td class="barra-tabla"><center>Comprar</center></td>
                    <td class="barra-tabla"><center>Cantidad</center></td>

                    </tr>
                    <%-- Lista de todos los productos --%>
                    <%
                        
                        ArrayList<Producto> lista = negocio.Modelo.getInstance().getSistemaVDAO().obtenerProducto();
                        for (Producto p : lista) {
                    %>
                    <tr>
                        <td><input type="text" name="txtCodigo" value="<%= p.getId_producto()%>" readonly /></td>
                        <td><%= p.getNombre()%></td>
                        <td><center><%= p.getId_categoria()%></center></td>
                    <td><%= p.getValor()%></td>
                    <td><%= p.getDetalle()%></td>
                    <td><center><input type="checkbox" name="checkComprar" value="1"/></center></td>
                        <%-- Enlaces a las paginas de actualizar o anadir al carrito --%>
                    <td><input type="text" name ="Cantidad" size="8"></td> 
                        <%--<a href="añadirCarrito.jsp?id=<%= p.getId_producto()%>">Añadir</a>--%>
                    
                    </tr>
                    <%
                        }
                    %>


                    <%-- Capturar Pago --%>
                    <%--
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
                        pago.setFecha_pago(String.valueOf(fecha));
                    --%>

                    <%-- Capturar Venta --%>
                    <%--
                        double valor_tatal = 0;
                        double valor_final = 0;
                        int cant_produc = 0;
                        
                        Venta_Producto vp = new Venta_Producto();
                        ArrayList<Venta_Producto> pedidoProduc = new ArrayList<Venta_Producto>();
                        //la idea es que el for recorra toda la tabla que en teoria es el tamaño de lista
                        for (int i = 0; i < lista.size(); i++) {

                            if (request.getParameter("checkComprar") == "1") {

                                vp.setId_producto(lista.get(i).getId_producto());
                                //ya que si se cumple la condiccion de check y como lista alberga toda la consulta en un orden especifico
                                //se puede traer el valor correspondiente de lista y su atributo
                                vp.setCantidad(Integer.parseInt(request.getParameter("Cantidad")));

                                valor_tatal = Double.parseDouble(request.getParameter("Cantidad")) * lista.get(i).getValor();
                                //esto es para acumular el total de valor por producto y generar un valor final que es la suma de todos ellos
                                vp.setTotal_producto(valor_tatal);

                                valor_final = valor_final + valor_tatal;

                                pedidoProduc.add(vp);
                                
                                cant_produc += 1;
                            }
                            
                        }
                    SistemaVDAO.registrarVentaProduc(vp);

                    --%>

                    <%-- Capturar Pedido --%>
                    <%--                        
                        Pedido pedido = new Pedido();
                        //este parametro debe ser dinamico, es decir, se debe generar en la capa web
                        //pero lo dejo estatico para el caso
                        pedido.setId_pedido(5454551);

                        //como el que se loguea es el cliente, se debe guardar una variable con su id
                        //Y guardarla asi: int id_cliente = request.getParameter("idCliente");
                        //y eso es lo que se pasa por parametro a setId_Cliente
                        pedido.setId_cliente(154452);
                        pedido.setTotal_pedido((int) valor_final);
                        pedido.setId_pago(pago.getId_pago());
                        pedido.setEstado("EP");
                        pedido.setFecha(String.valueOf(fecha));

                        vp.setId_pedido(pedido.getId_pedido());
                    --%>

                    <%-- Guardar Todo --%>
                    <%--
                        //Se llama a un metodo mas o menos como (hay que crear alguno)
                      SistemaVDAO.registrarPago(pago);

                       // SistemaVDAO.registrarPedido(pedido);

                      //  

                    --%>

                    <%-- Actualizar inventario--%>
                    <%--                        
                        Inventario_Producto ip = new Inventario_Producto();
                        for (int i = 0; i < cant_produc; i++) {
                            ip.setProducto(pedidoProduc.get(i).getId_producto());
                            ip.setCantidad(ip.getCantidad() - pedidoProduc.get(i).getCantidad());
                            SistemaVDAO.actualizarInvProduc(ip);
                        }

                    --%>
                </table>		
                <div class="container-login100-form-btn m-t-32">
                <!--BOTON QUE PERMITE ENVIAR A LA BASE DE DATOS LA INFORMACION QUE SE ELIGIO EN LA TABLA PARA REALIZAR LA COMPRA-->
                     <button class="login100-form-btn">
			Realizar compra
                    </button>
                
		</div>
         </form>
		</div>
	</div>
    </div>
           


     
     <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
                
    </body>
</html>