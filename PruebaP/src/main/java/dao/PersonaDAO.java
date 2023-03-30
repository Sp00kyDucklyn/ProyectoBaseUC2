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
    public void crearPersona(Integer id, String nombre, String apellidoP, String apellidoM, Date fechaNa, int telefono, List<Tramite> tramites, List<Vehiculo> vehiculos) {
        EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
        Persona persona = new Persona(id, nombre, apellidoP, apellidoM, fechaNa, telefono);
        persona.setTramites(tramites);
        persona.setVehiculos(vehiculos);
        em.persist(persona);
        em.getTransaction().commit();
    } finally {
        em.close();
    }
        

    }
}
