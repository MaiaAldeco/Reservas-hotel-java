<%-- 
    Document   : CrearUsuario
    Created on : 03-ago-2021, 16:27:37
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

        
        <div class="fcf-body">

<form name="id" action="index.jsp" method="POST" >
    <div class="fcf-form-group">
    <button type="submit" class="btnInicio">Inicio</button></div>
        </form>
        <div id="fcf-form">
            <h3 class="fcf-h3">Crear Usuario</h3>

            <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvCrearUsuario" >
                
                    <div class="fcf-form-group">
                        <label for="nombre" class="fcf-label">Usuario</label>

                        <div class="fcf-input-group">

                            <input type="text" id="nombre" name="nombre" class="fcf-form-control" required>

                        </div>
                    </div>
                    <div>
                        <label for="contrasenia" class="fcf-label">Contraseña</label>
                        <div class="fcf-input-group">
                            <input type="text" id="apellido" name="contrasenia" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    
                    <div class="fcf-form-group">
                        <button type="submit" id="fcf-button"
                            >Guardar</button>
                    </div>
                    


            </form>
        </div>

    </div>
        
        
    </body>
</html>
