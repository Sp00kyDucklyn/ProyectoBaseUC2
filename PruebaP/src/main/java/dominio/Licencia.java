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
    private String vigencia;
    //Lo calcula el sistema
    //Lo pongo yo en registro persona
    private String discapacitado;
    
    

    public Licencia() {
    }

    public Licencia(String vigencia, Date fechaVencimiento, String discapacitado, String costo, Date fechaExpedicion, String estado, Persona persona) {
        super(costo, fechaVencimiento ,fechaExpedicion, estado, persona);
        this.vigencia = vigencia;
        this.discapacitado = discapacitado;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
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
    
}
