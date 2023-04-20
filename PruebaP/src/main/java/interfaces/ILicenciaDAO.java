/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Licencia;
import dominio.Persona;
import dominio.Tramite;
import java.util.List;

/**
 *
 * @author hoshi
 */
public interface ILicenciaDAO {
    
    public void crearLicencia(Licencia licencia);
    
    public List<Persona> llamarRFC(String rfc);
   
}
