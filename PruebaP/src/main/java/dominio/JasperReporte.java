/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Clase que se encarga de los reportes generados
 * @author hoshi
 */
public class JasperReporte {
    
    private String tipoTramite;
    private String nombre;
    private String costo;
    private String periodo;

    /**
     * Metodo constructor por omisión
     */
    public JasperReporte() {
    }

    /**
     * Metodo constructor que recibe los atributos del reporte
     * @param tipoTramite
     * @param nombre
     * @param costo
     * @param periodo 
     */
    public JasperReporte(String tipoTramite, String nombre, String costo, String periodo) {
        this.tipoTramite = tipoTramite;
        this.nombre = nombre;
        this.costo = costo;
        this.periodo = periodo;
    }

    /**
     * Metodo que obtiene el periodo del tramite
     * @return periodo del tramite
     */
    public String getPeriodo() {
        return periodo;
    }
/**
 * Metodo que establece el periodo del tramite
 * @param periodo 
 */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
/**
 * Metodo que obtiene el tipo de tramite
 * @return tipo de tramite
 */
    public String getTipoTramite() {
        return tipoTramite;
    }
/**
 * Metodo que establece el tipo de tramite
 * @param tipoTramite 
 */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
/**
 * Metodo que obtiene el nombre de la persona que realiza el tramite
 * @return nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Metodo que establece el nombre de la persona que realiza el tramite
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Metodo que obtiene el costo del tramite
 * @return costo del tramite
 */
    public String getCosto() {
        return costo;
    }
/**
 * Metodo que establece el costo del tramite
 * @param costo 
 */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
}
