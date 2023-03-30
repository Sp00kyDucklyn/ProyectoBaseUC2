/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Persona;
import interfaces.IPersonaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hoshi
 */
public class PersonaDAO implements IPersonaDAO{

    @Override
    public void crearPersona(Persona persona) {
        EntityManagerFactory emFactrory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager em = emFactrory.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT SUM(SIZE(p.producto)) FROM Pedido p";
        Query query = em.createQuery(jpql);
        long productoResultado = (long) query.getSingleResult();
        System.out.println("El número total de productos vendidos es: " + productoResultado);
        System.out.println("---------------------------");
        em.getTransaction().commit();
        em.close();
    }
    
}
