<%-- 
    Document   : principal
    Created on : 29-jul-2021, 20:58:26
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Simple Responsive Admin</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
     
    
    <%
        
        HttpSession misesion = request.getSession();
        
        String usuario = (String) misesion.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("login.jsp");
        } else {
    
    %>
           
    
    <div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img id = 'asd'src="https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/4_avatar-256.png" />

                    </a>
                    
                </div>
              
                
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                 


                    <li class="active-link">
                        <a href="index.jsp" ><i class="fa fa-desktop "></i>Inicio </a>
                    </li>
                   
                    <li>
                        <a href="crearHuesped.jsp"><i class="fa fa-table "></i>Crear Huesped</a>
                    </li>
                    <li>
                        <a href="verHuesped.jsp"><i class="fa fa-table "></i>Ver huesped</a>
                    </li>
                    <li>
                        <a href="crearHabitacion.jsp"><i class="fa fa-table "></i>Crear Habitación</a>
                    </li>
                    <li>
                        <a href="verHabitacion.jsp"><i class="fa fa-table "></i>Ver habitaciones</a>
                    </li>
                    <li>
                        <a href="crearReserva.jsp"><i class="fa fa-edit "></i>Crear reservas</a>
                    </li>
                    <li>
                        <a href="verReserva.jsp"><i class="fa fa-table "></i>Ver reservas</a>
                    </li>
                    <li>
                        <a href="reservasDeUnDia.jsp"><i class="fa fa-table "></i>Consultar reservas</a>
                    </li>
                    

                    <li>
                        <a href="crearUsuario.jsp"><i class="fa fa-qrcode "></i>Agregar usuario</a>
                    </li>
                    <li>
                        <a href="verUsuarios.jsp"><i class="fa fa-table "></i>Ver Usuarios</a>
                    </li>
                    <li>
                        <a href="crearEmpleado.jsp"><i class="fa fa-qrcode "></i>Agregar empleados</a>
                    </li>
                    <li>
                        <a href="verEmpleado.jsp"><i class="fa fa-qrcode "></i>Ver empleados</a>
                    </li>
                    </ul>
                            </div>

        </nav>
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                     <h2>ADMINISTRACIÓN</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>Bienvenido! </strong> Que tengas un buen día de trabajo.
                        </div>
                       
                    </div>
                    </div>
                  <!-- /. ROW  --> 
                            <div class="row text-center pad-top">
                  <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    
                   
                  </div>
              </div>
                  <div id="content"> </div> 
                  <div class="footer"> 
      
    
            <div class="row">
                <div class="col-lg-12" style="text-align: center;" >
                    &copy;  2021 
                </div>
            </div>
        </div>
          

     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
 
    <%}%>
    </body>
</html>
