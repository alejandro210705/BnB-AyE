/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import poo.bnbaye.UtilCliente;
import poo.bnbaye.UtilInmueble;

/**
 *
 * @author eva
 */

public class Run {

    /**
     
@param args the command line arguments*/
  public static void main(String args[]) {
      try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Windows".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;}}} catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(AEntradaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(AEntradaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(AEntradaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(AEntradaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
      java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AEntradaApp().setVisible(true);
                UtilCliente.cargarDatosAnfi();
                UtilCliente.cargarDatosParti();
                UtilInmueble.cargarDatosInmu();
                        
            }
        });
    }

}

