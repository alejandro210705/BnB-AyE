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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * clase para almacenar, guardar, ordenar, buscar, etc los clientes registrados en nuestra app
 * @author Alejandro
 */
public class UtilCliente implements Serializable {
    
    //primero comenzamos con los metodos de los particulares 
    private static ArrayList<Particular> particulares = new ArrayList<>();
    private static Particular objparti;
    
    
    /** Establece el ArrayList de particulares
    * @param p */
    public static void setParticulares(ArrayList<Particular> p) {
        particulares = p;
    }
    
    
    /** Da de alta un cliente particular
     * @param objparti
     * @return  boolean */
    public static boolean altaParticulares(Particular objparti) {
        if (!consultaParticularesPorCorreo(objparti.getCorreo())|| !consultaParticularesPorDni(objparti.getDni())) {
            particulares.add(objparti);
            return true;
        } else {
            return false;
        }

    }
    
    /**@return Devuelve el ArrayList de particulares */
    public static ArrayList<Particular> getParticulares() {
        return particulares;
    }
    
     /** Devuelve un particular por la posición dentro del ArrayList
     * @param indice
     * @return objper */
    public static Particular consultaParticulares(int indice) {
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
    public static boolean modificaParticulares(Particular parti, String dni, String nombre, String tlf, String correo, String clave, String nomT, String numT, LocalDateTime fcT, Boolean vip) {
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
            if (!parti.getTlf().equals(tlf)) {
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
    public static boolean consultaParticularesPorCorreo(String correo) {
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
            return true;
        } else {
            return false;
        }
    }
    
    /** Consulta los datos de un anfitrion por su correo
     * @param dni
     * @return objanfi */
    public static boolean consultaParticularesPorDni(String dni) {
        //Comparador para ordenar los particulares por su correo
        Comparator DniPartiComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Particular p1 = (Particular) o1;
                Particular p2 = (Particular) o2;
                return p1.getDni().compareTo(p2.getDni());
            }
        };
        //Ordenamos el array
        Collections.sort(particulares, DniPartiComp);
        //creamos una persona con el nombre a buscar
        Particular p = new Particular();
        p.setDni(dni);
        int pos = Collections.binarySearch(particulares, p, DniPartiComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
   
        
    }
    
    /** Consulta los datos de una persona por su correo y clave
     * @param clave
     * @param correo
     * @return objparti */
    public static Particular consultaParticularesPorCorreoYClave(String correo, String clave) {
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
            if (objparti.getClave() !=clave){
                objparti = null;
            }
        } else {
            objparti = null;
        }

        return objparti;
    }
    
    
    
