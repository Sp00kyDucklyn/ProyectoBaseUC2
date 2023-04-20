/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Persona;
import dominio.Placa;
import dominio.Vehiculo;
import interfaces.IPlacaDAO;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JComboBox;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;


/**
 *
 * @author hoshi
 */
public class PlacaDAO implements IPlacaDAO{

    private EntityManagerFactory entityManagerFactory = null;
    
    
    public PlacaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    @Override
    public void crearPlaca(Placa placa) {
      EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Persona> llamarRFC(String rfc) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Crear objeto CriteriaQuery para especificar el resultado de la consulta
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);

        // Especificar la tabla sobre la que se realizará la consulta
        Root<Persona> persona = cq.from(Persona.class);

        // Especificar la condición de la consulta (en este caso, que el RFC sea igual al ingresado por el usuario)
        cq.where(cb.equal(persona.get("rfc"), rfc));

        // Ejecutar la consulta y obtener el resultado
        List<Persona> personas = em.createQuery(cq).getResultList();

        return personas;
    }

    @Override
    public void crearCmbVehiculos(JComboBox<Vehiculo> cmbVehiculos) {
        
       
        EntityManager em = getEntityManager();
        Persona persona = new Persona();
        
        String jpql = "SELECT v FROM Vehiculo v";
        
        TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
        
         Iterator it = query.getResultList().iterator();
         Vehiculo v;
         try {
            while(it.hasNext()){
                v = (Vehiculo)it.next();
                cmbVehiculos.addItem(v);
            }
        } catch (Exception e) {
             System.out.println("No se pudo obtener la lista de vehiculos");
        }
    }

    @Override
    public String generarNumeroPlaca() {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
    StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("generar_numero_placa");
    storedProcedure.execute();
    String numeroSerie = (String) storedProcedure.getOutputParameterValue(1);
    em.getTransaction().commit();
        
        em.close();
    return numeroSerie;
}

    @Override
    public List<Placa> llamarListaPlacas(int nuSerie) {
        
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Crear objeto CriteriaQuery para especificar el resultado de la consulta
        CriteriaQuery<Placa> cq = cb.createQuery(Placa.class);

        // Especificar la tabla sobre la que se realizará la consulta
        Root<Placa> placa = cq.from(Placa.class);

        // Especificar la condición de la consulta (en este caso, que el RFC sea igual al ingresado por el usuario)
        cq.where(cb.equal(placa.get("numPlacaNu"), nuSerie));

        // Ejecutar la consulta y obtener el resultado
        List<Placa> placas = em.createQuery(cq).getResultList();

        return placas;
        
    }
    
    @Override
    public Placa placaActiva(int id_vehiculo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            // Verificar si existe una licencia vigente para el usuario
            TypedQuery<Placa> consultaPlaca = em.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id = :id AND p.estado = 'Vigentes'", Placa.class);
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
    @Override
    public Placa DesactivarPlaca(int id_vehiculo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Placa placa = this.placaActiva(id_vehiculo);

            Placa placaCambiar = em.find(Placa.class, placa.getId());

            placaCambiar.setEstado("Vencidas");
            em.merge(placaCambiar); //Agrega la nueva placa en la base de datos
            em.getTransaction().commit();
            return placa;
        } catch (Exception e) {

            return null;
        }
    }

    }
    
    
    
