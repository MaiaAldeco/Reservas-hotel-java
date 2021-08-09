<%-- 
    Document   : noHayFecha
    Created on : 08-ago-2021, 16:25:04
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
        
            <%
        
        HttpSession misesion = request.getSession();
        
        String usuario = (String) misesion.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("login.jsp");
        } else {
    
    %>
        <script>
        
        confirmacion = confirm('No hay reservas realizadas con los parámetros solicitados')
        if(confirmacion){
            location.href='reservasDeUnDia.jsp'
        }else{
            location.href='reservasDeUnDia.jsp'
        }
        
    </script>
      <%}%>  
    </body>
</html>