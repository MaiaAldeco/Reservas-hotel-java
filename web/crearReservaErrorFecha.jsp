<%-- 
    Document   : crearReservaErrorFecha
    Created on : 06-ago-2021, 20:59:24
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style="background-color: #214761">
            
        
        <script>
        
        confirmacion = confirm('La fecha ya está ocupada')
        if(confirmacion){
            location.href='crearReserva.jsp'
        }else{
            location.href='crearReserva.jsp'
        }
        
    </script>
      
    </body>
</html>
