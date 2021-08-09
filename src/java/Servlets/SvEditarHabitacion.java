
package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarHabitacion", urlPatterns = {"/SvEditarHabitacion"})
public class SvEditarHabitacion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarHabitacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarHabitacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Controladora controlLogica = new Controladora();
            
            long id =  Long.parseLong(request.getParameter("id"));
            
            String tematica = request.getParameter("tematica");
            String piso = request.getParameter("piso");
            String tipo = request.getParameter("tipo");
            
           // String reserva = request.getParameter("reserva");
          
            int piso_habitacion = Integer.parseInt(piso);
            Habitacion habi = controlLogica.buscarHabitacion(id);
         //   Reserva rese = controlLogica.buscarReserva(Long.parseLong(reserva));
            habi.setTematica(tematica);
            habi.setPiso_habitacion(piso_habitacion);
            habi.setTipoHabitacion(tipo);
         //  habi.setListaReserva(listaReserva);
            
            controlLogica.modificarHabitacion(habi);
            
            request.getSession().setAttribute("listaHabitacion", controlLogica.traerHabitacion());
            response.sendRedirect("verHabitacion.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id
        long id =  Long.parseLong(request.getParameter("id"));
        //instancio la controladora
        Controladora controlLogica = new Controladora();
        Habitacion habi = controlLogica.buscarHabitacion(id);
        
        //traigo sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("habi", habi);
        
        response.sendRedirect("modificarHabitacion.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
