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
@Entity
@Table(name = "placas")
@DiscriminatorValue(value = "placa")
@PrimaryKeyJoinColumn(name="id_tramite")
public class Placa extends Tramite implements Serializable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_placa")
//    private Integer id;
    
    @Basic
    private String numPlacaNu;
    //private double costo;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(String numPlacaNu, Vehiculo vehiculos, Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado, Persona persona) {
        super(id, costo, fechaExpedicion, fechaVencimiento, estado, persona);
        this.numPlacaNu = numPlacaNu;
        this.vehiculo = vehiculos;
    }

    public Placa(String numPlacaNu, Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado) {
        super(id, costo, fechaExpedicion, fechaVencimiento, estado);
        this.numPlacaNu = numPlacaNu;
    }
    
    
    
    
    public String getNumPlacaNu() {
        return numPlacaNu;
    }

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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Placa actual: " + numPlacaNu;
    }
 
    
}
