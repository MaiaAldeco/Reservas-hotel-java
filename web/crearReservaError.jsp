<%-- 
    Document   : crearReservaError
    Created on : 06-ago-2021, 18:27:00
    Author     : Usuario
--%>

<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style="background-color: #214761">
            
        <script>
        
        confirmacion = confirm('La cantidad de personas no es correcta')
        if(confirmacion){
            location.href='crearReserva.jsp'
        }else{
            location.href='crearReserva.jsp'
        }
        
    </script>
        
    </body>
</html>

