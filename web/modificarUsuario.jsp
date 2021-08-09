<%-- 
    Document   : modificarUsuario
    Created on : 05-ago-2021, 19:46:55
    Author     : Usuario
--%>

<%@page import="Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Datos</title>
    </head>
    <body style="background-color: #214761">
           <%
        
        HttpSession misesion = request.getSession();
        
        String usuario = (String) misesion.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("login.jsp");
        } else {
    
    %>
        
        
        
        <div class="fcf-body">


        <div id="fcf-form">
            

            <form id="fcf-form-id" class="fcf-form-class" method="GET"action="SvEditarUsuario">
                <%HttpSession sesion = request.getSession();
                Usuario usuario2 = (Usuario) sesion.getAttribute("usuario");
                {
                %>
                
                        <h3 class="fcf-h3">Modificar Usuario</h3>
                    </div>
                    <div class="fcf-form-group">
                        <label for="" class="fcf-label">Usuario</label>

                        <div class="fcf-input-group">

                            <input type="text" id="" name="usuario" class="fcf-form-control"value="<%=usuario2.getUsuario()%>">

                        </div>
                    </div>
                    <div>
                        <label for="" class="fcf-label">Contraseña</label>
                        <div class="fcf-input-group">
                            <input type="text" id="" name="contrasenia" class="fcf-form-control" value="<%=usuario2.getContrasenia()%>">
                        </div>
                    </div>
                    <br>
                    
                    <input type="hidden" id="id" name="id" class="fcf-form-control" value="<%=usuario2.getId_usuario()%>">
                    <br>
                    <div class="fcf-form-group">
                        <button type="submit" id="fcf-button"
                            >Guardar</button>
                    </div>



            </form>
        </div>

    </div>
        
    <%}%>
     <%}%>   
    </body>
</html>