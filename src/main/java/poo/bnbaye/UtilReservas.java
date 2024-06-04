/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import poo.bnbaye.Reserva;
/**
 *
 * @author Alejandro
 */
public class UtilReservas implements Serializable{
    
    
   private static ArrayList<Reserva> reservas = new ArrayList<>();
   
   
   
    /**
     *añade una reserva al arraylist de reservas comprobando antes si ya está en el arraylist
     * @param reserva
     * @return boolean
     * @throws java.io.IOException
     */
    public static boolean crearReserva(Reserva reserva) throws IOException{
        if(!reservas.contains(reserva)){
            reservas.add(reserva);
            
            tarjetaCredito(reserva);
            
            LocalDateTime fechaEntrada = reserva.getFechaEntrada();
            LocalDateTime fechaSalida = reserva.getFechaSalida();
            //long noches = (fechaEntrada.getFechaEntrada()-fechaSalida.getFechaSalida())/ (1000 * 60 * 60 * 24);
            long noches = 4;
            
            generaFactura(reserva, noches);
            
            return true;
        }else {
            return false;
        }
    }

   
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
    
    /**
     *
     * @param parti
     * @return
     */
    public static ArrayList<Reserva> getReservasParticular(Particular parti){
        ArrayList<Reserva> reservasParti = new ArrayList<>();
        for(Reserva reserva:reservas){
            if(reserva.getParti().getCorreo().equals(parti.getCorreo())){
                reservasParti.add(reserva); 
            }
        }
        return reservasParti;
    }
    
    /**
     *
     * @param inmueble
     * @return
     */
    public static ArrayList<Reserva> getReservasInmueble(Inmueble inmueble){
        ArrayList<Reserva> reservasAnfi = new ArrayList<>();
        for (Reserva res: reservas){
            if(res.getInmu().getTitulo().equals(inmueble.getTitulo())){
                reservasAnfi.add(res);
            }
        }
        return reservasAnfi;
    }
     
     
       /**
     *ordena el arrayList de reservas por fecha
     * @param reservas
     * @return arraylist de reservas ordenadas por fecha
     */
    public static ArrayList<Reserva> getReservasXfecha(ArrayList<Reserva> reservas){
        //ordena los elementos de la lista
        Collections.sort(reservas, new Comparator<Reserva>(){//clase anónima que implementa la interfaz Comparator Reserva
            @Override
            public int compare(Reserva r1, Reserva r2){//método compare que toma dos objetos Reserva y los compara en función de su fechaReserva
                //return r2.getFechaReserva().compareTo(r1.getFechaReserva());
                return 0;
            }
        });
        return reservas;
    }
    
       /** Crea un fichero de texto con los datos de una reserva de un inmueble
     * @param reserva
     * @param noches
     * @throws java.io.IOException */
    public static void generaFactura(Reserva reserva, long noches) throws IOException {
        LocalDateTime hoy = LocalDateTime.now();
        Inmueble inm = reserva.getInmu();
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fn = hoy.format(formatoCorto);
        String rutaFicheroFactura = "./Facturas/Factura(" + fn.replace('/', '_') + ").txt";
        double importe = inm.getPrecioNoche() * noches;
        try {
            //Si no existe el directorio Facturas, lo creamos
            File dirFacturas = new File("/Users/eva/Desktop/javabnb_ser/copiasegReserva.dat");

          try (FileWriter fw = new FileWriter("copiasegReserva.dat");
               BufferedWriter bw = new BufferedWriter (fw);
               PrintWriter salida = new PrintWriter (bw)) {
                salida.println("-------------------------------- Factura Reserva --------------------------------");
                salida.println("\n");
                salida.println("-------------------------------- Fecha: " + fn + " -------------------------------");
                salida.println("\n");
                salida.println("Inmueble: "+inm.getTitulo());
                salida.println("Ciudad: "+inm.getCiudad());
                if (inm.getTipoPropiedad().equals("Apartamento")) {
                    salida.println("Tipo: Apartamento");
                } else {
                    salida.println("Tipo: Casa");
                }
                salida.println("\nNombre: " + inm.getTitulo());
                salida.println("Anfitrion: " + (inm.getCorreoAnfitrion()));
                salida.println("Particular: "+(reserva.getParti()));
                salida.println("\n");
                salida.println("Fecha de Entrada: "+(reserva.getFechaEntrada()));
                salida.println("Fecha de Salida: "+ reserva.getFechaSalida());
                salida.println("Precio por noche: " + inm.getPrecioNoche());
                salida.println("Noches: " + noches);
                salida.println("---------------------------------------------------------------------------------");
                salida.println("IMPORTE: " + importe);
                salida.println("\n");
                salida.println("-------------------------------------------------------------------------------");
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }//fin generaFactura

    /**
     *
     */
    public static void guardarDatosReservas() {
        try {
            
            //Si hay datos los guardamos...
            if (!reservas.isEmpty()) {
                
                /****** Serialización de los objetos ******/
                try {
                    ObjectOutputStream oosreser = new ObjectOutputStream(new FileOutputStream("/Users/eva/Desktop/javabnb_ser/copiasegReserva.dat"));
                    oosreser.writeObject(reservas);
                    oosreser.close();
                    
                    ObjectInputStream oisreser = new ObjectInputStream(new FileInputStream ("/Users/eva/Desktop/javabnb_ser/copiasegReservas.dat"));
                    ArrayList<Reserva> reservasRecuperadas= (ArrayList<Reserva>) oisreser.readObject();
                    oisreser.close();
                    
                    for (Reserva reser : reservasRecuperadas) {
                         System.out.println (reser);
                         reservas.add(reser);
                    }
                   
                   
                
                }catch (Exception e) {
                  System.out.println("Error: " + e.getMessage());
                }
                
                
            } else {
                System.out.println("Error: No hay datos...");
            }

        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    
    
    
    /** 
      * Carga el arraylist anfitrion desde el fichero copiasegAnfi.dat
      */
    public static void cargarDatosReservas() {
       try (FileInputStream istreamreser= new FileInputStream("/Users/eva/Desktop/javabnb_ser/copiasegReservas.dat");
            ObjectInputStream oisreser = new ObjectInputStream(istreamreser)) {
          
          //Lectura de los objetos de tipo persona
          reservas = (ArrayList) oisreser.readObject();
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
   }//fin cargarDatos



    private static void tarjetaCredito(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
     
     
     
   
    

     
     
     

    
   


   
}
