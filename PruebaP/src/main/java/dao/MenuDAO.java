/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IMenuDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author hoshi
 */
public class MenuDAO implements IMenuDAO{

    @Override
    public void llamarProcedimiento() {
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("conexionPU");
       EntityManager em = emFactory.createEntityManager();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("agregar_personas");
       
       //Insertamos los parametros
       //Apellido paterno
       storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       //Apellido materno
       storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       //Fecha nacimiento
       storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
       //Nombre
       storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       //Telefono
       storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       
        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       String[][] personas = {
            {"Valenzuela", "Tarazon", "2003-05-10", "Oscar", "345667890"},
           //Marca error
            {"Garcia", "Lopez", "1990-02-14", "Maria", "5551234567"},
            {"Gonzalez", "Perez", "1985-10-22", "Pedro", "4447654321"},
            {"Martinez", "Sanchez", "1977-06-05", "Luis", "7778901234"},
            {"Hernandez", "Rivera", "1999-12-30", "Ana", "2225556789"},
            {"Diaz", "Vazquez", "1983-09-17", "Juan", "3339994567"},
            {"Romero", "Castillo", "1975-01-01", "Elena", "7778881234"},
            {"Ramirez", "Gutierrez", "2005-08-08", "Miguel", "7778884567"},
            {"Torres", "Lopez", "1994-04-20", "Sofia", "6667891234"},
            {"Guzman", "Santos", "1992-11-12", "Carlos", "4446667890"},
            {"Castro", "Rojas", "1979-07-26", "Laura", "3337773456"},
            {"Reyes", "Fernandez", "2001-03-18", "David", "5554445678"},
            {"Mendoza", "Pineda", "1988-12-05", "Jose", "3335556789"},
            {"Ramos", "Torres", "1972-02-29", "Carmen", "7776662345"},
            {"Sosa", "Lopez", "2008-11-17", "Diego", "2224446789"},
            {"Orozco", "Castillo", "1981-05-15", "Fernanda", "4447772345"},
            {"Chavez", "Mendez", "1996-09-02", "Gabriel", "5558883456"},
            {"Medina", "Santos", "1970-07-07", "Adriana", "7774445678"},
            {"Fuentes", "Vega", "2000-04-25", "Andres", "2227773456"},
            {"Benitez", "Hernandez", "1998-01-13", "Jazmin", "4448881234"}};
       
        for (int i = 0; i < personas.length; i++) {
            
            storedProcedure.setParameter(1, personas[i][0]);
            storedProcedure.setParameter(2, personas[i][1]);

            String fechaString = personas[i][2]; // fecha en formato "yyyy-MM-dd"
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            try {
                fecha = format.parse(fechaString);
                storedProcedure.setParameter(3, fecha);
            } catch (ParseException ex) {
                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion");
            }
        
            storedProcedure.setParameter(4, personas[i][3]);
            storedProcedure.setParameter(5, personas[i][4]);
       
            // Ejecutamos el procedimiento almacenado
            storedProcedure.execute();
        }
       

        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
        emFactory.close();
    }
    
}
