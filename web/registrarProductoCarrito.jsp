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
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
        <!--EN ESTE BLOQUE SE DEFINEN LOS CAMPOS NECESARIOS PARA REALIZAR EL REGISTRO DE UN NUEVO PRODUCTO-->
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					REGISTRAR PRODUCTO
				</span>
                            <%-- En el action del formulario le decimos que llama al Controlador --%>
				<form class="login100-form validate-form p-b-33 p-t-5" action="Registrar" method="post" >
                                    <!--EN ESTA SECCION SE DEFININEN LOS CAMPOS QUE EL USUARIO DEBE LLENAR PARA SER ENVIADOS A LA BASE DE DATOS Y REGISTRAR EL NUEVO PRODUCTO-->

					<div class="wrap-input100 validate-input" data-validate = "Enter idproducto">
                                        <!--CAMPO PARA PODER DIGITAR EL ID DEL PRODUCTO-->
						<input class="input100" type="text" name="idproducto" placeholder="ID Producto">
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter nombreproducto">
                                            <!--CAMPO PARA PODER DIGITAR EL NOMBRE DEL NUEVO PRODUCTO -->
						<input class="input100" type="text" name="nombreproducto" placeholder="Nombre">
						<span class="focus-input100" ></span>
					</div>
                     
					<div class="wrap-input100 validate-input" data-validate="Enter categoria">
                                            <!--CAMPO PARA PODER DIGITAR LA CATEGORIA DEL NUEVO PRODUCTO-->
						<input class="input100" type="text" name="categoria" placeholder="Categoria">
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter valor">
                                            <!--CAMPO PARA PODER DIGITAR EL VALOR DEL NUEVO PRODUCTO-->
						<input class="input100" type="text" name="valor" placeholder="Valor">
						<span class="focus-input100" ></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter detalle">
                                        <!--CAMPO PARA PODER DIGITAR DETALLES SOBRE EL NUEVO PRODUCTO-->
						<input class="input100" type="text" name="detalle" placeholder="Detalle">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-32">
                                        <!--BOTON QUE PERMITE ENVIAR A LA BASE DE DATOS LA INFORMACION QUE SE DIGITO EN LOS CAMPOS ANTERIORES PARA REALIZAR EL REGISTRO DEL NUEVO CLIENTE-->
						<button class="login100-form-btn">
							Registrar Producto
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
