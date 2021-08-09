
package Servlets;

import Logica.Controladora;
import Logica.Huesped;
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


@WebServlet(name = "SvEditarHuesped", urlPatterns = {"/SvEditarHuesped"})
public class SvEditarHuesped extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarHuesped</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarHuesped at " + request.getContextPath() + "</h1>");
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
            String profesion = request.getParameter("profesion");
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha1 = formato.parse(fecha_nac);
            Huesped huesped = controlLogica.buscarHuesped(id);
            huesped.setNombre(nombre);
            huesped.setApellido(apellido);
            huesped.setDni(dni);
            huesped.setFecha_nac(fecha1);
            huesped.setProfesion(profesion);
            huesped.setDireccion(direccion);
            
            controlLogica.modificarHuesped(huesped);
            
            request.getSession().setAttribute("listaHuesped", controlLogica.traerHuesped());
            response.sendRedirect("verHuesped.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id
        long id =  Long.parseLong(request.getParameter("id"));
        //instancio la controladora
        Controladora controlLogica = new Controladora();
        Huesped huesped = controlLogica.buscarHuesped(id);
        
        //traigo sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("huesped", huesped);
        
        response.sendRedirect("modificarHuesped.jsp");
        
        
        
      
    }
   

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
