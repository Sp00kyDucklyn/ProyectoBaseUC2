/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Licencia;
import dominio.Persona;
import dominio.Placa;
import dominio.Tramite;
import interfaces.ITramiteDAO;
import java.util.ArrayList;
import java.util.Date;
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
public class TramiteDAO implements ITramiteDAO{
    
     private EntityManagerFactory entityManagerFactory = null;

    public TramiteDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


    public List<Tramite> buscarTramites(String rfc, String nombre, Date anioNacimiento) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (rfc != null && !rfc.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("rfc"), rfc));
        }
        
        if (nombre != null && !nombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"));
        }
        
        if (anioNacimiento != null) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.function("year", Integer.class, root.get("fechaNacimiento")),
                    criteriaBuilder.function("year", Integer.class, criteriaBuilder.literal(anioNacimiento))));
        }
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    @Override
    public List<Licencia> buscarLicencias(String rfc) {
        EntityManager em = getEntityManager();
        
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteriaQuery = criteriaBuilder.createQuery(Licencia.class);
        Root<Licencia> root = criteriaQuery.from(Licencia.class);
        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.equal(root.get("rfc"), rfc));

        TypedQuery<Licencia> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Placa> buscarPlacas(String rfc) {
        EntityManager em = getEntityManager();
        
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Placa> criteriaQuery = criteriaBuilder.createQuery(Placa.class);
        Root<Placa> root = criteriaQuery.from(Placa.class);
        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.equal(root.get("rfc"), rfc));

        TypedQuery<Placa> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Tramite> buscarRfc(String rfc) {
         EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (rfc != null && !rfc.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("rfc"), rfc));
        }
        
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    @Override
    public List<Tramite> buscarNombre(String nombre) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        
        if (nombre != null && !nombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"));
        }
        
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    @Override
    public List<Tramite> buscarFechaNacimiento(Date anioNacimiento) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
       
        if (anioNacimiento != null) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.function("year", Integer.class, root.get("fechaNacimiento")),
                    criteriaBuilder.function("year", Integer.class, criteriaBuilder.literal(anioNacimiento))));
        }
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    


   
    
}
