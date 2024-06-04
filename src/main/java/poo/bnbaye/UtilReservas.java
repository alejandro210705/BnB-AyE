/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.util.ArrayList;
/**
 *
 * @author Alejandro
 */
public class UtilReservas {
    
    
   private static ArrayList<Reserva> reservas = new ArrayList<>();
   
   /** Establece el ArrayList de inmuebles
    * @param reserva 
    * @return boolean
    */
    public static boolean eliminarReserva(Reserva reserva){
        if(reservas.contains(reserva)){
            reservas.remove(reserva);
            return true;
        }else {
            return false;
        }
    }
    
    public static ArrayList<Reserva> getReservasParticular(Particular parti){
        ArrayList<Reserva> reservasParti = new ArrayList<>();
        for(Reserva reserva:reservas){
            if(reserva.getParti().getCorreo().equals(parti.getCorreo())){
                reservasParti.add(reserva); 
            }
        }
        return reservasParti;
    }
    
     public static ArrayList<Reserva> getReservasInmueble(Inmueble inmueble){
        ArrayList<Reserva> reservasAnfi = new ArrayList<>();
        for (Reserva res: reservas){
            if(res.getInmu().getTitulo().equals(inmueble.getTitulo())){
                reservasAnfi.add(res);
            }
        }
        return reservasAnfi;
    }
    
     
     

    
   


   
}
