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
    
    public void crearPlaca(Placa placa);
    
    public List<Persona> llamarRFC(String rfc);
    
    public void crearCmbVehiculos(JComboBox<Vehiculo> cmbVehiculos);
    
    
    public List<Placa> llamarListaPlacas(int placa);
    
    public Placa placaActiva(String numSerie);
    
    public Placa DesactivarPlaca(String numSerie);
}
