/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import javax.swing.JButton;

/**
 *
 * @author xfs85
 */
public class SeleccionTramite extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionTramite
     */
    public SeleccionTramite() {
        initComponents();
        //Necesito construir 4 botones
        //Dos paneles 
        btnPersona.setVisible(false);
        btnVehiculo.setVisible(false);
    }
    
    //Crear 2 paneles
    //Crear 4 botones 
    //Asignar acciones a los botones
//    public void initComponentsCustom(){
//        JButton btnPlacas = new JButton();
//        //C:\Users\hoshi\Documents\PruebaProyecto\Prueba1\PruebaP\src\main\resources\imagenesPantallas\placas.png
//        btnPlacas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenesPantallas/placas.png")));
//        
//        panOpciones.add(btnPlacas);
//    }
//    
//    public void mostrarBotones(){
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panOpciones = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JButton();
        btnPersona = new javax.swing.JButton();
        btnVehiculo = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRenovacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panOpciones.setPreferredSize(new java.awt.Dimension(800, 600));
        panOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistro.setText("jButton1");
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
        });
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        panOpciones.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 190, -1));

        btnPersona.setText("jButton1");
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        panOpciones.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        btnVehiculo.setText("jButton1");
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });
        panOpciones.add(btnVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        btnVolver.setText("jButton1");
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panOpciones.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 30, 40));

        btnRenovacion.setText("jButton1");
        btnRenovacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRenovacionMouseClicked(evt);
            }
        });
        btnRenovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovacionActionPerformed(evt);
            }
        });
        panOpciones.add(btnRenovacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Cuadro1 (1).png"))); // NOI18N
        panOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, -1));

        getContentPane().add(panOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 807, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         this.setVisible(false);
         MenuPrincipal menu = new MenuPrincipal();
         menu.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRenovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRenovacionActionPerformed

    private void btnRenovacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRenovacionMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnRenovacionMouseClicked

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVehiculoActionPerformed

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        // TODO add your handling code here:
       
            
        
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
        
            
        if(btnRegistro.isSelected()){
            btnPersona.setVisible(false);
            btnVehiculo.setVisible(false);
        }else{
            btnPersona.setVisible(true);
            btnVehiculo.setVisible(true);
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        RegistroPersona registro = new RegistroPersona();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPersonaActionPerformed

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
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SeleccionTramite().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRenovacion;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panOpciones;
    // End of variables declaration//GEN-END:variables
}