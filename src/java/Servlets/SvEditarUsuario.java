
package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Controladora controlLogica = new Controladora();
            
            long id =  Long.parseLong(request.getParameter("id"));
            
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            
            Usuario usu = controlLogica.buscarUsuario(id);
            System.out.println("id DE GET: " + id);
            usu.setUsuario(usuario);
            usu.setContrasenia(contrasenia);
            
            controlLogica.modificarUsuario(usu);
            
            request.getSession().setAttribute("listaUsuarios", controlLogica.traerUsuarios());
            response.sendRedirect("verUsuarios.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traigo la id
        long id =  Long.parseLong(request.getParameter("id"));
 
        System.out.println("esta es la id: " + id);
        
        
        //instancio la controladora
        Controladora controlLogica = new Controladora();
        Usuario usuario = controlLogica.buscarUsuario(id);
        
        //traigo sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usuario);
        
        response.sendRedirect("modificarUsuario.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
