

<%@page import="Logica.Reserva"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Huesped"%>
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
        

        <div id="fcf-form">
                    <form name="id" action="index.jsp" method="POST" >
    <div class="fcf-form-group">
    <button type="submit" class="btnInicio">Inicio</button></div>
        </form>
            <h3 class="fcf-h3">Crear Reserva</h3>
            
            <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvCrearReserva" >
                <%Controladora controlLogica = new Controladora();%>
                
                    <div class="fcf-form-group">
                        <label for="checkin" class="fcf-label">Check in</label>

                        <div class="fcf-input-group">

                            <input type="date" id="checkin" name="checkin" class="fcf-form-control" required>

                        </div>
                    </div>
                    <div>
                        <label for="checkout" class="fcf-label">Check out</label>
                        <div class="fcf-input-group">
                            <input type="date" id="checkout" name="checkout" class="fcf-form-control" required>
                        </div>
                    </div>
                <div>
                        <label for="cantidadPerso" class="fcf-label">Cantidad Personas</label>
                        <div class="fcf-input-group">
                            <input type="text" id="cantidadPerso" name="cantidadPerso" class="fcf-form-control" required>
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="huesped" class="fcf-label">Huesped que reserva:</label>
                        <div class="fcf-input-group">
                            
                           <select name="huesped" class="select">
                               <%
                            
                            List<Huesped> listaHuesped = controlLogica.traerHuesped();
                            for (Huesped huesped : listaHuesped) {
                                 %>
                           <option value="<%=huesped.getIdHuesped()%>"><%=huesped.getNombre()%></option>
                           <%}%>
                                </select>
                       
                             
                        </div>
                    <br>

                    <div>
                        <label for="emple" class="fcf-label">Empleado que realizó la reserva: </label>
                        <div class="fcf-input-group">
                            
                            <select name="empleado" class="select" >
                        <%
                            
                            List<Empleado> listaEmpleados = controlLogica.traerEmpleados();
                            for (Empleado emple : listaEmpleados) {
                        %>
                        <option value="<%=emple.getIdEmpleado()%>"><%=emple.getNombre()%></option>
                            <% } %> 
                        </select>
                            
                            
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="habitacion" class="fcf-label">Habitacion: </label>
                        <div class="fcf-input-group">
                            
                            <select name="habitacion" class="select">
                        <%
                            
                            List<Habitacion> listaHabitacion = controlLogica.traerHabitacion();
                            for (Habitacion habitacion : listaHabitacion) {
                        %>
                        <option value="<%=habitacion.getId_habitacion()%>"><%=habitacion.getTipoHabitacion() + " "+ habitacion.getTematica()%></option>
                        <%}%>
                        </select>
                             
                            
                        </div>
                        <br>
                        
                        <div class="fcf-form-group">
                        <label for="emision" class="fcf-label">Fecha emisión</label>

                        <div class="fcf-input-group">

                            <input type="date" id="emision" name="emision" class="fcf-form-control" required>

                        </div>
                    </div>
                        <div class="fcf-form-group">
                        
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
         
       
        <%}%>
    </body>
</html>