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
 *
 * @author hoshi
 */
public class FrmPersona extends javax.swing.JFrame {

    /**
     * Creates new form FrmPersona
     */
    
    Tramite tramite = new Tramite();
    PersonaDAO personaDAO = new PersonaDAO();

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblRfc = new javax.swing.JLabel();
        lblFechaNa = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("INFORMACIÓN PERSONA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 310, 59));

        jLabel2.setText("Nombre completo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel3.setText("Fecha nacimiento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel4.setText("Rfc:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 100, 30));
        getContentPane().add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 110, 30));
        getContentPane().add(lblFechaNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 90, 30));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPersona().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
