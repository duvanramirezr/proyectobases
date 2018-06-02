<%-- 
    Document   : Inicio
    Created on : 19/05/2018, 02:55:31 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </head>
    <body>
        <div class="topnav">
        <!--EN ESTE BLOQUE SE DEFINE LA BARRA DE NAVEGACION-->
        <a class="active" href="index.jsp">Login</a>
        <a class="active" href="servletRegistroCliente.jsp">Registrar Cliente</a>
        <a class="active" href="Pedido.jsp">Realizar Pedido</a>
        <a class="active" href="Carro">Carro</a>
</div>
        <div class="limiter">
       <!--EN ESTE BLOQUE SE DEFINEN LOS CAMPOS NECESARIOS PARA EL INICIO DE SESION-->

		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                    
			<div class="wrap-login100 p-t-30 p-b-50">
                		<span class="login100-form-title p-b-41">
					Account Login
				</span>
                            <form class="login100-form validate-form p-b-33 p-t-5" action="Login" method="post">
                                <!--EN ESTA SECCION SE DEFININEN LOS CAMPOS QUE EL USUARIO DEBE LLENAR PARA SER ENVIADOS A LA BASE DE DATOS E INICIAR SESION-->


					<div class="wrap-input100 validate-input" data-validate = "Enter username">
                                        <!--CAMPO PARA PODER DIGITAR EL NOMBRE DEL USUARIO-->
						<input class="input100" type="text" name="username" placeholder="User name">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
                                        <!--CAMPO PARA PODER DIGITAR LA CONTRASEÑA-->
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
                                         <div class="wrap-input100 validate-input">
                                         <!--SECCION QUE PERMITE ELEGIR UN SOLO ROL PARA INICIAR SESION -->
                                          
                                            <input  type="radio" name="cargo" value="representante"> Representante<br>
                                            <input  type="radio" name="cargo" value="cliente"> Cliente
                                       
                                         </div>
					<div class="container-login100-form-btn m-t-32">
                                         <!--BOTON QUE PERMITE ENVIAR A LA BASE DE DATOS LA INFORMACION QUE SE DIGITO EN LOS CAMPOS ANTERIORES PARA INICIAR SESION-->
						<button class="login100-form-btn">
							Login
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
        <!--===============================================================================================-->
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
