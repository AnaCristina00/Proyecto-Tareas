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
                pluma.write(linea);
                pluma.write("/n");
                
            }
            pluma.close();
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        
        }
   }
           
   public static void leerArchivo(ArrayList<Usuario>usuarios, ServletContext context)
           throws FileNotFoundException, IOException{
       
        //Ubicacion del archivo
        String rutaRelativa="/data/usuarios.txt";
        String rutaAbsoluta=context.getRealPath(rutaRelativa);
        File archivo=new File(rutaAbsoluta);
        
        try(FileReader fr = new FileReader(archivo); BufferedReader lector = new BufferedReader(fr)){
            
            String linea;
            
            while((linea=lector.readLine())!=null){
                
                String[]campos=linea.split(",");
                String nombre = campos[0];
                String apellido = campos[1];
                String cedula = campos[2];
                String contraseña = campos[3];
                
                //Objeto que almacenará los datos para agregarlos al archivo
                Usuario usuario=new Usuario(nombre, apellido, cedula, contraseña);
                usuarios.add(usuario);
                
            }
                    
                }catch(FileNotFoundException e){
                    System.out.println(e.getMessage());
                    
                    }catch(IOException e){
                            System.out.println(e.getMessage());
     
        }
       
   }
}

