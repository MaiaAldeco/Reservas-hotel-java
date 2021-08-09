<%-- 
    Document   : ver
    Created on : 29-jul-2021, 21:19:44
    Author     : Usuario
--%>

<%@page import="Logica.Huesped"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
    
    
    
    
    
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Huesped</th>
								</tr>
							</thead>
							<tbody>
                                                            
                                                            <% Controladora controlLogica = new Controladora();
                                                            List <Huesped> listaHuesped = controlLogica.traerHuesped();
                                                            for(Huesped huesped : listaHuesped){
                                                              %>  
                                                            <tr class="row100 body">
                                                                <% String nombreComp = huesped.getNombre() + " " + huesped.getApellido();%>
                                                                <td class="cell100 column1"><%=nombreComp%></td>
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
										<th class="cell100 column2">DNI</th>
										<th class="cell100 column3">Fecha nacimiento</th>
										<th class="cell100 column4">Direccion</th>
										<th class="cell100 column5">Profesión</th>
                                                                                <th class="cell100 column6">Eliminar</th>
                                                                                <th class="cell100 column7">Modificar</th>
										
									</tr>
								</thead>
                                                                
									<% for(Huesped huesped : listaHuesped){ %>
                                                                        <tr class="row100 body">
                                                                        <%String dni = huesped.getDni();%>
                                                                        <td class="cell100 column2"><%=dni%></td>  
                                                                        <%SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");%>
                                                                        <%Date fecha = huesped.getFecha_nac();%>
                                                                        <td class="cell100 column3"><%=formato.format(fecha)%></td> 
                                                                        <%String direccion = huesped.getDireccion();%>
                                                                        <td class="cell100 column4"><%=direccion%></td> 
                                                                        <%String prof = huesped.getProfesion();%>
                                                                        <td class="cell100 column5"><%=prof%></td>
                                                                        <%long id = huesped.getIdHuesped();%>
                                                                        <td class="cell100 column6">
                                                                            
                                                                        
                                                                            <form name="id" action="SvEliminarHuesped" method="POST" >
                                                                                <input type="hidden" name="id" value="<%=id%>">
                                                                                    <button type="submit" class="btn btn-danger" data-title="Delete" style="display:inline; width: 100px;height: 30px;">Eliminar</button>
                                                                                
                                                                                
                                                                            </form>
                                                                                       </td>
                                                                        
                                                                        
                                                                       
                                                                        <td class="cell100 column6">
                                                                            
                                                                        
                                                                            <form name="id" action="SvEditarHuesped" method="POST" >
                                                                                <input type="hidden" name="id" value="<%=id%>">
                                                                                    <button type="submit" class="btn btn-success" data-title="Edit" style="display:inline; width: 100px;height: 30px;">Editar</button>
                                                                                
                                                                                
                                                                            </form>
                                                                                       </td>
                                                                        
                                                                        
                                                                       
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
                              
  
 <form action="index.jsp">
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

