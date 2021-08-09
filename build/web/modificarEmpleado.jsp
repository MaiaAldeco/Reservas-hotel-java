<%-- 
    Document   : modificarEmpleado
    Created on : 05-ago-2021, 17:53:55
    Author     : Usuario
--%>

<%@page import="Logica.Controladora"%>
<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Empleado"%>
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
            

            <form id="fcf-form-id" class="fcf-form-class" method="GET"action="SvEditarEmpleado">
                <%HttpSession sesion = request.getSession();
                Empleado emple = (Empleado) sesion.getAttribute("emple");
                {
                %>
                
                        <h3 class="fcf-h3">Modificar Empleado</h3>
                    </div>
                    <div class="fcf-form-group">
                        <label for="nombre" class="fcf-label">Nombre</label>

                        <div class="fcf-input-group">

                            <input type="text" id="nombre" name="nombre" class="fcf-form-control"value="<%=emple.getNombre()%>">

                        </div>
                    </div>
                    <div>
                        <label for="apellido" class="fcf-label">Apellido</label>
                        <div class="fcf-input-group">
                            <input type="text" id="apellido" name="apellido" class="fcf-form-control" value="<%=emple.getApellido()%>">
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="dni" class="fcf-label">DNI</label>
                        <div class="fcf-input-group">
                            <input type="text" id="dni" name="dni" class="fcf-form-control" value="<%=emple.getDni()%>">
                        </div>
                    </div>
                    <br>

                    <div class="fcf-form-group">
                        <label for="direccion" class="fcf-label">Dirección</label>
                        <div class="fcf-input-group">
                            <input type="text" id="direccion" name="direccion" class="fcf-form-control" value="<%=emple.getDireccion()%>">
                        </div>
                    </div>
                    <br>
                    <div class="fcf-form-group">
                        <label for="cargo" class="fcf-label">Cargo</label>
                        <div class="fcf-input-group">
                            <input type="text" id="cargo" name="cargo" class="fcf-form-control" value="<%=emple.getCargo()%>">
                        </div>
                    </div>
                      
                    <div>
                        <label for="fecha_nac" class="fcf-label">Fecha nacimiento</label>
                        <div class="fcf-input-group">
                            <%
                                
                                Date fecha = emple.getFecha_nac();
                                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                String fecha1 = formato.format(fecha);%>
                            <input type="date" id="fecha" name="fecha_nac" class="fcf-form-control" value="<%=fecha1%>">
                        </div>
                    </div>
                    <input type="hidden" id="id" name="id" class="fcf-form-control" value="<%=emple.getIdEmpleado()%>">
                    <br>
                    <div class="fcf-input-group">
                            
                           <select name="usuario">
                               <%
                            Controladora controlLogica = new Controladora();
                            List<Usuario> listaUsuario = controlLogica.traerUsuarios();
                            for (Usuario usuario2 : listaUsuario) {
                                 %>
                           <option value="<%=usuario2.getId_usuario()%>"><%=usuario2.getId_usuario()%></option>
                           <%}%>
                                </select>
                       
                             
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
    <%}%>    
    </body>
</html>
