/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Clase que representa el vehiculo en la base de datos
 * @author hoshi
 */
@Entity
public class Vehiculo implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String numSerie;
    private String marca;
    private String linea;
    private String color;
    private String anio;

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID_PERSONA", nullable = false)
    private Persona persona;
    
//    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private List<Tramite> tramites;

    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;
/**
 * Constructor por omisión
 */
    public Vehiculo() {
    }
/**
 * Metodo constructor que recibe todos los atributos del vehiculo
 * @param numSerie
 * @param marca
 * @param linea
 * @param color
 * @param anio
 * @param persona
 * @param placas 
 */
    public Vehiculo(String numSerie, String marca, String linea, String color, String anio, Persona persona, List<Placa> placas) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.anio = anio;
        this.persona = persona;
        this.placas = placas;
    }
/**
 * Metodo constructor que recibe todos los atributos, excepto la lista de placas
 * @param numSerie
 * @param marca
 * @param linea
 * @param color
 * @param anio
 * @param persona 
 */
    public Vehiculo(String numSerie, String marca, String linea, String color, String anio, Persona persona) {

        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.anio = anio;
        this.persona = persona;
    }
    
    
    /**
     * Metodo que agrega la placa
     * @param placa 
     */
     public void agregaPlaca(Placa placa){
        placas.add(placa);
    }
/**
 * Metodo que obtiene el id de la vehiculo
 * @return id del vehiculo
 */
    public Integer getId() {
        return id;
    }
/**
 * Metodo que establece el id del vehiculo
 * @param id 
 */
    public void setId(Integer id) {
        this.id = id;
    }

/**
 * Metodo que obtiene la marca
 * @return marca del vehiculo
 */

    public String getMarca() {
        return marca;
    }
/**
 * Metodo que establece la marca del vehiculo
 * @param marca 
 */
    public void setMarca(String marca) {
        this.marca = marca;
    }
/**
 * Metodo que obtiene la linea del vehiculo
 * @return linea del vehiculo
 */
    public String getLinea() {
        return linea;
    }
/**
 * Metodo que establece la linea del vehiculo
 * @param linea 
 */
    public void setLinea(String linea) {
        this.linea = linea;
    }
/**
 * Metodo que obtiene el color del vehiculo
 * @return color del vehiculo
 */
    public String getColor() {
        return color;
    }
/**
 * 
 * Metodo que establece el color del vehiculo
 * @param color 
 */
    public void setColor(String color) {
        this.color = color;
    }
/**
 * Metodo que obtiene el año del vehiculo
 * @return 
 */
    public String getAnio() {
        return anio;
    }
/**
 * Metodo que establece el año del vehiculo
 * @param anio 
 */
    public void setAnio(String anio) {
        this.anio = anio;
    }
/**
 * Metodo que obtiene la persona dueña del vehiculo
 * @return persona
 */
    public Persona getPersona() {
        return persona;
    }
/**
 * Metodo que establece la persona dueña del vehiculo
 * @param persona 
 */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
/**
 * Metodo que obtiene el numero de serie del vehoculo
 * @return numero de serie
 */
    public String getNumSerie() {
        return numSerie;
    }
/**
 * Metodo que establece el numero de serie del vehiculo
 * @param numSerie 
 */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
/**
 * Metodo que obtiene la lista de placas del vehiculo
 * @return placas 
 */
    public List<Placa> getPlacas() {
        return placas;
    }
/**
 * Metodo que establece las placas del vehiculo
 * @param placas 
 */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }
/**
 * Metodo que establece la cadena con los datos del vehiculo
 * @return Cadena con los datos del vehiculo
 */
    @Override
    public String toString() {
        return "numSerie: " + numSerie + ", marca: " + marca + ", linea: " + linea + ", color: " + color + ", anio:" + anio + '}';
    }


}
