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
    public void crearVehiculo(Vehiculo vehiculo);
    public List<Vehiculo> buscarNumSerie(String numSerie);
}
