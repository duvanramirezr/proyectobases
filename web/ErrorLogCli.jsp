<%-- 
    Document   : ErrorLogCli
    Created on : 3/04/2018, 12:34:37 AM
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
      
        <h1>Error de logueo</h1>
        <h2>
         <%
         String msg1 = (String)session.getAttribute("reg1");
          
        %>
        
        Error: <%= msg1%>
        <br>
            
    </h2>
    <h4>Intente de nuevo</h4>
    <a  href="LoginCli.jsp">Regresar</a>
    </div>
    </body>
</html>
