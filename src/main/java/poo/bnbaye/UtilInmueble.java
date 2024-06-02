/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

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
    
    public static boolean registrarInmueble(Inmueble objinmu) {
        if (!inmuebles.contains(objinmu)) {
            inmuebles.add(objinmu);
            return true;
        } else {
            return false;
        }

    }
    
    
}
