/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.Serializable;

/**
 *Clase compuesta por los atributos comunes de los clientes, que luego se diferenciaran en Clientes particulares y Anfitriones
 * Hereda de la clase Usuario el correo y la clave 
 * @author Alejandro
 */
public class Cliente extends Usuario implements Serializable {
    
    /**
     *
     */
    public String dni;

    /**
     *
     */
    public String nombre;

    /**
     *
     */
    public String tlf;

    
    //constructor 

    /**
     *
     * @param dni
     * @param nombre
     * @param tlf
     * @param correo
     * @param clave
     */

    public Cliente(String dni, String nombre, String tlf, String correo, String clave) {
        super(correo, clave);
        this.dni = dni;
        this.nombre = nombre;
        this.tlf= tlf;
    }
    
    /**
     *
     */
    public Cliente () {
        
    }

    /**
     * Get the value of tlf
     *
     * @return the value of tlf
     */
    public String getTlf() {
        return tlf;
    }

    /**
     * Set the value of tlf
     *
     * @param tlf new value of tlf
     */
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }


    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of dni
     *
     * @return the value of dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Set the value of dni
     *
     * @param dni new value of dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

  
        
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.dni + " - " + this.nombre + " - " + this.tlf + " - " + this.correo + " - " + this.clave; 
        
    }
    
}
