<%-- 
    Document   : errorExcepcion
    Created on : 09-ago-2021, 15:13:06
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
        
        confirmacion = confirm('No se pudo llevar a cabo la consulta. La información se encuentra vinculada.');
        if(confirmacion){
            location.href='verEmpleado.jsp';
        }else{
            location.href='verEmpleado.jsp';
        }
        
    </script>
        
    </body>
</html>
