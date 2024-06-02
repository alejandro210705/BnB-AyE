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
import java.util.Comparator;
/**
 *
 * @author Alejandro
 */
public class UtilInmueble {
    
    private static  ArrayList<Inmueble> inmuebles = new ArrayList<>();
    private static  Inmueble objinmu;
    
    /** Establece el ArrayList de inmuebles
    * @param i */
    public static void setInmuebles(ArrayList<Inmueble> i) {
        inmuebles = i;
    }
    
    /** Da de alta un inmueble
     * @param objinmu
     * @return  boolean */
    public static boolean registrarInmueble(Inmueble objinmu) {
        if (!consultaInmueblesPorTitulo(objinmu.getTitulo())|| !consultaInmueblesPorCiudad(objinmu.getCiudad())) {
            inmuebles.add(objinmu);
            return true;
        } else {
            return false;
        }

    }
    
    /** Da de baja un inmueble
     * @param objinmu
     * @return boolean */
    public static boolean bajaInmueble(Inmueble objinmu) {
        if (consultaInmueblesPorTitulo(objinmu.getTitulo())|| consultaInmueblesPorCiudad(objinmu.getCiudad())) {
            inmuebles.remove(objinmu);
            return true;
        } else {
            return false;
        }
    }
    
    
    
    /** Consulta los datos de un inmueble por el Titulo
     * @param titulo
     * @return objinmu */
    public static boolean consultaInmueblesPorTitulo(String titulo) {
        //Comparador para ordenar los inmuebles por su titulo
        Comparator TituloInmuComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble i1 = (Inmueble) o1;
                Inmueble i2 = (Inmueble) o2;
                return i1.getTitulo().compareTo(i2.getTitulo());
            }
        };
        //Ordenamos el array
        Collections.sort(inmuebles, TituloInmuComp);
        //creamos un inmueble con el nombre a buscar
        Inmueble i = new Inmueble();
        i.setTitulo(titulo);
        int pos = Collections.binarySearch(inmuebles, i, TituloInmuComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /** Consulta los datos de un inmueble por la ciudad
     * @param ciudad
     * @return objinmu */
    public static boolean consultaInmueblesPorCiudad(String ciudad) {
        //Comparador para ordenar los inmuebles por ciudad
        Comparator CiudadInmuComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble i1 = (Inmueble) o1;
                Inmueble i2 = (Inmueble) o2;
                return i1.getCiudad().compareTo(i2.getCiudad());
            }
        };
        //Ordenamos el array
        Collections.sort(inmuebles, CiudadInmuComp);
        //creamos un inmueble con el nombre a buscar
        Inmueble i = new Inmueble();
        i.setCiudad(ciudad);
        int pos = Collections.binarySearch(inmuebles, i, CiudadInmuComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /** Crea un fichero de texto con los datos de un inmueble
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
     * guardar el arrayList inmueble en copiasegInmu.dat
     */
    public static void guardarDatosInmu() {
        try {
            
            //Si hay datos los guardamos...
            if (!inmuebles.isEmpty()) {
                
                /****** Serialización de los objetos ******/
                try {
                    ObjectOutputStream oosInmu = new ObjectOutputStream(new FileOutputStream("/Users/eva/Desktop/javabnb_ser/copiasegInmu.dat"));
                    oosInmu.writeObject(inmuebles);
                    oosInmu.close();
                    
                   
                    ObjectInputStream oisInmu = new ObjectInputStream(new FileInputStream ("/Users/eva/Desktop/javabnb_ser/copiasegInmu.dat"));
                    ArrayList<Inmueble> inmueblesRecuperados = (ArrayList<Inmueble>) oisInmu.readObject();
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
      * Carga el arraylist inmueble desde el fichero copiasegInmu.dat
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
