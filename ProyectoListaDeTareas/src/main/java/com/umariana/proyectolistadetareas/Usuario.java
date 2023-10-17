package com.umariana.proyectolistadetareas;

//Clase Usuario y sus atrubutos


public class Usuario {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String contraseña;
    //Me permitirá administrar las tareas en una lista
    

//Constructor vacio
    public Usuario() {
    }
//Constructor lleno
    public Usuario(String nombre, String apellido, String cedula, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.contraseña = contraseña;
    }
//Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}