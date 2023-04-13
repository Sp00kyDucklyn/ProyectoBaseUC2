/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Licencia;
import dominio.Persona;
import dominio.Placa;
import dominio.Tramite;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hoshi
 */
public interface ITramiteDAO {
    
    public List<Tramite> buscarRfc(String rfc);
    public List<Tramite> buscarNombre(String nombre);
    public List<Tramite> buscarFechaNacimiento(Date anioNacimiento);
    public List<Licencia> buscarLicencias(String rfc);
    public List<Placa> buscarPlacas(String rfc);
    
    //public void llamarTipo();
    
}
