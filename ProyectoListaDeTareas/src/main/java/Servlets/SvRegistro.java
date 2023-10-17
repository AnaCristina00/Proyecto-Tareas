package Servlets;

import com.umariana.proyectolistadetareas.LeerUsuarios;
import com.umariana.proyectolistadetareas.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
         //OPCIÓN DE REGISTRO
        
        //Contexto de la sesión
        HttpSession session=request.getSession();
        //Contexto del servlet
        ServletContext context = getServletContext();
        
        //Array que contiene objetos de tipo Usuario
        ArrayList<Usuario>usuarios=new ArrayList<>();
        //Lee los usuarios existentes en el archivo
        LeerUsuarios.leerArchivo(usuarios, context);
        
        //Recuperamos los datos registrados en el formulario
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String cedula=request.getParameter("cedula");
        String contraseña=request.getParameter("contraseña");
        
        //Verifica si ya existe la cedula 
        boolean cedulaExist=false;
        
        for(Usuario existUsuario:usuarios){
            if(existUsuario.getCedula().equals(cedula)){
                cedulaExist=true;
                break;     
            }
        }
        if(!cedulaExist){
            Usuario usuario=new Usuario(nombre, apellido, cedula, contraseña);
            usuarios.add(usuario);
            
            //Escribe los usuarios actualizados
            LeerUsuarios.escribirArchivo(usuarios, context);
            //Indicar que el usuario se agregó correctamente
            String existente="verdadero";
            request.setAttribute("existente", existente);
            //Si la cédula ya existe
        }else{
            String existente="falso";
            request.setAttribute("existente", existente);
        }
        
        //redirige a la pagina inicial
        RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    
       }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
