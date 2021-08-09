
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvLogin at " + request.getContextPath() + "</h1>");
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
       
        
        
        
         //variables auxiliares. Traigo los datos de la interfaz
        String usuario = request.getParameter("username");
        String contrasenia = request.getParameter("pass");
        
        //instancia controladora, conectar servlet con lógica
        Controladora controlLogica = new Controladora();
        //creo una variable donde se almacena el método de mi controladora 
        boolean autorizacion = false;
        autorizacion = controlLogica.verificarUsuario(usuario,contrasenia);
        //pregunto si se encuentra el usuario
        if (autorizacion){
            //traigo la sesion y asigno usuario y contraseña 
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("usuario", usuario);
            misesion.setAttribute("contrasenia", contrasenia);
            
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
