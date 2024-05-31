/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 **Clase compuesta por todos los atributos comunes de los Anfitrion
 *Esta clase hereda los atributos de Usuarios y los de Clientes
 * @author Alejandro
 */
public class Anfitrion extends Cliente implements Serializable {
    
    private LocalDateTime fr; //fecha de registro en la app 
    
    private int calificacion; //calificacion de los anfitriones (media de reseñas)

    
    //constructor
    /**
     *
     * @param dni
     * @param nombre
     * @param tlf
     * @param correo
     * @param clave
     * @param fr
     * @param calificacion
     */
    public Anfitrion(String dni, String nombre, String tlf, String correo, String clave, LocalDateTime fr, int calificacion) {
        super(dni, nombre, tlf, correo, clave);
        this.fr = fr;
        this.calificacion = calificacion;
    }

    /**
     *
     */
    public Anfitrion() {
    }
    
    /**
     * Get the value of calificacion
     *
     * @return the value of calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Set the value of calificacion
     *
     * @param calificacion new value of calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    /**
     * Get the value of fr
     *
     * @return the value of fr
     */
    public LocalDateTime getFr() {
        return fr;
    }

    /**
     * Set the value of fr
     *
     * @param fr new value of fr
     */
    public void setFr(LocalDateTime fr) {
        this.fr = fr;
    }

    
    /**
     *
     * @param resenas
     * @param resena
     */
    public static void agregarResena(List<Integer> resenas, int resena) {
        if (resena >= 0 && resena <= 5) {
            resenas.add(resena);
        } else {
            System.out.println("Esta reseña no es válida: " + resena + ". La puntuación debe estar entre 0 y 5");
        }
    }
          
    //después se calcula la calificación, que es la media de las reseñas

    /**
     *
     * @param resenas
     * @return
     */
    public static double calificacion(List<Integer> resenas) {
        if (resenas.isEmpty()) {
            throw new IllegalArgumentException("La lista de reseñas no puede estar vacía");
        }
        
        int suma = 0;
        for (int resena : resenas) {
            suma += resena;
        }
        
        return (double) suma / resenas.size();
        
    }
    
    /**
     *
     * @return true si this.calificacion tiene un valor superior a 4
     */
    public boolean esSuperAnfitrion(){
        return this.calificacion > 4.0;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Anfitriones{"
                + ", dni='" + this.getDni() + '\''
                + ", nombre='" + this.getNombre() + '\''
                + ", telefono='" + this.getTlf() + '\''
                + ", correo='" + this.getCorreo()
                + ", clave='" + this.getClave() + '\''
                + ", fecha de registro='" + this.fr + '\''
                + ", calificacion='" + this.calificacion + '\''
                + '}';
    }
    
    /**
     *
     * @param a
     * @return
     */
    public int compareTo(Anfitrion a) {
        return this.correo.compareTo(a.getCorreo());
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anfitrion other = (Anfitrion) obj;
        if ((this.correo == null) ? (other.correo != null) : !this.correo.equals(other.correo)) {
            return false;
        }
        return true;
    }
    
}
