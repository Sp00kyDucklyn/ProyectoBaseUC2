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
@Table(name="persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id;
    
    @Basic
    private String rfc;
   
    private String nombre;
    
    private String apellidoP;
    
    private String apellidoM;
    
    private Date fechaNa;
   
    private String telefono;
    
//    @OneToMany(mappedBy = "persona", cascade = (CascadeType.REMOVE))
//    private List<TramitePersona> TramitePersona;
    
    @OneToMany(mappedBy="persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Tramite> tramites;

    public Persona() {
    }

    public Persona(String rfc, String nombre, String apellidoP, String apellidoM, Date fechaNa, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNa = fechaNa;
        this.telefono = telefono;
        this.tramites = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }
    
     public void agregaVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public void agregaTramite(Tramite tramite){
        tramites.add(tramite);
    }


//    public Persona(Integer id, String nombre, String apellidoP, String apellidoM, Date fechaNa, String telefono) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellidoP = apellidoP;
//        this.apellidoM = apellidoM;
//        this.fechaNa = fechaNa;
//        this.telefono = telefono;
//        this.vehiculos = new ArrayList<>();
//    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }
    
}
