/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dao.PersonaDAO;
import dominio.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hoshi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       PersonaDAO dao = new PersonaDAO(); //instanciamos la clase DAO
        List<Tramite> tramites = new ArrayList<>(); //creamos una lista de tramites
        List<Vehiculo> vehiculos = new ArrayList<>(); //creamos una lista de vehiculos
        
        //creamos algunos objetos Tramite y Vehiculo para agregar a la persona
        Tramite tramite1 = new Tramite();
        Vehiculo vehiculo1 = new Vehiculo();
        
        //agregamos los objetos a las listas
        tramites.add(tramite1);
        vehiculos.add(vehiculo1);
        
        //llamamos al método crearPersona de la clase DAO
        dao.crearPersona(1, "Juan", "Perez", "García", new Date(), 1234567890, tramites, vehiculos);
    }
        
    
    
}
