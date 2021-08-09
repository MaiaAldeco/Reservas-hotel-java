/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
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

@WebServlet(name = "SvHuesped", urlPatterns = {"/SvHuesped"})
public class SvHuesped extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvHuesped</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvHuesped at " + request.getContextPath() + "</h1>");
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
            //traer datos de la interfaz gráfica (JSP)
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String direccion = request.getParameter("direccion");
            String fecha_nac = request.getParameter("fecha_nac");
            String profesion = request.getParameter("profesion");
            
            
            
            //traer la sesion y asignar los atributos para abrir desde cualquier jsp
            request.getSession().setAttribute("nombre", nombre);
            request.getSession().setAttribute("apellido", apellido);
            request.getSession().setAttribute("dni", dni);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("fecha_nac", fecha_nac);
            request.getSession().setAttribute("profesion", profesion);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            Date fecha1 = formato.parse(fecha_nac);
            //armar response
            
            response.sendRedirect("index.jsp");
   
            //llamar a controladora lógica
            Controladora controlLogica = new Controladora();
            controlLogica.crearHuesped(dni, nombre, apellido, fecha1, direccion, profesion);
        } catch (ParseException ex) {
            Logger.getLogger(SvHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   
        }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
    
