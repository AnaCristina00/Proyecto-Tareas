package Servlets;

import com.umariana.proyectolistadetareas.LeerUsuarios;
import com.umariana.proyectolistadetareas.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistro", urlPatterns = {"/SvRegistro"})
public class SvRegistro extends HttpServlet {
    
    //Creo el ArrayList
    ArrayList<Usuario>usuarios=new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Contexto del servlet
        ServletContext context = getServletContext();
        
        //OPCIÓN DE REGISTRO
    //Recuperamos los datos registrados en el formulario
    String nombre=request.getParameter("nombre");
    String apellido=request.getParameter("apellido");
    String cedula=request.getParameter("cedula");
    String contraseña=request.getParameter("contraseña");

    
    // Valida que los campos requeridos no estén vacíos
       if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || contraseña!=null&& !contraseña.isEmpty()) {
    // Muestra un mensaje de error o realiza una redirección a la página de registro con un mensaje de error
    request.setAttribute("error", "Llena toldos los campos");
    request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else{
    
    //Instanciamos el usuario y los atributos
    Usuario usuario=new Usuario();
    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    usuario.setCedula(cedula);
    usuario.setContraseña(contraseña);
       
  
    //Llamamos el método donde guardamos el usuario en un archivo txt
    LeerUsuarios.escribirArchivo(usuarios, context);
     
    //redirige a la pagina inicial
    response.sendRedirect("index.jsp"); 
    
       }
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
