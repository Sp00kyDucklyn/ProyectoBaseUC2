/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Licencia;
import dominio.Persona;
import dominio.Tramite;
import interfaces.ILicenciaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que se representa las licencias en el patron DAO
 * @author hoshi
 */
public class LicenciaDAO implements ILicenciaDAO {

    private EntityManagerFactory entityManagerFactory = null;

    /**
     * Metodo constructor que crea la conexion con la BD
     */
    public LicenciaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");

    }

    /**
     * Método de la clase que regresa el entity manager
     * @return Regresa el entity manager
     */
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Metodo que crea la licencia
     * @param licencia //parametro licencia
     */
    @Override
    public void crearLicencia(Licencia licencia) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
 
/**
 * Metodo que llama la persona por rfc
 * @param rfc parametro rfc
 * @return regreso
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

    

}
