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
    
  public void crearPersona(Persona persona);
  
  public List<Tramite> listaTramite();
  public List<Vehiculo> listaVehiculo();
          
}
