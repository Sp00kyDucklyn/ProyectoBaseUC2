/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Persona;
import dominio.Placa;
import dominio.Vehiculo;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author hoshi
 */
public interface IPlacaDAO {
    /**
     * Metodo que crea la placa del vehiculo
     * @param placa placa
     */
    public void crearPlaca(Placa placa);
    /**
     * Metodo que llama el rfc de una lista de personas
     * @param rfc rfc
     * @return lista de personas
     */
    public List<Persona> llamarRFC(String rfc);
    /**
     * Metodo que se encarga de crear un combo box de vehiculos
     * @param cmbVehiculos cmbVehiculos
     */
    public void crearCmbVehiculos(JComboBox<Vehiculo> cmbVehiculos);
    
    /**
     * Metodo que se encarga de llamar la lista de placas
     * @param placa placa
     * @return Lista de placas
     */
    public List<Placa> llamarListaPlacas(int placa);
    /**
     * Metodo que se encarga de activar las placas
     * @param numSerie numSerie
     * @return placa activada
     */
    public Placa placaActiva(String numSerie);
    /**
     * Metodo que desactiva las placas
     * @param numSerie numSerie
     * @return placa desactivada
     */
    public Placa DesactivarPlaca(String numSerie);
}
