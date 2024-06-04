/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author Alejandro
 */
public class Reserva {
    
    private Particular parti;
    private Inmueble inmu;
    private Anfitrion anfi;
    private LocalDate FechaEntrada;
    private LocalDate FechaSalida;
    private TarjetaCredito tarjetacredito;
    

    public Reserva(Particular parti, Inmueble inmu, LocalDate FechaEntrada, LocalDate FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.inmu = inmu;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
        
    }

    public Reserva(Particular parti, Anfitrion anfi, LocalDate FechaEntrada, LocalDate FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.anfi = anfi;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
    
    }

    public Reserva(Particular parti, Inmueble inmu, Anfitrion anfi, LocalDate FechaEntrada, LocalDate FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.inmu = inmu;
        this.anfi = anfi;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
       
    }

   

    
    
    
    

 
    public LocalDate getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(LocalDate FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(LocalDate FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Particular getParti() {
        return parti;
    }

    public void setParti(Particular parti) {
        this.parti = parti;
    }

    public Inmueble getInmu() {
        return inmu;
    }

    public void setInmu(Inmueble inmu) {
        this.inmu = inmu;
    }

    public Anfitrion getAnfi() {
        return anfi;
    }

    public void setAnfi(Anfitrion anfi) {
        this.anfi = anfi;
    }

    public TarjetaCredito getTarjetacredito() {
        return tarjetacredito;
    }

    public void setTarjetacredito(TarjetaCredito tarjetacredito) {
        this.tarjetacredito = tarjetacredito;
    }

    @Override
    public String toString() {
        return "Reserva{" + "parti=" + parti + ", inmu=" + inmu + ", anfi=" + anfi + ", FechaEntrada=" + FechaEntrada + ", FechaSalida=" + FechaSalida + ", tarjetacredito=" + tarjetacredito + '}';
    }
    
    
     
   
    
    
    
}
