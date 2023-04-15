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
    
    private EntityManagerFactory entityManagerFactory = null;

    public MenuDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void llamarProcedimiento() {
       agregarPersonas();
       //agregarTramites();
       //agregarTramitesL();
       //agregarTramitesV();
       agregarVehiculos();
    }

    @Override
    public void agregarPersonas() {
         EntityManager em = getEntityManager();
       em.getTransaction().begin();
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
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_vehiculo");
       
       //Insertamos los parametros
       //Linea
       storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       //Color
       storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       //Año
       storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
       //Marca
       storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       //NumSerie
       storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       //idPersona
       storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       
        

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       String[][] vehiculos = {
            {"Toyota Camry", "Rojo", "2003-04-12", "Toyota", "1G1YY26U055000000","1"},
            {"Honda Accord", "Rosa", "1990-04-12", "Honda", "JTHBJ46G272000000","2"},
            {"Chevrolet Malibu", "Verde", "1985-04-12", "Chevrolet", "JHMCG5650XC000000","3"},
            {"Ford Mustang", "Azul", "1977-04-12", "Ford", "1B3ES56C91D000000","4"},
            {"BMW 3 Series", "Gris", "1999-04-12", "BMW", "JF1GD70626L000000","5"},
            {"Mercedes-Benz C-Class", "Blanco", "2020-04-12", "Mercedes-Benz", "1FAFP56S23A000000","6"},
            {"Audi A4", "Negro", "1975-04-12", "Audi", "KMHDN46D24U000000","7"},
            {"Nissan Altima", "Naranja", "2005-04-12", "Nissan", "KL1TD66E59B000000","8"},
            {"Hyundai Elantra", "Azul Clarito", "1994-04-12", "Hyundai", "2G1FP32G322000000","9"},
            {"Kia Optima", "Rojo", "1992-04-12", "Kia", "5N1AT2MT5FC000000","10"},
            {"Toyota Camry", "Rosa", "1979-04-12", "Toyota", "1G1YY26U055000001","11"},
            {"Honda Accord", "Blanco", "2001-04-12", "Honda", "JTHBJ46G272000001","12"},
            {"Chevrolet Malibu", "Gris", "1988-04-12", "Chevrolet", "JHMCG5650XC000001","13"},
            {"Ford Mustang", "Negro", "1972-04-12", "Ford", "1B3ES56C91D000001","14"},
            {"BMW 3 Series", "Verde", "2008-04-12", "BMW", "JF1GD70626L000001","15"},
            {"Mercedes-Benz C-Class", "Azul", "1981-04-12", "Mercedes-Benz", "1FAFP56S23A000001","16"},
            {"Audi A4", "Azul Clarito", "1996-04-12", "Audi", "KMHDN46D24U000001","17"},
            {"Nissan Altima", "Naranja", "1970-04-12", "Nissan", "KL1TD66E59B000001","18"},
            {"Hyundai Elantra", "Azul", "2000-04-12", "Hyundai", "2G1FP32G322000001","19"},
            {"Kia Optima", "Verde", "1998-04-12", "Kia", "5N1AT2MT5FC000001","20"}};
       
       
        for (int i = 0; i < vehiculos.length; i++) {
            
            storedProcedure.setParameter(1, vehiculos[i][0]);
            storedProcedure.setParameter(2, vehiculos[i][1]);

            String fechaString = vehiculos[i][2]; // fecha en formato "yyyy-MM-dd"
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            try {
                fecha = format.parse(fechaString);
                storedProcedure.setParameter(3, fecha);
            } catch (ParseException ex) {
                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion");
            }
        
            storedProcedure.setParameter(4, vehiculos[i][3]);
            storedProcedure.setParameter(5, vehiculos[i][4]);
            storedProcedure.setParameter(6, vehiculos[i][5]);
            
           
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
       //Tipo
       storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        
        String[][] tramites = {
            {"Valenzuela", "Tarazon", "2003-05-10", "Oscar", "LOEJ800515TAR","licencia"},
            {"Garcia", "Lopez", "1990-02-14", "Maria", "LOEJ800515GAR","licencia"},
            {"Gonzalez", "Perez", "1985-10-22", "Pedro", "LOEJ800515GON","licencia"},
            {"Martinez", "Sanchez", "1977-06-05", "Luis", "LOEJ800515MAR","licencia"},
            {"Hernandez", "Rivera", "1999-12-30", "Ana", "LOEJ800515HER","licencia"},
            {"Diaz", "Vazquez", "1983-09-17", "Juan", "LOEJ800515DIA","licencia"},
            {"Romero", "Castillo", "1975-01-01", "Elena", "LOEJ800515ROM","licencia"},
            {"Ramirez", "Gutierrez", "2005-08-08", "Miguel", "LOEJ800515RAM","placas"},
            {"Torres", "Lopez", "1994-04-20", "Sofia", "LOEJ800515TOR","placas"},
            {"Guzman", "Santos", "1992-11-12", "Carlos", "LOEJ800515GUZ","placas"},
            {"Castro", "Rojas", "1979-07-26", "Laura", "LOEJ800515CAS","placas"},
            {"Reyes", "Fernandez", "2001-03-18", "David", "LOEJ800515REY","licencia"},
            {"Mendoza", "Pineda", "1988-12-05", "Jose", "LOEJ800515MEN","licencia"},
            {"Ramos", "Torres", "1972-02-29", "Carmen", "LOEJ800515RAM","licencia"},
            {"Sosa", "Lopez", "2008-11-17", "Diego", "LOEJ800515SOS","licencia"},
            {"Orozco", "Castillo", "1981-05-15", "Fernanda", "LOEJ800515ORO","licencia"},
            {"Chavez", "Mendez", "1996-09-02", "Gabriel", "LOEJ800515CHA","licencia"},
            {"Medina", "Santos", "1970-07-07", "Adriana", "LOEJ800515MED","licencia"},
            {"Fuentes", "Vega", "2000-04-25", "Andres", "LOEJ800515FUE","licencia"},
            {"Benitez", "Hernandez", "1998-01-13", "Jazmin", "LOEJ800515BEN","licencia"}};
        
       
                for (int i = 0; i < tramites.length; i++) {
            
            storedProcedure.setParameter(1, tramites[i][0]);
            storedProcedure.setParameter(2, tramites[i][1]);

            String fechaString = tramites[i][2]; // fecha en formato "yyyy-MM-dd"
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            try {
                fecha = format.parse(fechaString);
                storedProcedure.setParameter(3, fecha);
            } catch (ParseException ex) {
                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion");
            }
        
            storedProcedure.setParameter(4, tramites[i][3]);
            storedProcedure.setParameter(5, tramites[i][4]);
            storedProcedure.setParameter(6, tramites[i][5]);
            
             
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
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_tramites_herencia_licencia");
       
        //Estado
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        //FechaExpedicion
        storedProcedure.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
        //FechaVencimiento
        storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);

        //NumeroPlacas
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       
       String[][] placas ={
            {"activo", "2023-04-10", "2026-04-10", "323456"},
            {"activo", "2023-04-10", "2026-04-10", "323458"},
            {"desactivo", "2021-04-10", "2023-04-10", "323457"},
            {"activo", "2023-04-10", "2025-04-10", "323459"},
            {"activo", "2023-04-10", "2024-04-10", "323451"},
            {"desactivo", "2022-04-10", "2023-04-10", "323452"},
            {"activo", "2023-04-10", "2024-04-10", "323453"},
            {"desactivo", "2022-04-10", "2023-04-10", "323454"},
            {"activo", "2023-04-10", "2024-04-10", "323455"},
            {"activo", "2023-04-10", "2024-04-10", "323433"},
            {"activo", "2023-04-10", "2024-04-10", "323431"},
            {"desactivo", "2021-04-10", "2022-04-10", "323432"},
            {"activo", "2023-04-10", "2024-04-10", "323434"},
            {"desactivo", "2022-04-10", "2023-04-10", "323436"},
            {"activo", "2023-04-10", "2024-04-10", "323437"},
            {"desactivo", "2021-04-10", "2022-04-10", "323438"},
            {"activo", "2023-04-10", "2025-04-10", "323439"},
            {"activo", "2023-04-10", "2025-04-10", "323435"},
            {"desactivo", "2021-04-10", "2022-04-10", "323443"},
            {"activo", "2023-04-10", "2025-04-10", "323449"}
            };
       
                
               for (int b = 0; b < placas.length; b++) {

               
                storedProcedure.setParameter(1, placas[b][0]);

                String fechaStringP = placas[b][2];
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha2;
                try {
                    fecha2 = format2.parse(fechaStringP);
                    storedProcedure.setParameter(2, fecha2);
                    storedProcedure.setParameter(3, fecha2);
                } catch (ParseException ex) {
                    Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Excepcion");
                }
                storedProcedure.setParameter(4, placas[b][3]);
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
       
       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("insert_tramites_herencia_licencia");
            //Discapacitado
            storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            //Estado
            storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            //FechaExpedicion
            storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
            //FechaVencimiento
            storedProcedure.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
            //Vigencia
            storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);

        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
       
       String[][] licencias ={
            {"no", "activo", "2023-04-10", "2026-04-10", "3"},
            {"no", "activo", "2023-04-10", "2026-04-10", "3"},
            {"no", "desactivo", "2021-04-10", "2023-04-10", "2"},
            {"no", "activo", "2023-04-10", "2025-04-10", "2"},
            {"no", "activo", "2023-04-10", "2024-04-10", "1"},
            {"no", "desactivo", "2022-04-10", "2023-04-10", "1"},
            {"si", "activo", "2023-04-10", "2024-04-10", "1"},
            {"no", "desactivo", "2022-04-10", "2023-04-10", "1"},
            {"si", "activo", "2023-04-10", "2024-04-10", "1"},
            {"no", "activo", "2023-04-10", "2024-04-10", "1"},
            {"si", "activo", "2023-04-10", "2024-04-10", "1"},
            {"no", "desactivo", "2021-04-10", "2022-04-10", "1"},
            {"no", "activo", "2023-04-10", "2024-04-10", "1"},
            {"si", "desactivo", "2022-04-10", "2023-04-10", "1"},
            {"si", "activo", "2023-04-10", "2024-04-10", "1"},
            {"no", "desactivo", "2021-04-10", "2022-04-10", "1"},
            {"si", "activo", "2023-04-10", "2025-04-10", "2"},
            {"no", "activo", "2023-04-10", "2025-04-10", "2"},
            {"si", "desactivo", "2021-04-10", "2022-04-10", "1"},
            {"no", "activo", "2023-04-10", "2025-04-10", "2"}
            };
       
        for (int a = 0; a < licencias.length; a++) {
           
            storedProcedure.setParameter(1, licencias[a][0]);
            storedProcedure.setParameter(2, licencias[a][1]);

            String fechaString = licencias[a][2];
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            try {
                fecha = format.parse(fechaString);
                storedProcedure.setParameter(3, fecha);
                storedProcedure.setParameter(4, fecha);
            } catch (ParseException ex) {
                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion");
            }
                storedProcedure.setParameter(5, licencias[a][4]);
                
            storedProcedure.execute();
       
            }
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
    }
}
