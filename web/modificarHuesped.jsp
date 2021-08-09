<%-- 
    Document   : modificarHuesped.jsp
    Created on : 04-ago-2021, 18:33:35
    Author     : Usuario
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Huesped"%>
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
            

            <form id="fcf-form-id" class="fcf-form-class" method="GET"action="SvEditarHuesped">
                <%HttpSession sesion = request.getSession();
                Huesped huesped = (Huesped) sesion.getAttribute("huesped");
                {
                %>
                
                        <h3 class="fcf-h3">Modificar Huesped</h3>
                    </div>
                    <div class="fcf-form-group">
                        <label for="nombre" class="fcf-label">Nombre</label>

                        <div class="fcf-input-group">

                            <input type="text" id="nombre" name="nombre" class="fcf-form-control"value="<%=huesped.getNombre()%>">

                        </div>
                    </div>
                    <div>
                        <label for="apellido" class="fcf-label">Apellido</label>
                        <div class="fcf-input-group">
                            <input type="text" id="apellido" name="apellido" class="fcf-form-control" value="<%=huesped.getApellido()%>">
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="dni" class="fcf-label">DNI</label>
                        <div class="fcf-input-group">
                            <input type="text" id="dni" name="dni" class="fcf-form-control" value="<%=huesped.getDni()%>">
                        </div>
                    </div>
                    <br>

                    <div class="fcf-form-group">
                        <label for="direccion" class="fcf-label">Dirección</label>
                        <div class="fcf-input-group">
                            <input type="text" id="direccion" name="direccion" class="fcf-form-control" value="<%=huesped.getDireccion()%>">
                        </div>
                    </div>
                    <br>
                    <div class="fcf-form-group">
                        <label for="profesion" class="fcf-label">Profesion</label>
                        <div class="fcf-input-group">
                            <input type="text" id="profesion" name="profesion" class="fcf-form-control" value="<%=huesped.getProfesion()%>">
                        </div>
                    </div>
                      
                    <div>
                        <label for="fecha_nac" class="fcf-label">Fecha nacimiento</label>
                        <div class="fcf-input-group">
                            <%
                                
                                Date fecha = huesped.getFecha_nac();
                                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                String fecha1 = formato.format(fecha);%>
                            <input type="date" id="fecha" name="fecha_nac" class="fcf-form-control" value="<%=fecha1%>">
                        </div>
                    </div>
                    <input type="hidden" id="id" name="id" class="fcf-form-control" value="<%=huesped.getIdHuesped()%>">
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