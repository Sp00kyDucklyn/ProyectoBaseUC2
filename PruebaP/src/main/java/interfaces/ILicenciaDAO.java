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
    /**
     * Metodo que crea la licencia
     * @param licencia licencia 
     */
    public void crearLicencia(Licencia licencia);
    /**
     *Metodo que llama el rfc del cliente
     * @param rfc rfc del cliente
     * @return rfc del cliente
     */
    public List<Persona> llamarRFC(String rfc);
   
}
