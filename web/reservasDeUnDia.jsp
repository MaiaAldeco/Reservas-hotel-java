

<%@page import="Logica.Huesped"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.Empleado"%>
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

            if (usuario == null) {
                response.sendRedirect("login.jsp");
            } else {

        %>

        <div class="fcf-body">


            <div id="fcf-form">
                <form name="id" action="index.jsp" method="POST" >
                    <div class="fcf-form-group">
                        <button type="submit" class="btnInicio">Inicio</button></div>
                </form>

                <h3 class="fcf-h3">Buscar Reserva</h3>

                <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvBuscarReservasFecha" >


                    <div class="fcf-form-group">
                        <label for="fecha" style="font-size: 30px;" class="fcf-label">Fecha a consultar</label>

                        <div class="fcf-input-group">

                            <input type="date" id="fecha" name="fecha" class="fcf-form-control" required>

                        </div>
                    </div>
                    <div class="fcf-form-group">
                        <button type="submit" style="left:0;top:0;margin:0"  id="fcf-button">Buscar</button>
                    </div>
                </form>
                <br>
                <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvBuscarReservasEmpleado">
                    <div>
                        <label for="emple" style="font-size: 30px;" class="fcf-label">Consultar reservas de un empleado: </label>
                        <div class="fcf-input-group">

                            <select name="empleado" class="select" >
                                <%  Controladora controlLogica = new Controladora();
                                    List<Empleado> listaEmpleado = controlLogica.traerEmpleados();
                                    for (Empleado emple : listaEmpleado) {


                                %>
                                <option value="<%=emple.getIdEmpleado()%>"><%=emple.getNombre()%></option>
                                <% } %> 
                            </select>
                            

                        </div>

                    </div>
                            <br>
                            <div class="fcf-form-group">
                        <button type="submit" style="left:0;top:0;margin:0"  id="fcf-button">Buscar</button>
                    </div>
                </form>
                    <br>
                    <form id="fcf-form-id" class="fcf-form-class" method="post"action="SvBuscarReservasHuesped">
                        <div>
                            <label for="emple" style="font-size: 30px;" class="fcf-label">Consultar reservas de un huesped: </label>
                            <div class="fcf-input-group">

                                <select name="huesped" class="select" >
                                    <%  
                                        List<Huesped> listaHuesped = controlLogica.traerHuesped();
                                        for (Huesped huesped : listaHuesped) {


                                    %>
                                    <option value="<%=huesped.getIdHuesped()%>"><%=huesped.getNombre()%></option>
                                    <% } %> 
                                </select>


                            </div>

                        </div>
                                <br>
                                <div class="fcf-form-group">
                        <label for="desde" class="fcf-label">Desde</label>

                        <div class="fcf-input-group">

                            <input type="date" id="desde" name="desde" class="fcf-form-control" required>

                        </div>
                    </div>
                                
                                <div class="fcf-form-group">
                        <label for="hasta" class="fcf-label">Hasta</label>

                        <div class="fcf-input-group">

                            <input type="date" id="hasta" name="hasta" class="fcf-form-control" required>

                        </div>
                    </div>
                               



                        <div class="fcf-form-group">
                            <button type="submit" style="left:0;top:0;margin:0" id="fcf-button">Buscar</button>
                        </div>




                    </form>

            </div>

        </div>


        <%}%>
    </body>
</html>