    public static Particular sesionIniciadaParticular (String correo, String clave) {
        particulares = UtilCliente.getParticulares();
        for (int i = 0; i < particulares.size(); i++) {
            Particular objparti = UtilCliente.getParticulares().get(i);
            if (objparti.getCorreo().equals(correo)&& objparti.getClave().equals(clave)){
                return objparti;
            }
        }
        return null;         
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
                try {
                    ObjectOutputStream oosParti = new ObjectOutputStream(new FileOutputStream("/Users/eva/Desktop/javabnb_ser/copiasegParti.dat"));
                    oosParti.writeObject(particulares);
                    oosParti.close();
                    
                    ObjectInputStream oisParti = new ObjectInputStream(new FileInputStream ("/Users/eva/Desktop/javabnb_ser/copiasegParti.dat"));
                    ArrayList<Particular> particularesRecuperados= (ArrayList<Particular>) oisParti.readObject();
                    oisParti.close();
                    
                    for (Particular parti : particularesRecuperados) {
                        System.out.println (parti);
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
      * Carga el arraylist particular desde el fichero copiasegParti.dat
      */
    public static void cargarDatosParti() {
        try (FileInputStream istreamParti = new FileInputStream("copiasegParti.dat");
            ObjectInputStream oisParti = new ObjectInputStream(istreamParti)) {
            
            //Lectura de los objetos de tipo persona
            
            particulares = (ArrayList) oisParti.readObject();
            
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos
    
    
    
//////////////////////////////////////////////////////////////////  
    
    
    //Segundo comenzamos con los metodos de los anfitriones
    private static ArrayList<Anfitrion> anfitriones = new ArrayList<>();
    private static Anfitrion objanfi;
    
    /** Establece el ArrayList de anfitriones
    * @param a */
    public static void setAnfitriones(ArrayList<Anfitrion> a) {
        anfitriones = a;
    }
    
    
    /** Da de alta a un anfitrion
     * @param objanfi
     * @return  boolean */
    public static boolean altaAnfitriones(Anfitrion objanfi) {
        if (!consultaAnfitrionesPorCorreo(objanfi.getCorreo())|| !consultaAnfitrionesPorDni(objanfi.getDni())) {
            anfitriones.add(objanfi);
            return true;
        } else {
            return false;
        }

    }

    

        
    /**@return Devuelve el ArrayList de anfitriones */
    public static ArrayList<Anfitrion> getAnfitriones() {
        return anfitriones;
    }
    
     /** Devuelve un anfitrion por la posición dentro del ArrayList
     * @param indice
     * @return objanfi */
    public static Anfitrion consultaAnfitriones(int indice) {
        objanfi = anfitriones.get(indice);
        return objanfi;
    }

    
    /** Modifica los datos de un particular
     * @param anfi
     * @param dni
     * @param nombre
     * @param tlf
     * @param correo
     * @param clave
     * @param fr
     * @param calificacion
     * @return boolean */
    public static boolean modificaAnfitriones(Anfitrion anfi, String dni, String nombre, String tlf, String correo, String clave, LocalDateTime fr, int calificacion) {
        if (anfi == null || !anfitriones.contains(anfi)) {
            return false;
        }
        else {
        
         if(!anfi.getDni().equals(dni)){
                anfi.setDni(dni);
                return true;
            }
            if(!anfi.getNombre().equals(nombre)){
                anfi.setNombre(nombre);
                return true;
            }
            if (!anfi.getTlf().equals(tlf)) {
                anfi.setTlf(tlf);
                return true;
            }
            if(!anfi.getCorreo().equals(correo)){
                anfi.setCorreo(correo);
                return true;
            }
            if(!anfi.getClave().equals(clave)){
               anfi.setClave(clave);
                return true;
            }
            if(!anfi.getFr().equals(fr)){
               anfi.setFr(fr);
                return true;
            }
            if(!(anfi.getCalificacion()==(calificacion))){
                anfi.setCalificacion(calificacion);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    
    /** Consulta los datos de un anfitrion por su correo
     * @param correo
     * @return objanfi */
    public static boolean consultaAnfitrionesPorCorreo(String correo) {
        //Comparador para ordenar los particulares por su correo
        Comparator CorreoAnfiComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Anfitrion a1 = (Anfitrion) o1;
                Anfitrion a2 = (Anfitrion) o2;
                return a1.getCorreo().compareTo(a2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(anfitriones, CorreoAnfiComp);
        //creamos una persona con el nombre a buscar
        Anfitrion a = new Anfitrion();
        a.setCorreo(correo);
        int pos = Collections.binarySearch(anfitriones, a, CorreoAnfiComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }

    }
    
    
    /** Consulta los datos de un anfitrion por su correo
     * @param dni
     * @return objanfi */
    public static boolean consultaAnfitrionesPorDni(String dni) {
        //Comparador para ordenar los particulares por su correo
        Comparator DniAnfiComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Anfitrion a1 = (Anfitrion) o1;
                Anfitrion a2 = (Anfitrion) o2;
                return a1.getDni().compareTo(a2.getDni());
            }
        };
        //Ordenamos el array
        Collections.sort(anfitriones, DniAnfiComp);
        //creamos una persona con el nombre a buscar
        Anfitrion a = new Anfitrion();
        a.setDni(dni);
        int pos = Collections.binarySearch(anfitriones, a, DniAnfiComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
   
        
    }
   
     /** Consulta los datos de un anfitrion por su correo y clave
     * @param clave
     * @param correo
     * @return objanfi */
    public static Anfitrion consultaAnfitrionesPorCorreoYClave(String correo, String clave) {
        //Comparador para ordenar las personas por su dni
        Comparator CorreoAnfiComp = new Comparator() {

            
            @Override
            public int compare(Object o1, Object o2) {
                Anfitrion a1 = (Anfitrion) o1;
                Anfitrion a2 = (Anfitrion) o2;
                return a1.getCorreo().compareTo(a2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(anfitriones, CorreoAnfiComp);
        //creamos una persona con el nombre a buscar
        Anfitrion a = new Anfitrion();
        a.setCorreo(correo);
        int pos = Collections.binarySearch(anfitriones, a, CorreoAnfiComp);
        if (pos >= 0) {
            objanfi = anfitriones.get(pos);
            if (objanfi.getClave() != clave){
                objanfi = null;
            }
        } else {
            objanfi = null;
        }

        return objanfi;
    }
    
    public static Anfitrion sesionIniciadaAnfitrion (String correo, String clave) {
        anfitriones = UtilCliente.getAnfitriones();
        for (int i = 0; i < anfitriones.size(); i++) {
            Anfitrion objanfi = UtilCliente.getAnfitriones().get(i);
            if (objanfi.getCorreo().equals(correo)&& objanfi.getClave().equals(clave)) {
                return objanfi;
            }
        }
        return null;         
    }
    
    
    /** Crea un fichero de texto con los datos de un anfitrion
     * @param anfi
     * @throws java.io.IOException */
    public static void generaFicha(Anfitrion anfi) throws IOException {
        //la siguiente linea de código envuelve el FileWriter en un BufferedWriter para mejoarar la eficiencia de la escritura
        // y a su vez envuelve el BufferedWriter en un PrintWriter para proporcionar metodos de escritura más convenientes
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(anfi.getCorreo() + ".txt"))); 
        //con la siguiente línea formateamos la fecha de registro a la aplicación de los anfitriones
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
    

        salida.println("-------------------------------- Ficha Cliente --------------------------------");
        salida.println("\n");
        salida.println("DNI: " + anfi.getDni());
        salida.println("\n");
        salida.println("Nombre: " + anfi.getNombre());
        salida.println("\n");
        salida.println("Teléfono: " + anfi.getTlf());
        salida.println("\n");
        salida.println("Correo: " + anfi.getCorreo());
        salida.println("\n");
        salida.println("Clave: " + anfi.getClave());
        salida.println("\n");
        salida.println("Fecha de registro: " + anfi.getFr());
        salida.println("\n");
        salida.println("Calificacion: " + anfi.getCalificacion());
        salida.println("\n");
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
            if (!particulares.isEmpty()) {
                
                /****** Serialización de los objetos ******/
                try {
                    ObjectOutputStream oosAnfi = new ObjectOutputStream(new FileOutputStream("/Users/eva/Desktop/javabnb_ser/copiasegAnfi.dat"));
                    oosAnfi.writeObject(anfitriones);
                    oosAnfi.close();
                    
                   
                    ObjectInputStream oisAnfi = new ObjectInputStream(new FileInputStream ("/Users/eva/Desktop/javabnb_ser/copiasegAnfi.dat"));
                    ArrayList<Anfitrion> anfitrionesRecuperados= (ArrayList<Anfitrion>) oisAnfi.readObject();
                    oisAnfi.close();
                    
                    for (Anfitrion anfi : anfitrionesRecuperados) {
                        System.out.println (anfi);
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
            FileInputStream istreamAnfi = new FileInputStream("copiasegAnfi.dat");
            ObjectInputStream oisAnfi= new ObjectInputStream(istreamAnfi);
            
            anfitriones = (ArrayList) oisAnfi.readObject();
            
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    

    
    
}
