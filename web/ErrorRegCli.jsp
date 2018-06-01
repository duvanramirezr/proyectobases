<%-- 
    Document   : error
    Created on : 3/04/2018, 12:02:31 AM
    Author     : melia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        
    
       <div>
      
        <h1>Error en la creacion de un nuevo cliente</h1>
        <h2>
         <%
         String msg1 = (String)session.getAttribute("reg1");
         String msg2 = (String)session.getAttribute("reg2");    
        %>
        
        Error(c) 1: <%= msg1%>
        <br>
        Error(i) 2 : <%= msg2%>       
    </h2>
    <h4>Intente de nuevo</h4>
    <a  href="servletRegistroCliente.jsp">Regresar</a>
    </div>
    
    
    </body>
</html>
