<%-- 
    Document   : modificarReserva
    Created on : 05-ago-2021, 18:50:49
    Author     : Usuario
--%>

<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Controladora"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
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
            

            <form id="fcf-form-id" class="fcf-form-class" method="GET"action="SvEditarReserva">
                <%HttpSession sesion = request.getSession();
                Reserva reserva = (Reserva) sesion.getAttribute("reserva");
                {
                %>
                <%
                                
                                Date fecha = reserva.getCheckin();
                                Date fecha2 = reserva.getCheckout();
                                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                String fechaIn = formato.format(fecha);
                                String fechaOut = formato.format(fecha2);
                %>
                        <h3 class="fcf-h3">Modificar Reserva</h3>
                    </div>
                    <div class="fcf-form-group">
                        <label for="checkin" class="fcf-label">Check in</label>

                        <div class="fcf-input-group">

                            <input type="text" id="checkin" name="checkin" class="fcf-form-control"value="<%=fechaIn%>">

                        </div>
                    </div>
                    <div>
                        <label for="checkout" class="fcf-label">Check out</label>
                        <div class="fcf-input-group">
                            <input type="text" id="checkout" name="checkout" class="fcf-form-control" value="<%=fechaOut%>">
                        </div>
                    </div>
                    <br>
                    
                        
                        <div class="fcf-input-group">
                            
                           <select name="empleado">
                               <%
                            Controladora controlLogica = new Controladora();
                            List<Empleado> listaEmpleado = controlLogica.traerEmpleados();
                            for (Empleado emple : listaEmpleado) {
                                 %>
                           <option value="<%=emple.getIdEmpleado()%>"><%=emple.getNombre()%></option>
                           <%}%>
                                </select>
                       
                             
                        </div>
                    <br>

                    <div class="fcf-input-group">
                            
                           <select name="huesped">
                               <%
                            
                            List<Huesped> listaHuesped = controlLogica.traerHuesped();
                            for (Huesped huesped : listaHuesped) {
                                 %>
                           <option value="<%=huesped.getIdHuesped()%>"><%=huesped.getNombre()%></option>
                           <%}%>
                                </select>
                       
                             
                        </div>
                    <br>
                    <div class="fcf-input-group">
                            
                           <select name="habitacion">
                               <%
                            
                            List<Habitacion> listaHabitacion = controlLogica.traerHabitacion();
                            for (Habitacion habi : listaHabitacion) {
                                 %>
                           <option value="<%=habi.getId_habitacion()%>"><%=habi.getTipoHabitacion()%></option>
                           <%}%>
                                </select>
                       
                             
                        </div>
                    
                    <input type="hidden" id="id" name="id" class="fcf-form-control" value="<%=reserva.getId_reserva()%>">
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