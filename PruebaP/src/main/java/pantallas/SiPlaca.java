/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.VehiculoDAO;
import dominio.Persona;
import dominio.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utileria.Validaciones;

/**
 *
 * @author xfs85
 */
public class SiPlaca extends javax.swing.JFrame {

    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    /**
     * Creates new form SiPlaca
     */
    public SiPlaca() {
        initComponents();
    }

    public Vehiculo agregarVehiculo() throws ParseException{
        //Extrer datos del formulario
        HashMap<String,String> datosFormulario = this.extraerDatosFormulario();
        //Validar datos del vehiculo //Puede existir clase validaciones
        List<String> erroresValidacion = this.validarDatosFormulario(datosFormulario);
        if(!erroresValidacion.isEmpty()){
            this.mostrarErroresValidacion(erroresValidacion);
//            return;
        }
        
        String numSerie = datosFormulario.get("numSerie");
         String marca = datosFormulario.get("marca");
         String linea = datosFormulario.get("linea");
         String color = datosFormulario.get("color");
         String anio = datosFormulario.get("anio");
         

         Vehiculo vehiculo = new Vehiculo(numSerie, marca, linea, color, anio);

         return vehiculo;
    }
    
    private void mostrarErroresValidacion(List<String> erroresValidacion){
        //Nos va a concatenar los errores y nos pondra un enter
        String mensaje = String.join("\n", erroresValidacion);
        JOptionPane.showMessageDialog(this, mensaje, "Errores de validacion", JOptionPane.WARNING_MESSAGE);
    }
    
    //Poner en variables individuales lo que estaba en las cajas
    //De texto
    //Uso de diccionarios, con llaves y values, asi el dia que esto cambie
    //Sea mas solido
    private HashMap<String,String> extraerDatosFormulario(){
        String numSerie = txtNumSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        String anio = txtAnio.getText();
        
       
        //Diciendole llave y valor de cada llave
        HashMap<String,String> datosFormulario = new HashMap<>();
        datosFormulario.put("numSerie", numSerie);
        datosFormulario.put("marca", marca);
        datosFormulario.put("linea", linea);
        datosFormulario.put("color", color);
        datosFormulario.put("anio", anio);
        
        //Estos datos se extraen como strings y posteriormente se validan
        return datosFormulario;
    }
    
//    //Es mejor hacer un metodo de validar por cada uno de los datos del hashmap
    private List<String> validarDatosFormulario(HashMap<String, String> datosFormulario){
        
        List<String> erroresValidacion = new LinkedList<>();
        String numSerie = datosFormulario.get("numSerie");
        if(Validaciones.esTextoVacio(numSerie)){
            erroresValidacion.add("El numero de serie esta vacio");
        }
        
        if(!Validaciones.validarCadena(numSerie)){
            erroresValidacion.add("El numero de serie no cumple el formato correcto");
        }

         return erroresValidacion;
       
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
        txtNumSerie = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumSerie.setToolTipText("");
        txtNumSerie.setBorder(null);
        txtNumSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSerieActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 200, 40));

        txtMarca.setBorder(null);
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 200, 40));

        txtLinea.setToolTipText("");
        txtLinea.setBorder(null);
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 332, 200, 30));

        txtAnio.setBorder(null);
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 422, 200, 30));

        txtColor.setBorder(null);
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 422, 190, 30));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 553, 170, 30));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 553, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/SiPlaca.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -19, 1010, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSerieActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try {
            vehiculoDAO.crearVehiculo(this.agregarVehiculo());
        } catch (ParseException ex) {
            Logger.getLogger(SiPlaca.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        Validaciones val = new Validaciones();
        val.mostrarMensaje("Se agrego exitosamente", "Info", "Guardado Correctamente ");
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
         SeleccionTramite seleccion = new SeleccionTramite();
         seleccion.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

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
//            java.util.logging.Logger.getLogger(SiPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SiPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SiPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SiPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SiPlaca().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
