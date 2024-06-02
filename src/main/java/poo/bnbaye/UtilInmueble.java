/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import poo.bnbaye.Anfitrion;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Alejandro
 */
public class UtilInmueble {
    
    private static  ArrayList<Inmueble> inmuebles = new ArrayList<>();
    private static  Inmueble objinmu;
    
    /** Establece el ArrayList de anfitriones
    * @param i */
    public static void setInmuebles(ArrayList<Inmueble> i) {
        inmuebles = i;
    }
    
    
    public static boolean registrarInmueble(Inmueble objinmu) {
        if (!inmuebles.contains(objinmu)) {
            inmuebles.add(objinmu);
            return true;
        } else {
            return false;
        }

    }
    
    /** Crea un fichero de texto con los datos de un anfitrion
     * @param inmu
     * @throws java.io.IOException */
    public static void generaFicha(Inmueble inmu) throws IOException {
        //la siguiente linea de código envuelve el FileWriter en un BufferedWriter para mejoarar la eficiencia de la escritura
        // y a su vez envuelve el BufferedWriter en un PrintWriter para proporcionar metodos de escritura más convenientes
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(inmu.getTitulo() + ".txt"))); 
        //con la siguiente línea formateamos la fecha de registro a la aplicación de los anfitriones
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
    

        salida.println("-------------------------------- Ficha Inmueble --------------------------------");
        salida.println("\n");
        salida.println("Titulo: " + inmu.getTitulo());
        salida.println("\n");
        salida.println("Calle: " + inmu.getCalle());
        salida.println("\n");
        salida.println("Número: " + inmu.getNumero());
        salida.println("\n");
        salida.println("Codigo Postal: " + inmu.getCodigoPostal());
        salida.println("\n");
        salida.println("Ciudad: " + inmu.getCiudad());
        salida.println("\n");
        salida.println("Numero de huespedes: " + inmu.getNumHuespedes());
        salida.println("\n");
        salida.println("Numero de habitaciones: " + inmu.getNumHabitaciones());
        salida.println("\n");
        salida.println("Numero de camas: " + inmu.getNumCamas());
        salida.println("\n");
        salida.println("Numero de baños: " + inmu.getNumBanos());
        salida.println("\n");
        salida.println("Tipo de propiedad: " + inmu.getTipoPropiedad());
        salida.println("\n");
        salida.println("Precio por noche: " + inmu.getPrecioNoche());
        salida.println("\n");
        salida.println("Servicios: " + inmu.getServicios());
        salida.println("\n");
        salida.println("-------------------------------------------------------------------------------");
        salida.close();
    }
    
    
    
    /**
     * guardar el arrayList anfitrion en copiasegAnfi.dat
     */
    public static void guardarDatosAnfi() {
        try {
            
            //Si hay datos los guardamos...
            if (!inmuebles.isEmpty()) {
                
                /****** Serialización de los objetos ******/
                try {
                    ObjectOutputStream oosInmu = new ObjectOutputStream(new FileOutputStream("/Users/eva/Desktop/javabnb_ser/copiasegInmu.dat"));
                    oosInmu.writeObject(inmuebles);
                    oosInmu.close();
                    
                   
                    ObjectInputStream oisInmu = new ObjectInputStream(new FileInputStream ("/Users/eva/Desktop/javabnb_ser/copiasegInmu.dat"));
                    ArrayList<Inmueble> inmueblesRecuperados= (ArrayList<Inmueble>) oisInmu.readObject();
                    oosInmu.close();
                    
                    for (Inmueble inmu : inmueblesRecuperados) {
                        System.out.println (inmu);
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
    public static void cargarDatosAnfi() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamInmu = new FileInputStream("copiasegInmu.dat");
            ObjectInputStream oisInmu= new ObjectInputStream(istreamInmu);
            
            inmuebles = (ArrayList) oisInmu.readObject();
            
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos
    
    
}
