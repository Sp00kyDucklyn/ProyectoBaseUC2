/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Encriptar.Encriptar;
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
import javax.persistence.EntityTransaction;
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

    public List<Tramite> desencriptarPersonaTramite(List<Tramite> lista) {
        Encriptar encriptacion = new Encriptar();
        List<Persona> personasDesencriptadas = new ArrayList<>(); // crea una lista auxiliar de personas
        List<Tramite> lista_tramitePersona = new ArrayList<>(); // crea una lista de trámites

        for (Tramite tramite : lista) {
            Persona persona = tramite.getPersona(); // obtiene la persona del trámite

            if (!personasDesencriptadas.contains(persona)) { // si la persona no está en la lista auxiliar
                personasDesencriptadas.add(persona); // agrega la persona a la lista auxiliar
                persona.setNombre(encriptacion.desencriptar(persona.getNombre()));
                persona.setApellidoP(encriptacion.desencriptar(persona.getApellidoP()));
                persona.setApellidoM(encriptacion.desencriptar(persona.getApellidoM()));
            }
            lista_tramitePersona.add(tramite); // agrega el trámite a la lista
        }

        return lista_tramitePersona;
    }

    @Override
    public void crearTramite(Tramite tramite) {
            EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(tramite);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void estadoTramite(int id_tramite) {
        EntityManager em = getEntityManager();
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin(); 
        
        Persona persona = new Persona();
                
        Tramite tramite = em.find(Tramite.class,id_tramite);
        if(tramite.getFechaVencimiento().after(tramite.getFechaVencimiento())){
            tramite.setEstado("desactivo"); //actualizar el nombre
            
        }else if(tramite.getFechaVencimiento().before(tramite.getFechaVencimiento())){
            tramite.setEstado("activo");
        }
        

        em.merge(tramite); //actualizar la entidad en la base de datos

        transaccion.commit(); //confirmar la transacción
    }

    @Override
    public List<Tramite> listaTramiteL(Date periodoI, Date periodoF, String estado, String costo) {
      EntityManager em = getEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(root);
        
        TypedQuery<Tramite> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();
        
    }

}
