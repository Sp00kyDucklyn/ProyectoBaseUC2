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
 *
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
    private Integer id;
    
    @Basic
    private int costo;
    private Date fechaExpedicion;
    private Date fechaVencimiento;
    private String estado;
    
//    @OneToMany(mappedBy= "tramite", cascade=(CascadeType.REMOVE))
//    private List<TramitePersona> TramitePersona;
    
    @ManyToOne()
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;
    
//    @ManyToMany(mappedBy = "tramites")
//    private List<Persona>personas = new ArrayList<>();
   

    public Tramite() {
    }

    public Tramite(int costo, Date fechaVencimiento,Date fechaExpedicion, String estado, Persona persona) {
        this.costo = costo;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

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

   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

  

   
    
}
