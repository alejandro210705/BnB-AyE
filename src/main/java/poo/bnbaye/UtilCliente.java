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
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *clase para almacenar, guardar, ordenar, buscar, etc los clientes registrados en nuestra app
 * @author Alejandro
 */
public class UtilCliente implements Serializable {
    
    //primero comenzamos con los metodos de los particulares 
    public static ArrayList<Particular> particulares = new ArrayList<>();
    public static Particular objparti;
    
    
     /** Establece el ArrayList de particulares
    * @param p */
    public static void setParticulares(ArrayList<Particular> p) {
        particulares = p;
    }
    
    
    /** Da de alta un cliente particular
     * @param objparti
     * @return  boolean */
    public static boolean altaParticular(Particular objparti) {
        if (!particulares.contains(objparti)) {
            particulares.add(objparti);
            return true;
        } else {
            return false;
        }

    }
    
    /**@return Devuelve el ArrayList de particulares */
    public static ArrayList<Particular> getParticulares() {
        //Comparador para ordenar a los particulares por su correo
        Comparator CorreoPartiComp = new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                Particular p1 = (Particular) o1;
                Particular p2 = (Particular) o2;
                return p1.getCorreo().compareTo(p2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(particulares, CorreoPartiComp);
        return particulares;
    }
    
     /** Devuelve un particular por la posición dentro del ArrayList
     * @param indice
     * @return objper */
    public static Particular consultaParticular(int indice) {
        objparti = particulares.get(indice);
        return objparti;
    }
    
    /** Modifica los datos de un particular
     * @param parti
     * @param dni
     * @param nombre
     * @param tlf
     * @param correo
     * @param clave
     * @param nomT
     * @param numT
     * @param fcT
     * @param vip
     * @return boolean */
    public static boolean modificaParticular(Particular parti, String dni, String nombre, long tlf, String correo, String clave, String nomT, String numT, LocalDate fcT, Boolean vip) {
        if (parti == null || !particulares.contains(parti)) {
            return false;
        }
        else {
        
         if(!parti.getDni().equals(dni)){
                parti.setDni(dni);
                return true;
            }
            if(!parti.getNombre().equals(nombre)){
                parti.setNombre(nombre);
                return true;
            }
            if (parti.getTlf() != tlf) {
                parti.setTlf(tlf);
                return true;
            }
            if(!parti.getCorreo().equals(correo)){
                parti.setCorreo(correo);
                return true;
            }
            if(!parti.getClave().equals(clave)){
                parti.setClave(clave);
                return true;
            }
            if(!parti.getNomT().equals(nomT)){
                parti.setNomT(nomT);
                return true;
            }
            if(!parti.getNumT().equals(numT)){
                parti.setNumT(numT);
                return true;
            }
            if(!parti.getFcT().equals(fcT)){
                parti.setFcT(fcT);
                return true;
            }
            if(!parti.getVip().equals(vip)){
                parti.setVip(vip);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    /** Consulta los datos de un particular por su correo
     * @param correo
     * @return objparti */
    public static Particular consultaParticularPorCorreo(String correo) {
        //Comparador para ordenar los particulares por su correo
        Comparator CorreoPartiComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Particular p1 = (Particular) o1;
                Particular p2 = (Particular) o2;
                return p1.getCorreo().compareTo(p2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(particulares, CorreoPartiComp);
        //creamos una persona con el nombre a buscar
        Particular p = new Particular();
        p.setCorreo(correo);
        int pos = Collections.binarySearch(particulares, p, CorreoPartiComp);
        if (pos >= 0) {
            objparti = particulares.get(pos);
        } else {
            objparti = null;
        }

        return objparti;
    }
    
    /** Consulta los datos de una persona por su correo y clave
     * @param clave
     * @param correo
     * @return objparti */
    public static Particular consultaParticularPorCorreoYClave(String correo, String clave) {
        //Comparador para ordenar las personas por su dni
        Comparator CorreoPartiComp = new Comparator() {

            
            @Override
            public int compare(Object o1, Object o2) {
                Particular p1 = (Particular) o1;
                Particular p2 = (Particular) o2;
                return p1.getCorreo().compareTo(p2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(particulares, CorreoPartiComp);
        //creamos una persona con el nombre a buscar
        Particular p = new Particular();
        p.setCorreo(correo);
        int pos = Collections.binarySearch(particulares, p, CorreoPartiComp);
        if (pos >= 0) {
            objparti = particulares.get(pos);
            if (!objparti.getClave().equals(clave)){
                objparti = null;
            }
        } else {
            objparti = null;
        }

        return objparti;
    }
    
    /** Crea un fichero de texto con los datos de un cliente particular 
     * @param parti
     * @throws java.io.IOException */
    public static void generaFicha(Particular parti) throws IOException {
        //la siguiente linea de código envuelve el FileWriter en un BufferedWriter para mejoarar la eficiencia de la escritura
        // y a su vez envuelve el BufferedWriter en un PrintWriter para proporcionar metodos de escritura más convenientes
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(parti.getCorreo() + ".txt"))); 
        //con la siguiente línea formateamos la fecha de registro a la aplicación de los anfitriones
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
    

        salida.println("-------------------------------- Ficha Cliente --------------------------------");
        salida.println("\n");
        salida.println("DNI: " + parti.getDni());
        salida.println("\n");
        salida.println("Nombre: " + parti.getNombre());
        salida.println("\n");
        salida.println("Teléfono: " + parti.getTlf());
        salida.println("\n");
        salida.println("Correo: " + parti.getCorreo());
        salida.println("\n");
        salida.println("Clave: " + parti.getClave());
        salida.println("\n");
        salida.println("Nombre titular: " + parti.getNomT());
        salida.println("\n");
        salida.println("Numero: " + parti.getNumT());
        salida.println("\n");
        salida.println("Fecha caducidad: " + parti.getFcT());
        salida.println("\n");
        salida.println("VIP: " + parti.getVip());
        salida.println("\n");
        
        salida.println("\n");
        salida.println("-------------------------------------------------------------------------------");
        salida.close();
    }

    /**
     * guardar el arrayList particular en copiasegParti.dat
     */
    public static void guardarDatosParti() {
        try {
            
            //Si hay datos los guardamos...
            if (!particulares.isEmpty()) {
                
                /****** Serialización de los objetos ******/
                try (FileOutputStream ostreamParti = new FileOutputStream("copiasegParti.dat");
                ObjectOutputStream oosParti = new ObjectOutputStream(ostreamParti)){
                
                //guardamos el array de personas
                oosParti.writeObject(particulares);
                }
                
                
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    
    
     /** 
      * Carga el arraylist particular desde el fichero copiasegParti.dat
      */
    public static void cargarDatosParti() {
        try (FileInputStream istreamParti = new FileInputStream("copiasegParti.dat");
            ObjectInputStream oisParti = new ObjectInputStream(istreamParti)) {
            
            //Lectura de los objetos de tipo persona
            
            particulares = (ArrayList) oisParti.readObject();
            istreamParti.close();
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos
    
    

}
