
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvBuscarReservasEmpleado", urlPatterns = {"/SvBuscarReservasEmpleado"})
public class SvBuscarReservasEmpleado extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvBuscarReservasEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvBuscarReservasEmpleado at " + request.getContextPath() + "</h1>");
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
        
        long empleado = Long.parseLong(request.getParameter("empleado"));
        
        
        
        Controladora controlLogica = new Controladora();
    
        List<Reserva> listaReserva;
        listaReserva = controlLogica.buscarReservaEmpleado(empleado);
        
        System.out.println("El empleado es " + empleado);
      listaReserva.toString();
        
        
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaReserva", listaReserva);
        
                response.sendRedirect("consultaFechasEmple.jsp");
            
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}
