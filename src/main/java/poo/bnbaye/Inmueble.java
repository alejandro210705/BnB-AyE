/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.bnbaye;

/**
 *
 * @author Alejandro
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;
/**
 *
 * @author Alejandro
 */
public class Inmueble implements Serializable{
    
    private String titulo;

    private String calle;
    private String numero;
    private String codigoPostal;
    private String ciudad;
    
    
    private String numHuespedes;
    private String numHabitaciones;
    private String numCamas;
    private String numBanos;

    private String tipoPropiedad;
    
    private double precioNoche;
    
    private double calificacion;
    
    private String servicios;
    
    private String correoAnfitrion;
    
    
    private transient BufferedImage foto; //para que el anfitrión pueda añadir una imagen de su inmueble 
    
    private static final String CASA = "Casa";
    private static final String APARTAMENTO = "Apartamento";

    public Inmueble(String titulo, String calle, String numero, String codigoPostal, String ciudad, String numHuespedes, String numHabitaciones, String numCamas, String numBanos, String tipoPropiedad, double precioNoche, double calificacion, String servicios, String correoAnfitrion, BufferedImage foto) {
        this.titulo = titulo;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.numHuespedes = numHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBanos = numBanos;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.calificacion = calificacion;
        this.servicios = servicios;
        this.correoAnfitrion = correoAnfitrion;
        this.foto = foto;
    }
    
    public Inmueble(){
        
    }

    public Inmueble(String titulo, String calle, String numero, String codigoPostal, String ciudad, String numHuespedes, String numHabitaciones, String numCamas, String numBanos, String tipoPropiedad, double precioNoche, String servicios, String correoAnfitrion, BufferedImage foto) {
        this.titulo = titulo;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.numHuespedes = numHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBanos = numBanos;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.servicios = servicios;
        this.correoAnfitrion = correoAnfitrion;
        this.foto = foto;
    }

    public Inmueble(String titulo, String calle, String numero, String codigoPostal, String ciudad, String numHuespedes, String numHabitaciones, String numCamas, String numBanos, String tipoPropiedad, double precioNoche, String servicios, String correoAnfitrion) {
        this.titulo = titulo;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.numHuespedes = numHuespedes;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.numBanos = numBanos;
        this.tipoPropiedad = tipoPropiedad;
        this.precioNoche = precioNoche;
        this.servicios = servicios;
        this.correoAnfitrion = correoAnfitrion;
    }
    
    
    
    
    /**
     *
     * @return
     */
    public BufferedImage getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     */
    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        // Copiado dese
        //<<<https://stackoverflow.com/questions/15058663/how-to-serialize-an-object-that-includes-bufferedimages
        out.defaultWriteObject();  //todo lo que no es transient lo guarda, y luego guardamos la foto por separado
        if (foto != null) //pasar sofi
        {
            ImageIO.write(foto, "png", out); // png is lossless
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Copiado dese
        // https://stackoverflow.com/questions/15058663/how-to-serialize-an-object-that-includes-bufferedimages
        in.defaultReadObject();
        foto = ImageIO.read(in);
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }
    
    /**
     *
     * @return
     */

    public boolean esCasa() {
        return tipoPropiedad.equalsIgnoreCase(CASA); // se usa para comparar dos cadenas de texto sin tener en cuenta mayusculas o minusculas 
    }

    /**
     *
     * @return
     */
    public boolean esApartamento() {
        return tipoPropiedad.equalsIgnoreCase(APARTAMENTO);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumHuespedes() {
        return numHuespedes;
    }

    public void setNumHuespedes(String numHuespedes) {
        this.numHuespedes = numHuespedes;
    }

    public String getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(String numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(String numCamas) {
        this.numCamas = numCamas;
    }

    public String getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(String numBanos) {
        this.numBanos = numBanos;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getCorreoAnfitrion() {
        return correoAnfitrion;
    }

    public void setCorreoAnfitrion(String correoAnfitrion) {
        this.correoAnfitrion = correoAnfitrion;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", numHuespedes=" + numHuespedes + ", numHabitaciones=" + numHabitaciones + ", numCamas=" + numCamas + ", numBanos=" + numBanos + ", tipoPropiedad=" + tipoPropiedad + ", precioNoche=" + precioNoche + ", calificacion=" + calificacion + ", servicios=" + servicios + ", correoAnfitrion=" + correoAnfitrion + ", foto=" + foto + '}';
    }
    
    
    
    
}
