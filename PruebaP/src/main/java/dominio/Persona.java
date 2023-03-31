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
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hoshi
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Persona")
    private Integer id;
    
    @Basic
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNa;
    private int telefono;
    
    @ManyToMany
    @JoinTable(name = "persona_tramites", 
            joinColumns = @JoinColumn(name="id_persona", nullable = false, unique= true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_persona) references personas(id_persona)")),
            inverseJoinColumns = @JoinColumn( name="id_tramite", nullable = false, unique = true, 
            foreignKey= @ForeignKey(foreignKeyDefinition = "foreign key(id_tramite) references tramites(id_tramite)")))
    private List<Tramite> tramites = new ArrayList();
    
    @OneToMany(mappedBy="Persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    public Persona() {
    }

//    public Persona(Integer id, String nombre, String apellidoP, String apellidoM, Date fechaNa, int telefono) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellidoP = apellidoP;
//        this.apellidoM = apellidoM;
//        this.fechaNa = fechaNa;
//        this.telefono = telefono;
//    }
    
    public Persona(Integer id, String nombre, String apellidoP, String apellidoM, Date fechaNa, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNa = fechaNa;
        this.telefono = telefono;
        this.tramites = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Date getFechaNa() {
        return fechaNa;
    }

    public void setFechaNa(Date fechaNa) {
        this.fechaNa = fechaNa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
    
}
