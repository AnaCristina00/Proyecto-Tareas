package Servlets;

import com.umariana.proyectolistadetareas.LeerUsuarios;
import com.umariana.proyectolistadetareas.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
        //Obtener el contexto del servlet
        ServletContext context = getServletContext();
        
        // Recupera los datos del formulario de inicio de sesión
        String cedula=request.getParameter("cedula");
        String contraseña=request.getParameter("contraseña");


        // Realiza autenticación
        boolean verificado = verificarCredenciales(cedula, contraseña);

        if (verificado) {
            // Usuario verificado, se redirecciona a la página de tareas
            response.sendRedirect("formTareas.jsp");
        } else {
            // Usuario no verificado, muestra un mensaje de error
            request.setAttribute("Error", "Datos incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    private boolean verificarCredenciales(String cedula, String contraseña) throws IOException{
         // Obtenemos la lista de usuarios desde el archivo usuarios.txt
        ArrayList<Usuario> usuarios = LeerUsuarios.obtenerUsuarios("/data/usuarios.txt");
        
        for(Usuario usuario:usuarios){
            //Comparamos la cedula y la contraseña
            if(usuario.getCedula().equals(cedula)&&usuario.getContraseña().equals(contraseña)){
                return true; //Validacion correcta
            }
            
        }
        
        return false;//Validacion incorrecta
    }
  

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
