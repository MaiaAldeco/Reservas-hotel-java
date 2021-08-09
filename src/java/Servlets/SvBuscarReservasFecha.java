
package Servlets;

import Logica.Controladora;
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


@WebServlet(name = "SvBuscarReservasFecha", urlPatterns = {"/SvBuscarReservasFecha"})
public class SvBuscarReservasFecha extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvBuscarReservasFecha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvBuscarReservasFecha at " + request.getContextPath() + "</h1>");
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
        
        try {
            String fecha = request.getParameter("fecha");
            
            request.getSession().setAttribute("fecha", fecha);
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaBuscar = formato.parse(fecha);
            
            
            
            Controladora controlLogica = new Controladora();
             List<Reserva> listaReservas;
             
             listaReservas = controlLogica.reservaPorFecha(fecha);
        
       
       
            

            if(listaReservas!= null){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaReservas", listaReservas);
        
                response.sendRedirect("consultaFechas.jsp");
            }else{
                response.sendRedirect("noHayFecha.jsp");
            }
            
            
        } catch (ParseException ex) {
            Logger.getLogger(SvBuscarReservasFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
