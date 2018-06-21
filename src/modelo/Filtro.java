/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gabyordonez
 */
public class Filtro {
    private int afp;
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;
    private boolean estado;
    
    public Filtro(){
        
    }
    
    public Filtro(int afp, String nombre, String apellido, int edad, boolean estado, String profesion){
        this.afp = afp;
        this.nombre = nombre;
        this.edad=edad;
        this.estado=estado;
        this.apellido = apellido;
        this.profesion = profesion; 
    }
    public Filtro(int afp, String nombre,String apellido, int edad, boolean estado){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
        this.estado=estado;
        this.afp = afp; 
    }
    public Filtro(int afp, String nombre, String apellido, boolean estado){
        this.afp = afp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    
    public Filtro(String nombre, String apellido, String profesion, boolean estado){
        this.profesion = profesion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    
    public Filtro(String nombre, String apellido, boolean estado){
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    
    public Filtro(int afp, boolean estado){
        this.afp = afp;
        this.estado = estado;
    }

    
    
    public int getAfp() {
        return afp;
    }

    public void setAfp(int afp) {
        this.afp = afp;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
        public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
}
