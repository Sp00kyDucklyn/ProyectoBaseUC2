/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.PersonaDAO;
import dominio.Persona;
import dominio.Tramite;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Pantalla de persona
 * @author hoshi
 */
public class FrmPersona extends javax.swing.JFrame {

    /**
     * Creates new form FrmPersona
     */
    /**
     * tramite
     */
    Tramite tramite = new Tramite();
    /**
     * personadao
     */
    PersonaDAO personaDAO = new PersonaDAO();
/**
 * Metodo constructor que recibe un parametro, la persona que realiza
 * el tramite
 * @param persona persona que realiza el tramite
 */
    public FrmPersona(Persona persona) {
        initComponents();
        tramite.getPersona();
        personaDAO.desencriptarPersona(persona);
        String n = persona.getNombre() + " "
                + persona.getApellidoP() + " " + persona.getApellidoM();
//        lblNombrePersona.setText(n);
        lblNombre.setText(n);
        lblRfc.setText(persona.getRfc());
        Date fecha_actual = persona.getFechaNa();
        SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_actual_str = formato_fecha.format(fecha_actual);
        lblFechaNa.setText(fecha_actual_str);
        lblTelefono.setText(persona.getTelefono());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTelefono = new javax.swing.JLabel();
        lblRfc = new javax.swing.JLabel();
        lblFechaNa = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 190, 40));
        getContentPane().add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 170, 40));
        getContentPane().add(lblFechaNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 170, 40));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Registro Personas (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
