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

    @Override
    public void llamarProcedimiento() {
       EntityManager em = getEntityManager();
       em.getTransaction().begin();
//       EntityManager.getTransaction().begin();
       
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
       //RFC
       storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       //Telefono
       storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       
       //Discapacitado
       storedProcedure.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
       //Estado
       storedProcedure.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
       //FechaExpecidion
       storedProcedure.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
       //FechaVencimiento
       storedProcedure.registerStoredProcedureParameter(10, Date.class, ParameterMode.IN);
       
       
       //Vigencia
       storedProcedure.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
       //NumeroPlacas
       storedProcedure.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        //Tipo
       storedProcedure.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
       
        //Establecemos los valores de entrada con un arreglo que ya tiene 
        //A todas las personas a establecer
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
       
        String[][] tramitePersonas = {
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"placa"},
            {"placa"},
            {"placa"},
            {"placa"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"licencia"},
            {"placa"}
        };
       
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
            
             for (int a = 0; a < licencias.length; a++) {
                storedProcedure.setParameter(7, tramitePersonas[i][0]);
                storedProcedure.setParameter(8, tramitePersonas[i][7]);
                storedProcedure.setParameter(9, tramitePersonas[i][8]);
                storedProcedure.setParameter(10, tramitePersonas[i][9]);
                storedProcedure.setParameter(11, tramitePersonas[i][10]);
                
                for (int b = 0; b < placas.length; b++) {
                    storedProcedure.setParameter(8, tramitePersonas[i][7]);
                    storedProcedure.setParameter(9, tramitePersonas[i][8]);
                    storedProcedure.setParameter(10, tramitePersonas[i][9]);
                    storedProcedure.setParameter(12, tramitePersonas[i][10]);
                
                    for (int j = 0; j < tramitePersonas.length; j++) {

                        storedProcedure.setParameter(13, tramitePersonas[i][0]);

                    }
                }

            }
            // Ejecutamos el procedimiento almacenado
            storedProcedure.execute();
        }
        
       
        em.getTransaction().commit();
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
    }
    
    
}
