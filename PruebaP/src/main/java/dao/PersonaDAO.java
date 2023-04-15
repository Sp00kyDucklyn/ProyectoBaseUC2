/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Encriptar.Encriptar;
import dominio.Persona;
import dominio.Tramite;
import dominio.Vehiculo;
import interfaces.IPersonaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
       
        Encriptar en= new Encriptar();
        String nombre=en.encriptar(persona.getNombre());
        String apellidoP= en.encriptar(persona.getApellidoP());
        String apellidoM= en.encriptar(persona.getApellidoM());
        persona.setNombre(nombre);
        persona.setApellidoP(apellidoP);
        persona.setApellidoM(apellidoM);
        
        try {

            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
        em.close();
    }
    }
    
    @Override
    public void datosFormulatio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tramite> listaTramite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> listaVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> buscarRfc(String rfc) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteriaQuery.from(Persona.class);
        criteriaQuery.select(root);
        
        
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (rfc != null && !rfc.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("rfc"), "%" + rfc + "%"));
        }
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    @Override
    public List<Persona> buscarNombre(String nombre) {
        EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteriaQuery.from(Persona.class);
        criteriaQuery.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        
        if (nombre != null && !nombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"));
        }
        
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);
        
        return typedQuery.getResultList();
    }

    @Override
    public List<Persona> buscarFechaNacimiento(Date anioNacimiento) {
         EntityManager em = getEntityManager();
       
       CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteriaQuery.from(Persona.class);
        criteriaQuery.select(root);
        
        
        List<Predicate> predicates = new ArrayList<>();
       
        if (anioNacimiento != null) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.function("year", Integer.class, root.get("fechaNa")),
                    criteriaBuilder.function("year", Integer.class, criteriaBuilder.literal(anioNacimiento))));
        }
        
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);
        
//        for(Persona persona : predicates){
//                desencriptarPersona(persona);
//            }
        
        return typedQuery.getResultList();
    }
    
    @Override
    public List<Persona> listaPersonas() {
        EntityManager em = getEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);

        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();

    }

    @Override
    public List<Persona> buscarRfcEstado(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void desencriptarPersona(Persona persona){
        Encriptar en= new Encriptar();
        String nombre=en.desencriptar(persona.getNombre());
        String apellidoP= en.desencriptar(persona.getApellidoP());
        String apellidoM= en.desencriptar(persona.getApellidoM());
        persona.setNombre(nombre);
        persona.setApellidoP(apellidoP);
        persona.setApellidoM(apellidoM);
    }
    
    @Override
    public List<Persona> desencriptarPersonaLista(List<Persona> personas) {
        Encriptar en = new Encriptar();
        
        for (Persona persona : personas) {
            String nombre = en.desencriptar(persona.getNombre());
            String apellidoP = en.desencriptar(persona.getApellidoP());
            String apellidoM = en.desencriptar(persona.getApellidoM());
            persona.setNombre(nombre);
            persona.setApellidoP(apellidoP);
            persona.setApellidoM(apellidoM);
        }
        return personas;
    }
}
