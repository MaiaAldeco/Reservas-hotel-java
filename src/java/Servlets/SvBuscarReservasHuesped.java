
package Servlets;

import Logica.Controladora;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvBuscarReservasHuesped", urlPatterns = {"/SvBuscarReservasHuesped"})
public class SvBuscarReservasHuesped extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvBuscarReservasHuesped</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvBuscarReservasHuesped at " + request.getContextPath() + "</h1>");
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
       
        
        
            long huesped = Long.parseLong(request.getParameter("huesped"));
            String desde = request.getParameter("desde");
            String hasta = request.getParameter("hasta");
            
            request.getSession().setAttribute("huesped", huesped);
            request.getSession().setAttribute("desde", desde);
            request.getSession().setAttribute("hasta", hasta);
            
            Controladora controlLogica = new Controladora();
            List<Reserva> listaReservas;
            
            
            
            listaReservas = controlLogica.buscarPorHuesped(huesped, desde, hasta);
            
            
            
            
            
            if(listaReservas!= null){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaReservas", listaReservas);
        
                response.sendRedirect("consultaHuesped.jsp");
            }else{
                response.sendRedirect("noHayFecha.jsp");
            }
            
            
            
            
            
            
            
            
       
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
