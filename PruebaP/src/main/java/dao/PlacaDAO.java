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
 * Clase que representa las placas en el patron DAO
 * @author hoshi
 */
public class PlacaDAO implements IPlacaDAO{

    //Atributo de la clase
    private EntityManagerFactory entityManagerFactory = null;
    
    /**
     * Metodo constructor que crea la conexion con la BD
     */
    public PlacaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");

    }

     /**
     * Constructor que inicializa al entity manager
     * @return Regresa entity manager
     */
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    /**
     * Metodo que crea la placa
     * @param placa parametro placa
     */
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
/**
 * Metodo que se encarga de llamar a la persona dueña de la placa por el rfc
 * @param rfc parametro rfc
 * @return persona
 */
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
/**
 * Metodo que crea el combo box de vehiculos
 * @param cmbVehiculos parametro comboBox
 */
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

/**
 * Metodo que se encarga de llamar la lista de placas
 * @param nuSerie parametro numero de serie
 * @return lista de placas
 */
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
    /**
     * Metodo que se encarga de activar la placa del vehiculo
     * @param numSerie parametro numero de Serie
     * @return placa activa
     */
    @Override
    public Placa placaActiva(String numSerie) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            // Verificar si existe una licencia vigente para el usuario
            TypedQuery<Placa> consultaPlaca = em.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.numSerie = :id AND p.estado = 'Vigentes'", Placa.class);
            consultaPlaca.setParameter("numSerie", numSerie);
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
     * @param numSerie parametro numero de Serie
     * @return placa que se encuentre activa
     */
    @Override
    public Placa DesactivarPlaca(String numSerie) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Placa placa = this.placaActiva(numSerie);

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
    
    
    
