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
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {


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
    
        
        // Recupera los datos del formulario de inicio de sesión
        String cedula=request.getParameter("cedula");
        String contraseña=request.getParameter("contraseña");
        
        //Obtener el contexto del servlet
        ServletContext context = getServletContext();


        // Realiza verificación si un usuario existe
       Usuario person = verificarUsuarios(cedula, contraseña, context);
       //Si el usuario existe se redirige a la página de tareas

        if (person != null) {
            request.setAttribute("cedula", person.getCedula());
            request.setAttribute("nombre", person.getNombre());
            request.getRequestDispatcher("formTareas.jsp").forward(request, response);
        }else{
            //Si el usuario no existe se redirige a la pagina inicial
            request.getRequestDispatcher("index.jsp?noExiste= " + "false").forward(request, response);
        }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Usuario verificarUsuarios(String cedulaV, String contraseñaV, ServletContext context) throws IOException{
        
        ArrayList<Usuario>usuarios=new ArrayList<>();
        LeerUsuarios.leerArchivo(usuarios, context);
        
        for(Usuario u:usuarios){
            if(u.getCedula().equals(cedulaV)&& u.getContraseña().equals(contraseñaV)){
                return u;
            }
       
        }
        return null;
    }
}

