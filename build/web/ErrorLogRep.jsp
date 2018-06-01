<%-- 
    Document   : ErrorLogRep
    Created on : 3/04/2018, 01:29:00 AM
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
    <a  href="LoginRep.jsp">Regresar</a>
    
    </div>
    </body>
</html>
