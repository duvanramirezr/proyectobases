<%-- 
    Document   : Login
    Created on : 31-mar-2018, 13:54:33
    Author     : milto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <center><title>INICIO SESION Cliente</title></center>
    </head>
    <body>
      <center>  <h1>inicio Sesion Cliente</h1></center>
        <form action="LoginCliServlet" method="post">
           <center> <label>Nombre</label><center>
           <center> <input type="text" name="usuario" /><br></center>
          <center>  <label>Contraseña</label><center>
            <center><input type="password" name="contrasena" /><br></center>
            <center><input type="submit" value="Iniciar Sesion" /></center>
            <input type ="checkbox" name="opo" value="on"/>rojo<p>
             <input type ="checkbox" name="opo" value="on"/>rojo<p>
                <input type ="checkbox" name="opo" value="on"/>rojo<p>
        </form>
        
      <center>  Desea loguearse como representante?<a href="LoginRep.jsp">Cambiar Rol. <a/></center>
             <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
