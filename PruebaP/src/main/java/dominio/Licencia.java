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
 * Clase que se representa la licencia en la base de datos
 *
 * @author hoshi
 */
@Entity
@Table(name = "licencias")
@DiscriminatorValue(value = "licencia")
@PrimaryKeyJoinColumn(name = "id_tramite")
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

    /**
     * Metodo por omisión
     */
    public Licencia() {
    }

    /**
     * Metodo constructor que recibe todos los atributos de la licenciam, menos
     * el id
     *
     * @param vigencia
     * @param fechaVencimiento
     * @param discapacitado
     * @param costo
     * @param fechaExpedicion
     * @param estado
     * @param persona
     */
    public Licencia(String vigencia, Date fechaVencimiento, String discapacitado, String costo, Date fechaExpedicion, String estado, Persona persona) {
        super(costo, fechaVencimiento, fechaExpedicion, estado, persona);
        this.vigencia = vigencia;
        this.discapacitado = discapacitado;
    }

    /**
     * Metodo constructor que recibe todos los atributos de la licencia
     *
     * @param vigencia
     * @param discapacitado
     * @param id
     * @param costo
     * @param fechaExpedicion
     * @param fechaVencimiento
     * @param estado
     * @param persona
     */
    public Licencia(String vigencia, String discapacitado, Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado, Persona persona) {
        super(id, costo, fechaExpedicion, fechaVencimiento, estado, persona);
        this.vigencia = vigencia;
        this.discapacitado = discapacitado;
    }

    /**
     * Metodo que obtiene la vigencia de la licencia
     *
     * @return vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * Metodo que establece la vigencia de la licencia
     *
     * @param vigencia
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Metodo que obtiene si la licencia es para persona discapacitada
     * @return 
     */
    public String getDiscapacitado() {
        return discapacitado;
    }
/**
 * Metodo que establece si la licencia es para persona discapacitada
 * @param discapacitado 
 */
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
