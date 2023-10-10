package com.umariana.proyectolistadetareas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class LeerUsuarios {
    
   public static ArrayList<Usuario> obtenerUsuarios(String rutaArchivo)throws IOException{
        ArrayList<Usuario> usuarios=new ArrayList<>();
        
     try(BufferedReader reader=new BufferedReader(new FileReader("/data/usuarios.txt"))) {
         String linea;
         while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 4) {
                    String nombre = campos[0];
                    String apellido = campos[1];
                    String cedula = campos[2];
                    String contraseña = campos[3];
                    
                    Usuario usuario = new Usuario();
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setCedula(cedula);
                    usuario.setContraseña(contraseña);

                    usuarios.add(usuario);
        }  
                   
    }
          return usuarios;
        }
   } 
   
   public static void escribirArchivo(ArrayList<Usuario>usuarios, ServletContext context)
            throws FileNotFoundException{
        
        //Ubicacion del archivo
        String rutaRelativa="/data/usuarios.txt";
        String rutaAbsoluta=context.getRealPath(rutaRelativa);
        File archivo=new File(rutaAbsoluta);
        
        try(PrintWriter pluma= new PrintWriter(archivo)){
            //Itera en la lista de usuarios y escribe los datos en el archivo
            for(Usuario usuario:usuarios){
                //Elimina los datos del usuario en una linea y escribe en el archivo
                String linea=usuario.getNombre()+","+usuario.getApellido()+","+usuario.getCedula()+","+usuario.getContraseña();
                pluma.println(linea);
            }
        }catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        }
        
        
    }
           
}

