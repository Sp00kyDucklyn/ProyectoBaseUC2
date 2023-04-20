/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un tramite en la base de datos
 * @author hoshi
 */
@Entity
@Table(name = "tramites")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    /**
     * Id
     */
    private Integer id;
    
    @Basic
    /**
     * Costo
     */
    private String costo;
    /**
     * Fecha de expedicion
     */
    private Date fechaExpedicion;
    /**
     * fecha de vencimiento
     */
    private Date fechaVencimiento;
    /**
     * estado
     */
    private String estado;
    
//    @OneToMany(mappedBy= "tramite", cascade=(CascadeType.REMOVE))
//    private List<TramitePersona> TramitePersona;
    
    @ManyToOne()
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;
    
//    @ManyToOne()
//    @JoinColumn(name = "idPersona", nullable = false)
//    private Vehiculo vehiculo;
    
//    @ManyToMany(mappedBy = "tramites")
//    private List<Persona>personas = new ArrayList<>();
   
/**
 * Constructor por omision
 */
    public Tramite() {
    }
/**
 * Metodo constructor que recibe todos los atributos del tramite, excepto el id
 * @param costo costo del tramite
 * @param fechaVencimiento fecha de vencimiento del tramite
 * @param fechaExpedicion fecha de expedicion del tramite
 * @param estado estado del tramite
 * @param persona persona que realiza el tramite
 */
    public Tramite(String costo, Date fechaVencimiento,Date fechaExpedicion, String estado, Persona persona) {
        this.costo = costo;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
    }
/**
 * 
 * @param  id id del tramite
 * @param costo costo del tramite
 * @param fechaExpedicion fecha de expedicion del tramite
 * @param fechaVencimiento fecha de vencimiento del tramite
 * @param estado estado del tramite
 */
    public Tramite(Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado) {
        this.id = id;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }
    
    
/**
 * Metodo constructor que recibe el costo, la fecha de expedicion y la persona que realiza el tramite
 * @param costo costo del tramite
 * @param fechaExpedicion fecha de expedicion del tramite
 * @param persona persona que realiza el tramite
 */
    public Tramite(String costo, Date fechaExpedicion, Persona persona) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }
/**
 * Metodo constructor que recibe todos los atributos del tramite
 * @param id id del tramite
 * @param costo costo del tramite
 * @param fechaExpedicion fecha de expedicion del tramite
 * @param fechaVencimiento fecha de vencimiento del tramite
 * @param estado estado del tramite
 * @param persona persona que realiza el tramite
 */
    public Tramite(Integer id, String costo, Date fechaExpedicion, Date fechaVencimiento, String estado, Persona persona) {
        this.id = id;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.persona = persona;
    }

/**
 * Metodo que obtiene el id del tramite 
 * @param id id del tramite
 */
    public Tramite(Integer id) {
        this.id = id;
    }
/**
 * Metodo que obtiene el id del tramite
 * @return id del tramite
 */
    public Integer getId() {
        return id;
    }
/**
 * Metodo que establece el id del tramite
 * @param id id del tramite
 */
    public void setId(Integer id) {
        this.id = id;
    }


//    public List<Persona> getPersonas() {
//        return personas;
//    }
//
//    public void setPersonas(List<Persona> personas) {
//        this.personas = personas;
//    }

   
/**
 * Metodo que obtiene la persona que realiza el tramite
 * @return persona que realiza el tramite
 */
    public Persona getPersona() {
        return persona;
    }
/**
 * Metodo que establece la persona que realiza el tramite
 * @param persona que realiza el tramite
 */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
/**
 * Metodo que obtiene el costo del tramite
 * @return Costo del tramite
 */
    public String getCosto() {
        return costo;
    }
/**
 * Metodo que establece el costo del tramite
 * @param costo costo del tramite
 */
    public void setCosto(String costo) {
        this.costo = costo;
    }
/**
 * Metodo que obtiene la fecha de expedicion del tramite
 * @return fecha de expedicion
 */
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }
/**
 * Metodo que establece la fecha de expedicion del tramite
 * @param fechaExpedicion fecha de expedicion del tramite
 */
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
/**
 * Metodo que obtiene el estado del tramite
 * @return estado del tramite
 */
    public String getEstado() {
        return estado;
    }
/**
 * Metodo que establece el estado
 * @param estado estado del tramite
 */
    public void setEstado(String estado) {
        this.estado = estado;
    }
/**
 * Metodo que obtiene la fecha de vencimiento del tramite
 * @return fecha de vencimiento
 */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
/**
 * Metodo que establece la fecha de vencimiento del tramite
 * @param fechaVencimiento fecha de vencimiento del tramite
 */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

  

   
    
}
