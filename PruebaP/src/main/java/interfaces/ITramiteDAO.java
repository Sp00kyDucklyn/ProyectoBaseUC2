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
    /**
     * Metodo que lista los tramites
     * @param periodoI periodo inicial
     * @param periodoF periodo final
     * @param licencia licencia
     * @param placa placa
     * @return lista de tramites
     */
    public List<Tramite> listaTramite(Date periodoI, Date periodoF,boolean licencia, boolean placa);
    /**
     * Metodo que lista los tramites de forma individual
     * @param periodoI periodo incial
     * @param periodoF periodo final
     * @param estado estado
     * @param costo costo
     * @return Lista de tramites
     */
    public List<Tramite> listaTramiteL(Date periodoI, Date periodoF,String estado, String costo);
    /**
     * Metodo que descencripta la lista de tramites
     * @param lista lista de tramites
     * @return persona desencriptada
     */
    public List<Tramite> desencriptarPersonaTramite(List<Tramite> lista);
    /**
     * Metodo que maneja el estado del tramite
     * @param id_tramite id del tramite
     */
    public void estadoTramite(int id_tramite);
    /**
     * Metodo que crea el tramite
     * @param tramite tramite
     */
    public void crearTramite(Tramite tramite);
    //public void llamarTipo();
    
}
