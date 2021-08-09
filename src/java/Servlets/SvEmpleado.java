
package Servlets;

import Logica.Controladora;
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


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Controladora controlLogica = new Controladora();
         
        try {
            //traer datos de la interfaz gráfica (JSP)
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String direccion = request.getParameter("direccion");
            String fecha_nac = request.getParameter("fecha_nac");
            String cargo = request.getParameter("cargo");
            String usuario = request.getParameter("usuario");
            
            
            
            
            
            //traer la sesion y asignar los atributos para abrir desde cualquier jsp
            request.getSession().setAttribute("nombre", nombre);
            request.getSession().setAttribute("apellido", apellido);
            request.getSession().setAttribute("dni", dni);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("fecha_nac", fecha_nac);
            request.getSession().setAttribute("cargo", cargo);
            request.getSession().setAttribute("usuario", usuario);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Usuario usu = controlLogica.buscarUsuario(Long.parseLong(usuario));
            
            Date fecha1 = formato.parse(fecha_nac);
            //armar response
            
            response.sendRedirect("index.jsp");
   
            //llamar a controladora lógica
            
            controlLogica.crearEmpleado(usu, dni, nombre, apellido, fecha1, direccion, cargo);
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
   
        
        
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
