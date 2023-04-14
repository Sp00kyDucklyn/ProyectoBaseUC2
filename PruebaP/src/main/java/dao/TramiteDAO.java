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
import javax.persistence.criteria.Join;
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


    public List<Tramite> buscarTramites(String rfc,String nombre, Date anioNacimiento) {
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


    public List<Tramite> listaTramite(Date periodoI, Date periodoF,boolean licencia, boolean placa) {
        EntityManager em = getEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();

        if (licencia && !placa){
             Predicate licenciaLista = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class),root.type());
             predicates.add(licenciaLista);
        }else if(!licencia && placa){
            Predicate placaLista = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class),root.type());
             predicates.add(placaLista);
        }else if(licencia && placa){
             Predicate licenciaLista = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class),root.type());
             Predicate placaLista = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class),root.type());
            predicates.add(criteriaBuilder.or(licenciaLista,placaLista));
        }
        
        if (periodoI != null && periodoF !=null){
             predicates.add(criteriaBuilder.between(root.get("fechaExpedicion"), periodoI, periodoF));
        }
        
        if(!predicates.isEmpty()){
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);
        
        List <Tramite> tramites = typedQuery.getResultList();
       
        return tramites;
        
    }


}
