/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Persona;
import dominio.Vehiculo;
import interfaces.IVehiculoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author hoshi
 */
public class VehiculoDAO implements IVehiculoDAO{
    private EntityManagerFactory entityManagerFactory = null;

    public VehiculoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    public EntityManager getEntityManager(){
       return entityManagerFactory.createEntityManager();
    }
    
    @Override
    public void crearVehiculo(Vehiculo vehiculo) {
        EntityManager em = getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    @Override
    public List<Vehiculo> buscarNumSerie(String numSerie) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Vehiculo> criteriaQuery = criteriaBuilder.createQuery(Vehiculo.class);
        Root<Vehiculo> root = criteriaQuery.from(Vehiculo.class);
        criteriaQuery.select(root);
        
        
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (numSerie != null && !numSerie.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("numSerie"), "%" + numSerie + "%"));
        }
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Vehiculo> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }
    
    
    
    
    
}
