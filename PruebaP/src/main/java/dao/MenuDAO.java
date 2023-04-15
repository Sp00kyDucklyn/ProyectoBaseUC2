/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Encriptar.Encriptar;
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
    
    private EntityManagerFactory entityManagerFactory = null;

    public MenuDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * 
     */
    public void llamarProcedimiento() {
       agregarPersonas();
       agregarVehiculos(); //FALTA STORED PROCEDURE
       agregarTramites(); //FALTA STORED PROCEDURE
       agregarTramitesL();    //FALTA STORED PROCEDURE
       agregarTramitesV();   // FALTA STORED PROCEDURE
    }

    /**
     * 
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

    @Override
    public void agregarVehiculos() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//       EntityManager.getTransaction().begin();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_vehiculos");
       
       //Insertamos los parametros
       //Linea
       storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       //Color
       storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       //Año
       storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       //Marca
       storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       //NumSerie
       storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       //idPersona
       storedProcedure.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
       
        

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       String[][] vehiculos = {
            {"Toyota Camry", "Rojo", "2003", "Toyota", "ABC-123","1"},
            {"Honda Accord", "Rosa", "1990", "Honda", "ABC-456","2"},
            {"Chevrolet Malibu", "Verde", "1985", "Chevrolet", "ABC-789","3"},
            {"Ford Mustang", "Azul", "1977", "Ford", "DFG-123","4"},
            {"BMW 3 Series", "Gris", "1999", "BMW", "DFG-456","5"},
            };
       
       
        for (int i = 0; i < vehiculos.length; i++) {
            
            storedProcedure.setParameter(1, vehiculos[i][0]);
            storedProcedure.setParameter(2, vehiculos[i][1]);
            storedProcedure.setParameter(3, vehiculos[i][2]);
            storedProcedure.setParameter(4, vehiculos[i][3]);
            storedProcedure.setParameter(5, vehiculos[i][4]);
            
            int id = 0;
            String idPersona = vehiculos[i][5];
            id = Integer.parseInt(idPersona);
            storedProcedure.setParameter(6, id);
            
            // Ejecutamos el procedimiento almacenado
            storedProcedure.execute();
        }
        
       
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
    }
    
    @Override
    public void agregarTramites() {
        
        EntityManager em = getEntityManager();
       em.getTransaction().begin();
//       EntityManager.getTransaction().begin();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_tramites");
       
       //Insertamos los parametros
       //tipo_tramite
       storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       //costo
       storedProcedure.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
       //estado
       storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       //fechaexpedicion
       storedProcedure.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
       //fechavencimiento x verse
       storedProcedure.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
       //idPersona
       storedProcedure.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
       
        String[][] tramites = {
            {"licencia", "600", "activo", "1"},//1
            {"licencia", "900", "activo", "2"},
            {"licencia", "1100", "activo", "3"},
            {"licencia", "600", "activo", "4"},
            {"licencia", "900", "activo", "5"},
            {"licencia", "1100", "activo", "6"},
            {"licencia", "600", "activo", "7"},
            {"licencia", "900", "activo", "8"},
            {"licencia", "1100", "activo", "9"},
            {"licencia", "600", "activo", "10"},
            {"licencia", "900", "activo", "11"},
            {"licencia", "1100", "activo", "12"},
            {"licencia", "600", "activo", "13"},
            {"licencia", "900", "activo", "14"},
            {"licencia", "1100", "activo", "15"},
            {"licencia", "1100", "desactivo", "16"},
            {"licencia", "1100", "desactivo", "17"},
            {"licencia", "1100", "desactivo", "18"},
            {"licencia", "1100", "desactivo", "19"},
            {"licencia", "1100", "desactivo", "20"},
            {"placa", "1500", "activo", "1"},
            {"placa", "1000", "activo", "2"},
            {"placa", "1500", "activo", "3"},
            {"placa", "1000", "activo", "4"},
            {"placa", "1000", "activo", "5"}};//25
        
        Date[][] fechas = {
            {new Date(),new Date(2024-04-18)},//1
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},//5
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},//10
            {new Date(),new Date(2025-04-18)},
            {new Date(),new Date(2025-04-18)},
            {new Date(),new Date(2025-04-18)},
            {new Date(),new Date(2025-04-18)},
            {new Date(),new Date(2025-04-18)},//15
            {new Date(),new Date(2026-04-18)},
            {new Date(),new Date(2026-04-18)},
            {new Date(),new Date(2026-04-18)},
            {new Date(),new Date(2026-04-18)},
            {new Date(),new Date(2026-04-18)},//20
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)},
            {new Date(),new Date(2024-04-18)}};//25
        
        
       
            for (int i = 0; i < tramites.length; i++) {
            
            storedProcedure.setParameter(1, tramites[i][0]);
            
           
            
            int cost = 0;
            String costoStr = tramites[i][1];
            cost = Integer.parseInt(costoStr);
            
            storedProcedure.setParameter(2, cost);
            
//            storedProcedure.setParameter(2, tramites[i][1]);
            storedProcedure.setParameter(3, tramites[i][2]);
//            String fechaString = tramites[i][2]; // fecha en formato "yyyy-MM-dd"
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            Date fecha;
//            try {
//                fecha = format.parse(fechaString);
//                storedProcedure.setParameter(3, fecha);
//            } catch (ParseException ex) {
//                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("Excepcion");
//            }
            
            storedProcedure.setParameter(4, fechas[i][0]);
            storedProcedure.setParameter(5, fechas[i][1]);
           
            int id = 0;
            String idPersona = tramites[i][3];
            id = Integer.parseInt(idPersona);
            
            storedProcedure.setParameter(6, id);
            
             
            // Ejecutamos el procedimiento almacenado
            storedProcedure.execute();
        }
        
       
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
       
    }

    @Override
    public void agregarTramitesV() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//       EntityManager.getTransaction().begin();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_tramites_placas");
       
       //idTramite
        storedProcedure.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        //numPlacasnu
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        //idVehiculo
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       
       String[][] placas ={
            {"21", "123456", "1"},
            {"22", "123789", "2"},
            {"23", "123123", "3"},
            {"24", "789456", "4"},
            {"25", "456123", "5"}
            };
       
                
               for (int b = 0; b < placas.length; b++) {

                   int idTramite = 0;
                   String idTramiteStr = placas[b][0];
                   idTramite = Integer.parseInt(idTramiteStr);
                   storedProcedure.setParameter(1, idTramite);

                   storedProcedure.setParameter(2, placas[b][1]);
                storedProcedure.setParameter(3, placas[b][2]);
                storedProcedure.execute();
            }
        
            
       
            
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
    }

    @Override
    public void agregarTramitesL() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//       EntityManager.getTransaction().begin();
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_tramites_licencia");
           
            //id_tramites
            storedProcedure.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            //Discapacitado
            storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            //Vigencia
            storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       
       String[][] licencias ={
            {"1","no", "1"},
            {"2","no","1"},
            {"3","no","1"},
            {"4","no","1"},
            {"5","no","1"},
            {"6","no","1"},
            {"7","no","1"},
            {"8","no","1"},
            {"9","no","1"},
            {"10","no", "1"},
            {"11","no","2"},
            {"12","no", "2"},
            {"13","no","2"},
            {"14","no","2"},
            {"15","no","2"},
            {"16","no", "3"},
            {"17","no","3"},
            {"18","no", "3"},
            {"19","no","3"},
            {"20","no","3"}
            };
       
        for (int a = 0; a < licencias.length; a++) {
           
            int idTramite = 0;
                   String idTramiteStr = licencias[a][0];
                   idTramite = Integer.parseInt(idTramiteStr);
                   
            storedProcedure.setParameter(1, idTramite);
            storedProcedure.setParameter(2, licencias[a][1]);
            storedProcedure.setParameter(3, licencias[a][2]);
                
            storedProcedure.execute();
       
            }
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
    }
}
