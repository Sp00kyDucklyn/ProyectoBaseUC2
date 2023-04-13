/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Persona;
import java.util.List;

/**
 *
 * @author hoshi
 */
public interface ITramiteDAO {
    
    public List<Persona>  llamarNombres();
    
    public List<Persona>  llamarRFC();
    
    public List<Persona>  llamarFechaNacimiento();
    
    //public void llamarTipo();
    
}
