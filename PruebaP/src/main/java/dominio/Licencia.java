/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hoshi
 */
@Entity
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Licencia")
    private Integer id;
    
    @Basic
    private int vigencia;
    private Date fechaEx;
    private String discapacitado;
    private Estado estado;
    private int numeroLic;

    public Licencia() {
    }

    public Licencia(Integer id, int vigencia, Date fechaEx, String discapacitado, Estado estado, int numeroLic) {
        this.id = id;
        this.vigencia = vigencia;
        this.fechaEx = fechaEx;
        this.discapacitado = discapacitado;
        this.estado = estado;
        this.numeroLic = numeroLic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Licencia[ id=" + id + " ]";
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public Date getFechaEx() {
        return fechaEx;
    }

    public void setFechaEx(Date fechaEx) {
        this.fechaEx = fechaEx;
    }

    public String getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(String discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNumeroLic() {
        return numeroLic;
    }

    public void setNumeroLic(int numeroLic) {
        this.numeroLic = numeroLic;
    }
    
}
