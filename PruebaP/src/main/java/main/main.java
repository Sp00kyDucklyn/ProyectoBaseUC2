/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dao.PersonaDAO;
import dao.VehiculoDAO;
import dominio.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pantallas.MenuPrincipal;

/**
 *
 * @author hoshi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
        
//       PersonaDAO dao = new PersonaDAO(); //instanciamos la clase DAO
//        PersonaDAO personaDAO = new PersonaDAO();
//        Persona persona = new Persona();
//        persona.setId(1);
//        persona.setNombre("Juan");
//        persona.setApellidoP("Perez");
//        persona.setApellidoM("Gomez");
//        persona.setFechaNa(new Date());
//        persona.setTelefono(1234567890);
//        persona.setTramites(new ArrayList<Tramite>(0));
//        persona.setVehiculos(new ArrayList<Vehiculo>(0));
//        
//        personaDAO.crearPersona(persona);
//        
//
//        System.out.println("Persona creada exitosamente");
//
////        
////        //agregamos los objetos a las listas
////        tramites.add(tramite1);
////        vehiculos.add(vehiculo1);
////        
////        //llamamos al método crearPersona de la clase DAO
////        dao.crearPersona(1, "Juan", "Perez", "García", new Date(), 1234567890, tramites, vehiculos);
//
//      
//        VehiculoDAO vDao = new VehiculoDAO();
//        Vehiculo vehiculo = new Vehiculo();
//        vehiculo.setId(1);
//        vehiculo.setNumPlacas("111-AAA");
//        vehiculo.setMarca("Jeep");
//        vehiculo.setLinea("Patriot");
//        vehiculo.setColor("Blanco");
//        vehiculo.setAnio(new Date(2015));
//        vehiculo.setPersona(persona);
//        vDao.crearVehiculo(vehiculo);
//        
//        System.out.println("Vehiculo creado exitosamente");
//        EntityManagerFactory enti = Persistence.createEntityManagerFactory("conexionPU");
//        //Entimanager
//        EntityManager entity = enti.createEntityManager();
//        //Transacion
//
//        entity.getTransaction().begin();
////        //Crea persona
////          Encriptacion a = new Encriptacion();
////          String nombre = a.encriptar("Herman");
////          String ap1 = a.encriptar("Trista");
////          String ap2 = a.encriptar("Rosales");
//        Persona p = new Persona("1234adsggh","Oscar","Valenzuela","Tarazon",new Date(2003-05-10),"12345");
//        
////        Automovil auto2 = new Automovil("3333", "carovolador", "Veneno", "gris", "aaa",p);
//        
////        p.agregarAuto(auto2);
//        Licencia lice  = new Licencia(3,new Date(2026-05-10),"no",200,new Date(),"activo",p);
//        p.agregaTramite(lice);
//
//
//
//
//        // guarda
//        entity.persist(p);
//////        entity.getTransaction().commit();
//////        entity.getTransaction().begin();
//////        //Crea persona
////////        Persona p2 = entity.find(Persona.class, 1);
//////        Placas placa = new Placas("estaessuplaca", "ACTIVA", auto, 100, p);
////////        Automovil autoencontrado=entity.find(Automovil.class,auto);
////////        autoencontrado.agregaPlaca(placa);
//////        entity.persist(placa);
//////        entity.merge(autoencontrado);
////
////
////        // guarda
//        entity.getTransaction().commit();
//        entity.close();
//        enti.close();
    }
        
    
    
}
