/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import encripta.Encriptar;
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
 * Metodo que administra el menu con patron DAO
 * @author hoshi
 */
public class MenuDAO implements IMenuDAO{
    
    private EntityManagerFactory entityManagerFactory = null;

    /**
     * Metodo constructor que crea la conexion con la BD
     */
    public MenuDAO() {
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
     * Metodo encargado de llamar un procedimiento 
     */
    public void llamarProcedimiento() {
       agregarPersonas();
       //agregarVehiculos();
       //agregarTramites(); 
       //agregarTramitesL();  
       //agregarTramitesV();   
    }

    /**
     * Metodo que se encarga de agregar personas de forma masiva
     * utilizando un procedure
     */
    @Override
    public void agregarPersonas() {
         EntityManager em = getEntityManager();
       em.getTransaction().begin();
       Encriptar encriptacion = new Encriptar();
//       EntityManager.getTransaction().begin();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_persona");
       
       //Insertamos los parametros
       //Apellido paterno
       storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       //Apellido materno
       storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       //Fecha nacimiento
       storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
       //Nombre
       storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       //RFC
       storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       //Telefono
       storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       
        String[][] personas = {
            {"Valenzuela", "Tarazon", "2003-05-10", "Oscar", "LOEJ800515TAR","345667890"},
            {"Garcia", "Lopez", "1990-02-14", "Maria", "LOEJ800515GAR","5551234567"},
            {"Gonzalez", "Perez", "1985-10-22", "Pedro", "LOEJ800515GON","4447654321"},
            {"Martinez", "Sanchez", "1977-06-05", "Luis", "LOEJ800515MAR","7778901234"},
            {"Hernandez", "Rivera", "1999-12-30", "Ana", "LOEJ800515HER","2225556789"},
            {"Diaz", "Vazquez", "1983-09-17", "Juan", "LOEJ800515DIA","3339994567"},
            {"Romero", "Castillo", "1975-01-01", "Elena", "LOEJ800515ROM","7778881234"},
            {"Ramirez", "Gutierrez", "2005-08-08", "Miguel", "LOEJ800515RAM","7778884567"},
            {"Torres", "Lopez", "1994-04-20", "Sofia", "LOEJ800515TOR","6667891234"},
            {"Guzman", "Santos", "1992-11-12", "Carlos", "LOEJ800515GUZ","4446667890"},
            {"Castro", "Rojas", "1979-07-26", "Laura", "LOEJ800515CAS","3337773456"},
            {"Reyes", "Fernandez", "2001-03-18", "David", "LOEJ800515REY","5554445678"},
            {"Mendoza", "Pineda", "1988-12-05", "Jose", "LOEJ800515MEN","3335556789"},
            {"Ramos", "Torres", "1972-02-29", "Carmen", "LOEJ800515RAM","7776662345"},
            {"Sosa", "Lopez", "2008-11-17", "Diego", "LOEJ800515SOS","2224446789"},
            {"Orozco", "Castillo", "1981-05-15", "Fernanda", "LOEJ800515ORO","4447772345"},
            {"Chavez", "Mendez", "1996-09-02", "Gabriel", "LOEJ800515CHA","5558883456"},
            {"Medina", "Santos", "1970-07-07", "Adriana", "LOEJ800515MED","7774445678"},
            {"Fuentes", "Vega", "2000-04-25", "Andres", "LOEJ800515FUE","2227773456"},
            {"Benitez", "Hernandez", "1998-01-13", "Jazmin", "LOEJ800515BEN","4448881234"}};
        
         for (int i = 0; i < personas.length; i++) {
             String encript0 = encriptacion.encriptar(personas [i][0]);
             personas [i][0] = encript0;
             
             String encript1 = encriptacion.encriptar(personas [i][1]);
             personas [i][1] = encript1;
             
             String encript = encriptacion.encriptar(personas [i][3]);
             personas [i][3] = encript;
             
        }
        
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
            storedProcedure.setParameter(6, personas[i][5]);
            
             
            // Ejecutamos el procedimiento almacenado
            storedProcedure.execute();
        }
        
       
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
       
    }
}
