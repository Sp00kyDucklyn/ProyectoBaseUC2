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
/**
 *
 * Clase que representa una persona en la base de datos
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    /**
     * Identificador único de la persona en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id;
    /**
     * RFC de la persona
     */
    @Basic
    private String rfc;
    /**
     * Nombre de la persona
     */
    private String nombre;
    /**
     * Apellido paterno de la persona
     */
    private String apellidoP;
    /**
     * Apellido materno de la persona
     */
    private String apellidoM;
    /**
     * Fecha de nacimiento de la persona
     */
    private Date fechaNa;
    /**
     * Numero de telefono de la persona
     */
    private String telefono;
    /**
     * Lista de vehiculos que pertenecen a la persona
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;
    /**
     * Lista de tramites realizados por la persona
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Tramite> tramites;

    /**
     * Constructor por omisión
     */
    public Persona() {
    }

    /**
     * Metodo constructor que recibe todos los atributos de la persona.
     *
     * @param rfc RFC de la persona.
     * @param nombre Nombre de la persona.
     * @param apellidoP Apellido paterno de la persona.
     * @param apellidoM Apellido materno de la persona.
     * @param fechaNa Fecha de nacimiento de la persona.
     * @param telefono Número de teléfono de la persona.
     */
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

    /**
     *
     * Método que agrega un vehículo a la lista de vehículos de la persona.
     *
     * @param vehiculo Vehículo a agregar.
     */
    public void agregaVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     *
     * Método que agrega un trámite a la lista de trámites de la persona.
     *
     * @param tramite Trámite a agregar.
     */
    public void agregaTramite(Tramite tramite) {
        tramites.add(tramite);
    }

    /**
     *
     * Método que obtiene el id de la persona.
     *
     * @return Id de la persona.
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * Método que establece el id de la persona.
     *
     * @param id Nuevo id de la persona.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     *
     * Método que establece el nombre de la persona.
     *
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método que obtiene el apellido paterno de la persona.
     *
     * @return apellidoP de la persona.
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     *
     * Método que establece el apellido paterno de la persona.
     *
     * @param apellidoP Apellido Paterno de la persona.
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     *
     * Metodo que retorna el apellido materno de una persona.
     *
     * @return Apellido Materno de la persona.
     */
    public String getApellidoM() {
        return apellidoM;
    }
/**
     *
     * Metodo que establece el apellido materno de una persona.
     *
     * @param apellidoM Apellido Materno de la persona.
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

     /**
     *
     * Metodo que retorna la fecha de nacimiento de una persona.
     *
     * @return Fecha de Nacimiento de la persona.
     */
    public Date getFechaNa() {
        return fechaNa;
    }

     /**
     *
     * Metodo que establece la fecha de nacimiento de una persona.
     *
     * @param fechaNa Fecha de Nacimiento de la persona.
     */
    public void setFechaNa(Date fechaNa) {
        this.fechaNa = fechaNa;
    }
/**
 * Metodo que obtiene el telefono de la persona
 * @return telefono de la persona
 */
    public String getTelefono() {
        return telefono;
    }
/**
 * Metodo que establece el telefono de la persona
 * @param telefono 
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
/**
 * Metodo que obtiene la lista de vehiculos del cliente
 * @return vehiculo de la persona
 */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
/**
 * Metodo que establece un vehiculo en la lista de vehiculos del cliente
 * @param vehiculos
 */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
/**
 * Metodo que obtiene el RFC de la persona
 * @return rfc de la persona
 */
    public String getRfc() {
        return rfc;
    }
/**
 * Metodo que establece el rfc de la persona
 * @param rfc 
 */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
/**
 * metodo que obtiene los tramites en la lista de tramites de la persona
 * @return tramites
 */
    public List<Tramite> getTramites() {
        return tramites;
    }
/**
 * metodo que establece los tramites en la lista de tramites de la persona
 * @param tramites 
 */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

}
