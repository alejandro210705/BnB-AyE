/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
/**
 *
 * @author Alejandro
 */
public class Reserva implements Serializable {
    
    private Particular parti;
    private Inmueble inmu;
    private Anfitrion anfi;
    private LocalDateTime FechaEntrada;
    private LocalDateTime FechaSalida;
    private LocalDateTime Time;
    private TarjetaCredito tarjetacredito;
    private float Importe;
    private LocalDateTime FechaReserva;
    
    /**
     *
     * @param parti
     * @param inmu
     * @param FechaEntrada
     * @param FechaSalida
     * @param tarjetacredito
     */
    public Reserva(Particular parti, Inmueble inmu, LocalDateTime FechaEntrada, LocalDateTime FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.inmu = inmu;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
        
    }

    /**
     *
     * @param parti
     * @param anfi
     * @param FechaEntrada
     * @param FechaSalida
     * @param tarjetacredito
     */
    public Reserva(Particular parti, Anfitrion anfi, LocalDateTime FechaEntrada, LocalDateTime FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.anfi = anfi;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
    
    }

    /**
     *
     * @param parti
     * @param inmu
     * @param anfi
     * @param FechaEntrada
     * @param FechaSalida
     * @param tarjetacredito
     */
    public Reserva(Particular parti, Inmueble inmu, Anfitrion anfi, LocalDateTime FechaEntrada, LocalDateTime FechaSalida, TarjetaCredito tarjetacredito) {
        this.parti = parti;
        this.inmu = inmu;
        this.anfi = anfi;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.tarjetacredito = tarjetacredito;
       
    }

   

    
    
   

    /**
     * Get the value of Time
     *
     * @return the value of Time
     */
    public LocalDateTime getTime() {
        return Time;
    }

    /**
     * Set the value of Time
     *
     * @param Time new value of Time
     */
    public void setTime(LocalDateTime Time) {
        this.Time = Time;
    }
 
   /**
     * Get the value of Importe
     *
     * @return the value of Importe
     */
    public float getImporte() {
        return Importe;
    }

    /**
     * Set the value of Importe
     *
     * @param Importe new value of Importe
     */
    public void setImporte(float Importe) {
        this.Importe = Importe;
    } 

    /**
     *
     * @return
     */
    public LocalDateTime getFechaEntrada() {
        return FechaEntrada;
    }

    /**
     *
     * @param FechaEntrada
     */
    public void setFechaEntrada(LocalDateTime FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFechaSalida() {
        return FechaSalida;
    }

    /**
     *
     * @param FechaSalida
     */
    public void setFechaSalida(LocalDateTime FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    /**
     *
     * @return
     */
    public Particular getParti() {
        return parti;
    }

    /**
     *
     * @param parti
     */
    public void setParti(Particular parti) {
        this.parti = parti;
    }

    /**
     *
     * @return
     */
    public Inmueble getInmu() {
        return inmu;
    }

    /**
     *
     * @param inmu
     */
    public void setInmu(Inmueble inmu) {
        this.inmu = inmu;
    }

    /**
     *
     * @return
     */
    public Anfitrion getAnfi() {
        return anfi;
    }

    /**
     *
     * @param anfi
     */
    public void setAnfi(Anfitrion anfi) {
        this.anfi = anfi;
    }

    /**
     *
     * @return
     */
    public TarjetaCredito getTarjetacredito() {
        return tarjetacredito;
    }

    /**
     *
     * @param tarjetacredito
     */
    public void setTarjetacredito(TarjetaCredito tarjetacredito) {
        this.tarjetacredito = tarjetacredito;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Reserva{" + "parti=" + parti + ", inmu=" + inmu + ", anfi=" + anfi + ", FechaEntrada=" + FechaEntrada + ", FechaSalida=" + FechaSalida + ", tarjetacredito=" + tarjetacredito + ", importe=" + Importe + '}';
    }

    Object getFechaReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     *
     * @param r
     * @return
     */
    public int compareTo(Reserva r) {
        return this.FechaReserva.compareTo((ChronoLocalDateTime<?>) r.getFechaReserva());
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if ((this.FechaReserva == null) ? (other.FechaReserva != null) : !this.FechaReserva.equals(other.FechaReserva)) {
            return false;
        }
        return true;
    }
    
    
    
     
   
    
    
    
}
