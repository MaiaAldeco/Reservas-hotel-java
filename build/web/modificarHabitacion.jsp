<%-- 
    Document   : modificarHabitacion
    Created on : 05-ago-2021, 18:05:34
    Author     : Usuario
--%>

<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page import="Logica.Habitacion"%>
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
            

            <form id="fcf-form-id" class="fcf-form-class" method="GET"action="SvEditarHabitacion">
                <%HttpSession sesion = request.getSession();
                Habitacion habi = (Habitacion) sesion.getAttribute("habi");
                {
                %>
                
                        <h3 class="fcf-h3">Modificar Habitación</h3>
                    </div>
                    <div class="fcf-form-group">
                        <label for="tematica" class="fcf-label">Temática</label>

                        <div class="fcf-input-group">

                            <input type="text" id="tematica" name="tematica" class="fcf-form-control"value="<%=habi.getTematica()%>">

                        </div>
                    </div>
                    <div>
                        <label for="piso" class="fcf-label">Piso</label>
                        <div class="fcf-input-group">
                            <input type="text" id="piso" name="piso" class="fcf-form-control" value="<%=habi.getPiso_habitacion()%>">
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="tipo" class="fcf-label">Tipo</label>
                        <div class="fcf-input-group">
                            <input type="text" id="tipo" name="tipo" class="fcf-form-control" value="<%=habi.getTipoHabitacion()%>">
                        </div>
                    </div>
                    <br>

                    <div class="fcf-input-group">
                            
                           <select name="reserva">
                               <%
                            Controladora controlLogica = new Controladora();
                            List<Reserva> listaReserva = controlLogica.traerReservas();
                            for (Reserva reserva : listaReserva) {
                                 %>
                           <option value="<%=reserva.getId_reserva()%>"><%=reserva.getHuesped().getNombre()%></option>
                           <%}%>
                                </select>
                       
                             
                        </div>
                    <br>
                    <input type="hidden" id="id" name="id" class="fcf-form-control" value="<%=habi.getId_habitacion()%>">
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
