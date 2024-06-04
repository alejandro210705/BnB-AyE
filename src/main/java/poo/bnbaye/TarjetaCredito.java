/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.time.LocalDate;

/**
 *Clase en la que guardamos los atributos de tarjeta de crédito para tener mejor acceso desde otras clases y poner las condiciones
 * @author eva
 */
public class TarjetaCredito {
    
    /**
     *
     */
    public String nomT;
    
    /**
     *
     */
    public String numT;
    
    /**
     *
     */
    public LocalDate fc;

    //constructor 
    /**
     *
     * @param nomT
     * @param numT
     * @param fc
     */
    public TarjetaCredito(String nomT, String numT, LocalDate fc) {
        this.nomT = nomT;
        this.numT = numT;
        this.fc = fc;
    }

    /**
     * Get the value of fc
     *
     * @return the value of fc
     */
    public LocalDate getFc() {
        return fc;
    }

    /**
     * Set the value of fc
     *
     * @param fc new value of fc
     */
    public void setFc(LocalDate fc) {
        this.fc = fc;
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

}
