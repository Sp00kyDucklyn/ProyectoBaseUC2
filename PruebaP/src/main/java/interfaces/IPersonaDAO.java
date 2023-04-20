/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Persona;
import dominio.Tramite;
import dominio.Vehiculo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hoshi
 */
public interface IPersonaDAO {
    /**
     * Metodo que crea una persona
     * @param persona persona
     */
  public void crearPersona(Persona persona);
  /**
   * Metodo que se encarga de buscar el rfc de la persona
   * @param rfc rfc 
   * @return rfc de la persona
   */
    public List<Persona> buscarRfc(String rfc);
/**
 * Metodo que se encarga de buscar el nombre de la persona
 * @param nombre nombre
 * @return nombre de la persona
 */
    public List<Persona> buscarNombre(String nombre);
/**
 * Metodo que se encarga de buscar la fecha de nacimiento de la persona
 * @param anioNacimiento año de nacimiento
 * @return año de nacimiento
 */
    public List<Persona> buscarFechaNacimiento(Date anioNacimiento);
/**
 * Metodo que se encarga de listar las personas
 * @return Lista de personas
 */
    public List<Persona> listaPersonas();
/**
 * Metodo que se encarga de listar el tramite de la persona
 * @return lista de tramites
 */
    public List<Tramite> listaTramite();
    /**
     * Metodo que se encarga de listar a las personas con datos desencriptados
     * @param personas personas
     * @return persona desencriptada
     */
    public List<Persona> desencriptarPersonaLista(List<Persona> personas);
          
}
