/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *Clase compuesta por todos los atributos comunes de los clientes particulares
 *Esta clase hereda los atributos de Usuario y los de Cliente
 * @author Alejandro
 */
public class Particular extends Cliente implements Serializable {
    
    public String nomT; //nombre titular de la tarjeta 
    
    public String numT; //numero de la tarjeta 
    
    public LocalDate fcT; //fecha de caducidad de la tarjeta 
    
    public boolean vip; //si el cliente particular es vip o no 

    
    
    //constructor
    /**
     * @param dni
     * @param nombre
     * @param tlf
     * @param correo
     * @param clave
     * @param nomT
     * @param numT
     * @param fcT
     * @param vip
     */
    
    public Particular(String dni, String nombre, String tlf, String correo, String clave, String nomT, String numT, LocalDate fcT, boolean vip) {
        super(dni, nombre, tlf, correo, clave);
        this.nomT = nomT;
        this.numT = numT;
        this.fcT = fcT;
        this.vip = vip;
    }
    
    /**
     *
     */
    public Particular() {
    }

    /**
     * Get the value of vip
     *
     * @return the value of vip
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * Set the value of vip
     *
     * @param vip new value of vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }


    /**
     * Get the value of fcT
     *
     * @return the value of fcT
     */
    public LocalDate getFcT() {
        return fcT;
    }

    /**
     * Set the value of fcT
     *
     * @param fcT new value of fcT
     */
    public void setFcT(LocalDate fcT) {
        this.fcT = fcT;
    }


    /**
     * Get the value of numT
     *
     * @return the value of numT
     */
    public String getNumT() {
        return numT;
    }

 
    /**
     * Set the value of numT
     *
     * @param numT new value of numT
     */
    public void setNumT(String numT) {
        this.numT = numT;
        //vamos a verficar que el numero no es nulo, contiene exactamente 16 
        //digitos y con ("\\d+") comprobamos que solo tiene caracteres numericos
        if (numT!= null && numT.length()==16 && numT.matches("\\d+")){
            this.numT = numT;
        } else {
            throw new IllegalArgumentException ("El numero de la terjeta debe tener exactamente 16 digitos que sean numericos");
        }
    }

    /**
     * Get the value of nomT
     *
     * @return the value of nomT
     */
    public String getNomT() {
        return nomT;
    }

    /**
     * Set the value of nomT
     *
     * @param nomT new value of nomT
     */
    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Particular{"
                + ", dni='" + this.getDni() + '\''
                + ", nombre='" + this.getNombre() + '\''
                + ", telefono='" + this.getTlf() + '\''
                + ", correo='" + this.getCorreo()
                + ", clave='" + this.getClave() + '\''
                + ", nombre titular de la tarjeta ='" + this.nomT + '\''
                + ", numero tarjeta='" + this.numT + '\''
                + ", fecha caducidad de la tarjeta ='" + this.fcT + '\''
                + ", vip ='" + this.vip + '\''
                + '}';
                
             
    }

    /**
     *
     * @param p
     * @return
     */
    public int compareTo(Particular p) {
        return this.correo.compareTo(p.getCorreo());
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
        final Particular other = (Particular) obj;
        if ((this.correo == null) ? (other.correo != null) : !this.correo.equals(other.correo)) {
            return false;
        }
        return true;
    }

    Boolean getVip() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    

}
