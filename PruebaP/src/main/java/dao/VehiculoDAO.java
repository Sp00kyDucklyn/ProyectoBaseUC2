/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Vehiculo;
import interfaces.IVehiculoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hoshi
 */
public class VehiculoDAO implements IVehiculoDAO{
    private EntityManagerFactory entityManagerFactory = null;

    public VehiculoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ConexionPU");
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
    
    
    
}
