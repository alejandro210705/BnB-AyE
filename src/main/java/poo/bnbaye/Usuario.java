/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.Serializable;

/**
 *clase usuario que contiene los atributos que comparten todos los usuarios de la app, tanto clientes como administradores
 * con ADMIN_CORREO y ADMIN_CLAVE llevamos a cabo el inicio de sesión de los administradores, corroborando que tiene ese correo y clave 
 * @author Alejandro
 */

public class Usuario implements Serializable {
    
    /**
     *
     */
    public String correo;

    /**
     *
     */
    public String clave;
    
    /**
     *
     */
    public static final String ADMIN_CORREO = "admin@javabnb.com";

    /**
     *
     */
    public static final String ADMIN_CLAVE = "admin";
    

    
    /**
     *
     * @param correo
     * @param clave
     */
    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    /**
     *
     */
    public Usuario(){
        
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getClave() {
        return clave;
    }

    /**
     *
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    
    /**
     *
     * @return
     */
    public boolean esAdministrador(){
        return ADMIN_CORREO.equals(this.correo) && ADMIN_CLAVE.equals(this.clave);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.correo + " - " + this.clave;
    }
    
    
}

