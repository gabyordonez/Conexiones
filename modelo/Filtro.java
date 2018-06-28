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
    private String afp;
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;
    private boolean estado;
    
    public Filtro(){
        
    }
    
    public Filtro(String afp, String nombre, String apellido,int edad, String profesion, boolean estado){
        this.afp = afp;
        this.nombre = nombre;
        this.edad=edad;
        this.estado=estado;
        this.apellido = apellido;
        this.profesion = profesion; 
    }
    public Filtro(String afp, String nombre,String apellido, int edad, boolean estado){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
        this.estado=estado;
        this.afp = afp; 
    }

        
    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
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
