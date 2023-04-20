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
import pantallas.FrmMenu;

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
                new FrmMenu().setVisible(true);
            }
        });
    
    }
        
    
    
}
