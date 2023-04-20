/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Persona;
import dominio.Placa;
import dominio.Vehiculo;
import interfaces.IVehiculoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase que gestiona los vehiculos con patron DAO
 * @author hoshi
 */
public class VehiculoDAO implements IVehiculoDAO{
    
    //Atributo de la clase que inicializa el entity manager en null
    private EntityManagerFactory entityManagerFactory = null;

      /**
     * Metodo que crea la conexion con la BD
     */
    public VehiculoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    
     /**
     * Constructor que inicializa al entity manager
     * @return Regresa
     */
    public EntityManager getEntityManager(){
       return entityManagerFactory.createEntityManager();
    }
    
    /**
     * Metodo que crea el vehiculo
     * @param vehiculo parametro vehiculo
     */
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
/**
 * Metodo que se encarga de buscar el vehiculo por numero de serie
 * @param numSerie parametro numero serie
 * @return 
 */
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
    
     
    public Placa placaActiva(int id_vehiculo) {
        EntityManager em = getEntityManager();
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin(); 
        try {
            em.getTransaction().begin();

            // Verificar si existe una licencia vigente para el usuario
            TypedQuery<Placa> consultaPlaca = em.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id = :id AND p.estado = 'activo'", Placa.class);
            consultaPlaca.setParameter("id", id_vehiculo);
            Placa PlacaActiva = consultaPlaca.getSingleResult();

            em.getTransaction().commit();

            return PlacaActiva;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que se encarga de desactivar placa del vehiculo
     *
     * @param id_vehiculo
     * @return placa que se encuentre activa
     */
    public Placa DesactivarPlaca(int id_vehiculo) {
        EntityManager em = getEntityManager();
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin(); 
        try {
            em.getTransaction().begin();
            Placa placa = this.placaActiva(id_vehiculo);

            Placa placaCambiar = em.find(Placa.class, placa.getId());

            placaCambiar.setEstado("desactivo");
            em.merge(placaCambiar); //Agrega la nueva placa en la base de datos
            em.getTransaction().commit();
            return placa;
        } catch (Exception e) {

            return null;
        }
    }
    
    
    
}
