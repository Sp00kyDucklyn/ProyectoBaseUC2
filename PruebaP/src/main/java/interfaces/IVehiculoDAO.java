/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Vehiculo;
import java.util.List;

/**
 *
 * @author hoshi
 */
public interface IVehiculoDAO {
   /**
    * Metodo que crea el vehiculo
    * @param vehiculo vehiculo 
    */ 
    public void crearVehiculo(Vehiculo vehiculo);
    /**
     * Metodo que busca el numero de serie de un vehiculo
     * @param numSerie numSerie
     * @return numero de serie del vehiculo
     */
    public List<Vehiculo> buscarNumSerie(String numSerie);
}
