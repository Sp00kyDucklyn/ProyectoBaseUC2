/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.MenuDAO;

/**
 * Pantalla menú del programa
 * @author xfs85
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Metodo constructor por omisión
     */
    public FrmMenu() {
       
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRealizacionTramite = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnGeneracionReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAgregadaMasiva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRealizacionTramite.setBorderPainted(false);
        btnRealizacionTramite.setContentAreaFilled(false);
        btnRealizacionTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizacionTramiteActionPerformed(evt);
            }
        });
        jPanel2.add(btnRealizacionTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 30));

        btnConsulta.setBorderPainted(false);
        btnConsulta.setContentAreaFilled(false);
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 40));

        btnGeneracionReporte.setBorderPainted(false);
        btnGeneracionReporte.setContentAreaFilled(false);
        btnGeneracionReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneracionReporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnGeneracionReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 210, 380));

        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        btnAgregadaMasiva.setBorderPainted(false);
        btnAgregadaMasiva.setContentAreaFilled(false);
        btnAgregadaMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregadaMasivaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregadaMasiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 519, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/MenuPrincipal (3).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1010, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 602));
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * salir 
 * @param evt evt
 */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
/**
 * agregar masivo
 * @param evt evt
 */
    private void btnAgregadaMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregadaMasivaActionPerformed
        // TODO add your handling code here:
        MenuDAO menu = new MenuDAO();
        menu.llamarProcedimiento();
    }//GEN-LAST:event_btnAgregadaMasivaActionPerformed
/**
 * reliazar tramite
 * @param evt evt
 */
    private void btnRealizacionTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizacionTramiteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        FrmSeleccionTramite seleccion = new FrmSeleccionTramite();
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRealizacionTramiteActionPerformed
/**
 * btnConsulta
 * @param evt evt
 */
    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        // TODO add your handling code here:
        FrmConsultas cons = new FrmConsultas();
        this.setVisible(false);
        cons.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultaActionPerformed
/**
 * generar reporte
 * @param evt evt
 */
    private void btnGeneracionReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneracionReporteActionPerformed
        // TODO add your handling code here:
        FrmReportes repor = new FrmReportes();
        this.setVisible(false);
        repor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGeneracionReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregadaMasiva;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnGeneracionReporte;
    private javax.swing.JButton btnRealizacionTramite;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
