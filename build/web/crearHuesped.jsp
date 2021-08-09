<%-- 
    Document   : pricipal
    Created on : 29-jul-2021, 18:03:48
    Author     : Usuario
--%>

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
<form name="id" action="index.jsp" method="POST" >
    <div class="fcf-form-group">
    <button type="submit" class="btnInicio">Inicio</button></div>
        </form>

        <div id="fcf-form">
            <h3 class="fcf-h3">Crear Huesped</h3>
            
            <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvHuesped" >
                
                    <div class="fcf-form-group">
                        <label for="nombre" class="fcf-label">Nombre</label>

                        <div class="fcf-input-group">

                            <input type="text" id="nombre" name="nombre" class="fcf-form-control" required>

                        </div>
                    </div>
                    <div>
                        <label for="apellido" class="fcf-label">Apellido</label>
                        <div class="fcf-input-group">
                            <input type="text" id="apellido" name="apellido" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="dni" class="fcf-label">DNI</label>
                        <div class="fcf-input-group">
                            <input type="text" id="dni" name="dni" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>

                    <div class="fcf-form-group">
                        <label for="direccion" class="fcf-label">Dirección</label>
                        <div class="fcf-input-group">
                            <input type="text" id="direccion" name="direccion" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    <div class="fcf-form-group">
                        <label for="profesion" class="fcf-label">Profesión</label>
                        <div class="fcf-input-group">
                            <input type="text" id="profesion" name="profesion" class="fcf-form-control" required>
                        </div>
                    </div>

                    <div>
                        <label for="fecha_nac" class="fcf-label">Fecha nacimiento</label>
                        <div class="fcf-input-group">
                            <input type="date" id="fecha" name="fecha_nac" class="fcf-form-control" required>
                        </div>
                    </div>

                    <br>
                 
                        <br>
                    <div class="fcf-form-group">
                        <button type="submit" id="fcf-button"
                            >Guardar</button>
                    </div>
                    


            </form>
            
        </div>

    </div>
         
        <%}%>
        
    </body>
</html>

