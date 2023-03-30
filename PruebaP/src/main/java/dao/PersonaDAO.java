/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Persona;
import dominio.Tramite;
import dominio.Vehiculo;
import interfaces.IPersonaDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hoshi
 */
public class PersonaDAO implements IPersonaDAO{
    
    private EntityManagerFactory entityManagerFactory = null;
    

    public PersonaDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    

    @Override
    public void crearPersona(Persona persona) {
       EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    } finally {
        em.close();
    }
    }

    @Override
    public List<Tramite> listaTramite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> listaVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        

    
}
