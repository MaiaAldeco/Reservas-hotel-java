
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarEmpleado", urlPatterns = {"/SvEditarEmpleado"})
public class SvEditarEmpleado extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Controladora controlLogica = new Controladora();
            
            long id =  Long.parseLong(request.getParameter("id"));
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String direccion = request.getParameter("direccion");
            String fecha_nac = request.getParameter("fecha_nac");
            String cargo = request.getParameter("cargo");
            long usuario = Long.parseLong(request.getParameter("usuario"));
           
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha1 = formato.parse(fecha_nac);
            Empleado emple = controlLogica.buscarEmpleado(id);
            Usuario usu = controlLogica.buscarUsuario(usuario);
            emple.setNombre(nombre);
            emple.setApellido(apellido);
            emple.setDni(dni);
            emple.setFecha_nac(fecha1);
            emple.setCargo(cargo);
            emple.setDireccion(direccion);
            emple.setUsuario(usu);
            
            controlLogica.modificarEmpleado(emple);
            
            request.getSession().setAttribute("listaEmpleado", controlLogica.traerEmpleados());
            response.sendRedirect("verEmpleado.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //traigo la id
        long id =  Long.parseLong(request.getParameter("id"));
        //instancio la controladora
        Controladora controlLogica = new Controladora();
        Empleado emple = controlLogica.buscarEmpleado(id);
        
        //traigo sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("emple", emple);
        
        response.sendRedirect("modificarEmpleado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
