/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author hoshi
 */
@Entity
public class TramitePersona implements Serializable {

//    @ManyToMany
//    @JoinTable(name = "persona_tramites", 
//            joinColumns = @JoinColumn(name="id_persona", nullable = false, unique= true,
//            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_persona) references personas(id_persona)")),
//            inverseJoinColumns = @JoinColumn( name="id_tramite", nullable = false, unique = true, 
//            foreignKey= @ForeignKey(foreignKeyDefinition = "foreign key(id_tramite) references tramites(id_tramite)")))
//    private List<Tramite> tramites = new ArrayList();
//    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "idTramite", nullable = false)
    private Tramite tramite;

    @ManyToOne()
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public TramitePersona() {
    }

    public TramitePersona(Integer id, Tramite tramite, Persona persona) {
        this.id = id;
        this.tramite = tramite;
        this.persona = persona;
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
        if (!(object instanceof TramitePersona)) {
            return false;
        }
        TramitePersona other = (TramitePersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "TramitePersona{" + "id=" + id + ", tramite=" + tramite + ", persona=" + persona + '}';
    }
    
}
