/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Licencia;
import interfaces.ILicenciaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hoshi
 */
public class LicenciaDAO implements ILicenciaDAO {

    private EntityManagerFactory entityManagerFactory = null;

    public LicenciaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

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

}
