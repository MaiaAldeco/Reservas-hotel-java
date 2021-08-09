
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
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


@WebServlet(name = "SvEditarReserva", urlPatterns = {"/SvEditarReserva"})
public class SvEditarReserva extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarReserva at " + request.getContextPath() + "</h1>");
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
            
            String checkin = request.getParameter("checkin");
            String checkout = request.getParameter("checkout");
            String huesped = request.getParameter("huesped");
            String empleado = request.getParameter("empleado");
            String habitacion = request.getParameter("habitacion");
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date checkIN = formato.parse(checkin);
            Date checkOUT = formato.parse(checkout);
            Huesped huesped1 = controlLogica.buscarHuesped(Long.parseLong(huesped));
            Empleado emple = controlLogica.buscarEmpleado(Long.parseLong(empleado));
            Habitacion habita = controlLogica.buscarHabitacion(Long.parseLong(habitacion));
            Reserva reserva = controlLogica.buscarReserva(id);
            reserva.setCheckin(checkIN);
            reserva.setCheckout(checkOUT);
            reserva.setEmpleado(emple);
            reserva.setHuesped(huesped1);
            reserva.setHabitacion(habita);
            
            controlLogica.modificarReserva(reserva);
            
            request.getSession().setAttribute("listaReserva", controlLogica.traerReservas());
            response.sendRedirect("verReserva.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id =  Long.parseLong(request.getParameter("id"));
        //instancio la controladora
        Controladora controlLogica = new Controladora();
        Reserva reserva = controlLogica.buscarReserva(id);
        
        //traigo sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("reserva", reserva);
        
        response.sendRedirect("modificarReserva.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
