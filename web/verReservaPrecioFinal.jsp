<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Table V05</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor1/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor1/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor1/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor1/perfect-scrollbar/perfect-scrollbar2.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util2.css">
	<link rel="stylesheet" type="text/css" href="css/main2.css">
<!--===============================================================================================-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
        <%
        
        HttpSession misesion = request.getSession();
        
        String usuario = (String) misesion.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("login.jsp");
        } else {
    
    %>
    
     
	<% Controladora controlLogica = new Controladora();%>
        <%SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");%>
	<div class="limiter">
            
		<div class="container-table100">
                    <form name="id" action="index.jsp" method="POST" >
    <div class="fcf-form-group">
    <button type="submit" class="btnInicio">Inicio</button></div>
        </form>
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Check in</th>
								</tr>
							</thead>
							<tbody>
                                                            
                                                            <%
                                                            List <Reserva> listaReserva = controlLogica.traerReservas();
                                                            for(Reserva reserva : listaReserva){
                                                              %>  
                                                            <tr class="row100 body">
                                                                <% Date checkin = reserva.getCheckin();%>
                                                                
                                                                <td class="cell100 column2"><%=formato.format(checkin)%></td>
								</tr>
							</tbody>
                                                        <%}%>
						</table>
					</div>
					
					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column3">Check out</th>
										
										<th class="cell100 column5">Huesped</th>
                                                                                
										<th class="cell100 column6">Habitación</th>
                                                                                <th class="cell100 column6">Total</th>
                                                                               
                                                                                
										
									</tr>
								</thead>
                                                                
									<%
                                                                     
                                                                         for(Reserva reserva : listaReserva){
                                                                                       %>  
                                                                        <tr class="row100 body">
                                                                        <%Date checkout = reserva.getCheckout();%>
                                                                        <td class="cell100 column3"><%=formato.format(checkout)%></td>   
                                                                        
                                                                        <%Huesped huesp = reserva.getHuesped();%>
                                                                        <%String huesped = huesp.getApellido() + " " + huesp.getDni();%>
                                                                        <td class="cell100 column6"><%=huesped%></td>
                                                                        <%Habitacion habita = reserva.getHabitacion();
                                                                        String habitacion = habita.getTipoHabitacion() + " " + habita.getId_habitacion();
                                                                        %>
                                                                        <td class="cell100 column6"><%=habitacion%></td>
                                                                        
                                                                        
                                                                         <%long id = reserva.getId_reserva();%>
                                                                         <td class="cell100 column6">
                                                                             <%int total = reserva.getTotal();%>
                                                                             <%=total%>
                                                                          </td>
                                                                         
                                                                         
                                                                       
                                                     
                                                                        <td class="cell100 column6"></td>
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        </tr>
                                                                            
									<%}%>
                                                                
                                                                
                                                                
								<tbody>
									
								</tbody>
							</table>
                                                                       
                                                           
						</div>
                                                                       
					</div>
                                                                         
				</div>
                                                                         <br> <br> 
			</div>
                              
  
 <form action="crearReserva.jsp">
                    <button id="btnIndex" type="submit" class="btn btn-xs btn-success">Volver</button>
</form>                                       
		</div>
                                                                        
	</div>


<!--===============================================================================================-->	
	<script src="vendor1/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor1/bootstrap/js/popper.js"></script>
	<script src="vendor1/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor1/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor1/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})

			$(this).on('ps-x-reach-start', function(){
				$(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
			});

			$(this).on('ps-scroll-x', function(){
				$(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
			});

		});

		
		
		
	</script>
<!--===============================================================================================-->
	<script src="js/main2.js"></script>
<%}%>
</body>
</html>

