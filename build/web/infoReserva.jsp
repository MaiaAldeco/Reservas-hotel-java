<%-- 
    Document   : infoReserva
    Created on : 08-ago-2021, 12:21:33
    Author     : Usuario
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
            
     
    <%
        
        HttpSession misesion = request.getSession();
        
        String usuario = (String) misesion.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("login.jsp");
        } else {
    
    %>
                <%HttpSession sesion = request.getSession();
                Reserva reserva = (Reserva) sesion.getAttribute("reserva");
                {
                %>
                <%
                int totalReserva = reserva.getTotal();
                Date fecha = reserva.getCheckin();
                Date fecha2 = reserva.getCheckout();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaIn = formato.format(fecha);
                String fechaOut = formato.format(fecha2);
                %>
                 <h3 class="fcf-h3">Información reserva: </h3>
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
            <div>
                        <label for="checkout" class="fcf-label">Total</label>
                        <div class="fcf-input-group">
                            <input type="text" id="checkout" name="checkout" class="fcf-form-control" value="<%=totalReserva%>">
                        </div>
                    </div>
        </p>
    <%}%>    
    </body>
    
</html>
