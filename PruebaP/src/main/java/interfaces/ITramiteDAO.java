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
    
    public List<Tramite> listaTramite(Date periodoI, Date periodoF,boolean licencia, boolean placa);
    public List<Tramite> listaTramiteL(Date periodoI, Date periodoF,String estado, String costo);
    public List<Tramite> desencriptarPersonaTramite(List<Tramite> lista);
    public void estadoTramite(int id_tramite);
    public void crearTramite(Tramite tramite);
    //public void llamarTipo();
    
}
