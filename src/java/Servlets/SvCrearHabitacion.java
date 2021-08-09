
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvCrearHabitacion", urlPatterns = {"/SvCrearHabitacion"})
public class SvCrearHabitacion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCrearHabitacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCrearHabitacion at " + request.getContextPath() + "</h1>");
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
            
            String piso = request.getParameter("piso");
            String tematica = request.getParameter("tematica");
            String tipo = request.getParameter("tipo");
            String precio = request.getParameter("precio");
            
            request.getSession().setAttribute("piso", piso);
            request.getSession().setAttribute("tematica", tematica);
            request.getSession().setAttribute("tipo", tipo);
            request.getSession().setAttribute("precio",precio);
            
            response.sendRedirect("index.jsp");
            
            int num_piso = Integer.parseInt(piso);
            int precio_noche = Integer.parseInt(precio);
            System.out.println("precio noche: " + precio_noche);
            
            controlLogica.crearHabitacion(num_piso, tematica, tipo, precio_noche);
        
        
        
        
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
