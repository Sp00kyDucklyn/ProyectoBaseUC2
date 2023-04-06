/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hoshi
 */
@Entity
@Table(name = "tramites")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public abstract class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private double costo;
    
//    @ManyToMany(mappedBy = "tramites")
//    private List<Persona>personas = new ArrayList<>();
   

    public Tramite() {
    }

    public Tramite(Integer id, double costo) {
        this.id = id;
        this.costo = costo;
      
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

//    public List<Persona> getPersonas() {
//        return personas;
//    }
//
//    public void setPersonas(List<Persona> personas) {
//        this.personas = personas;
//    }

   
    
}
