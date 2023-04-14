/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name="licencias")
@DiscriminatorValue(value ="licencia")
@PrimaryKeyJoinColumn(name="id_tramite")
public class Licencia extends Tramite implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_licencia")
//    private Integer id;
    
    @Basic
    //Lo pone el usuario
    private int vigencia;
    //Lo calcula el sistema
    private Date fechaVencimiento;
    //Lo pongo yo en registro persona
    private String discapacitado;
    
    

    public Licencia() {
    }

    public Licencia(int vigencia, Date fechaVencimiento, String discapacitado, int costo, Date fechaExpedicion, String estado, Persona persona) {
        super(costo, fechaExpedicion, estado, persona);
        this.vigencia = vigencia;
        this.fechaVencimiento = fechaVencimiento;
        this.discapacitado = discapacitado;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public String getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(String discapacitado) {
        this.discapacitado = discapacitado;
    }


//    public double getCosto() {
//        return costo;
//    }
//
//    public void setCosto(double costo) {
//        this.costo = costo;
//    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
