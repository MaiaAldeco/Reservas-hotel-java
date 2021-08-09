<%-- 
    Document   : crearHabitacion
    Created on : 03-ago-2021, 22:15:05
    Author     : Usuario
--%>

<%@page import="Logica.Huesped"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
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
            <h3 class="fcf-h3">Crear Habitación</h3>

            <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvCrearHabitacion" >
                
                    <div class="fcf-form-group">
                        <label for="piso" class="fcf-label">Piso en el que se encuentra:</label>

                        <div class="fcf-input-group">

                            <input type="text" id="piso" name="piso" class="fcf-form-control" required>

                        </div>
                    </div>
                    <div>
                        <label for="tematica" class="fcf-label">Temática</label>
                        <div class="fcf-input-group">
                            <input type="text" id="tematica" name="tematica" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="precio" class="fcf-label">Precio</label>
                        <div class="fcf-input-group">
                            <input type="text" id="precio" name="precio" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="tipo" class="fcf-label">Tipo</label>
                        <div>
                                <input type="radio" name="tipo" value="single"> Single<br>
                                <input type="radio" name="tipo" value="doble"> Double<br>
                                <input type="radio" name="tipo" value="triple"> Triple<br>
                                <input type="radio" name="tipo" value="multiple"> Multiple<br>
                            </div>
                    </div>
                    <br>

                        
                    </div> 
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

