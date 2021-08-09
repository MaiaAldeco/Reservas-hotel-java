
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvCrearReserva", urlPatterns = {"/SvCrearReserva"})
public class SvCrearReserva extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCrearReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCrearReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // request.setAttribute("totalReserva", totalReserva);
       // RequestDispatcher rd = request.getRequestDispatcher("infoReserva.jsp");
       // rd.forward(request,response);
        
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Controladora controlLogica = new Controladora();
            
            String checkin = request.getParameter("checkin");
            String checkout = request.getParameter("checkout");
            String huesped = request.getParameter("huesped");
            String empleado = request.getParameter("empleado");
            String habitacion = request.getParameter("habitacion");
            String cantidadPerso = request.getParameter("cantidadPerso");
            String emision = request.getParameter("emision");
            
            
            request.getSession().setAttribute("checkin", checkin);
            request.getSession().setAttribute("checkout", checkout);
            request.getSession().setAttribute("huesped", huesped);
            request.getSession().setAttribute("empleado", empleado);
            request.getSession().setAttribute("habitacion", habitacion);
            request.getSession().setAttribute("cantidadPerso", cantidadPerso);
            request.getSession().setAttribute("emision", emision);
         
            
            int cantPerso = Integer.parseInt(cantidadPerso);
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            
            Huesped huesped1 = controlLogica.buscarHuesped(Long.parseLong(huesped));
            Empleado emple = controlLogica.buscarEmpleado(Long.parseLong(empleado));
            Habitacion habita = controlLogica.buscarHabitacion(Long.parseLong(habitacion));
            
            String tipoH = habita.getTipoHabitacion();
            int precio = habita.getPrecio();
            System.out.println("El precio es " + precio);
            
            long id_habitacion = habita.getId_habitacion();
            
            Date checkIN = formato.parse(checkin);
            Date checkOUT = formato.parse(checkout);
            Date emision2 = formato.parse(emision);
          
            
            int milisecondsByDay = 86400000;
            int dias = (int) ((checkOUT.getTime()-checkIN.getTime())/milisecondsByDay);
            System.out.println("DIAS " + dias);
            boolean tipoHab = false;
            boolean estaOno = false;
            
            tipoHab = controlLogica.verificarTipo(tipoH, cantPerso);
            
            estaOno = controlLogica.laFechaEsValidaOno(id_habitacion,checkIN,checkOUT);
            
            
            int totalReserva = controlLogica.calcularTotal(dias,precio);
            
            System.out.println("El total antes del parseo: " + totalReserva);
            request.setAttribute("totalReserva", totalReserva);
            System.out.println("EL TOTAL ES: " + totalReserva);
           
            
            if (tipoHab==false){
                
                response.sendRedirect("crearReservaError.jsp");

               }else if(estaOno==true){
                   
                response.sendRedirect("crearReservaErrorFecha.jsp");
                
                     }else if(tipoHab==true&&estaOno==false){
                         
                       controlLogica.crearReserva(emple,huesped1,checkIN,checkOUT,habita,cantPerso, totalReserva, emision2);
                       
                      
        
                       response.sendRedirect("verReservaPrecioFinal.jsp");
                       
                       
              //  response.sendRedirect("index.jsp");
            }
            
            
           
            
            
            
            
            
        
        
        
    }   catch (ParseException ex) {
            Logger.getLogger(SvCrearReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
