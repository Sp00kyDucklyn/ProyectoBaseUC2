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
        PersonaDAO personaDAO = new PersonaDAO();
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");
        persona.setApellidoP("Perez");
        persona.setApellidoM("Gomez");
        persona.setFechaNa(new Date());
        persona.setTelefono(1234567890);
        persona.setTramites(new ArrayList<Tramite>(0));
        persona.setVehiculos(new ArrayList<Vehiculo>(0));
        
        personaDAO.crearPersona(persona);
        
        System.out.println("Persona creada exitosamente");
    }
        
    
    
}
