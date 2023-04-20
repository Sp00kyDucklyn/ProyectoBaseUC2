/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author hoshi
 */
/**
 * Clase que representa una placa en la base de datos
 * 
 */
@Entity
@Table(name = "placas")
@DiscriminatorValue(value = "placa")
@PrimaryKeyJoinColumn(name="id_tramite")
public class Placa extends Tramite implements Serializable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_placa")
//    private Integer id;
    /**
     * Numero de placss
     */
    @Basic
    private String numPlacaNu;
    //private double costo;
    /**
     * Vehiculo
     */
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
/**
 * Constructor por omision
 */
    public Placa() {
    }
/**
 * Metodo constructor que recibe todos los atributos de la placa
 * @param numPlacaNu numero de placas del vehiculo
 * @param vehiculos vehiculo al que pertenece la placa
 * @param id id de la placa
 * @param costo costo de la placa
 * @param fechaExpedicion fecha de expedicion de la placa
 * @param fechaVencimiento fecha de vencimiento de la placa
 * @param estado estado de la placa
 * @param persona persona a la que le pertenece la placa
 */
    public Placa(String numPlacaNu, Vehiculo vehiculos, Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado, Persona persona) {
        super(id, costo, fechaExpedicion, fechaVencimiento, estado, persona);
        this.numPlacaNu = numPlacaNu;
        this.vehiculo = vehiculos;
    }
/**
 * Metodo constructor que recibe todos los atributos de la placa, excepto la persona
 * @param numPlacaNu numero de placa
 * @param id id de la placa
 * @param costo costo de la placa
 * @param fechaExpedicion fecha de expedicion de la placa
 * @param fechaVencimiento fecha de vencimiento de la placa
 * @param estado estado de la placa
 */
    public Placa(String numPlacaNu, Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado) {
        super(id, costo, fechaExpedicion, fechaVencimiento, estado);
        this.numPlacaNu = numPlacaNu;
    }
    
    
    
   /**
    * Metodo que obtiene el numero de placa
    * @return numero de placa
    */ 
    public String getNumPlacaNu() {
        return numPlacaNu;
    }
/**
 * Metodo que establece el numero de la placa
 * @param numPlacaNu numero de placa
 */
    public void setNumPlacaNu(String numPlacaNu) {
        this.numPlacaNu = numPlacaNu;
    }

    
//    public double getCosto() {
//        return costo;
//    }
//
//    public void setCosto(double costo) {
//        this.costo = costo;
//    }
/**
 * Metodo que obtiene el vehiculo al que pertenecen las placas
 * @return Vehiculo 
 */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
/**
 * Metodo que establece el vehiculo al que pertenecen las placas
 * @param vehiculo vehiculo al que pertenece la placa
 */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
/**
 * Metodo que establece el vehiculo al que pertenecen las placas
 * @return numero de la placa con el formato toString
 */
    @Override
    public String toString() {
        return "Placa actual: " + numPlacaNu;
    }
 
    
}
