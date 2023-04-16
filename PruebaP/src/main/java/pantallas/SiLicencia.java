/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.LicenciaDAO;
import dao.PersonaDAO;
import interfaces.ILicenciaDAO;
import dominio.Licencia;
import dominio.Persona;
import dominio.Tramite;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utileria.Validaciones;

/**
 *
 * @author xfs85
 */
public class SiLicencia extends javax.swing.JFrame {

    /**
     * Creates new form SiLicencia
     */
    Persona persona = new Persona();
    Tramite tramite = new Tramite();
    LicenciaDAO licenciaDAO = new LicenciaDAO();

    public SiLicencia(Persona persona) {
        initComponents();
        this.persona = persona;
        lblRfc.setText(persona.getRfc());

    }

    public Licencia agregarLicencia() throws ParseException {
        //Extrer datos del formulario
        HashMap<String, String> datosFormulario = this.extraerDatosFormulario();
//        List<String> erroresVaidacion = this.validarDatosFormulario(datosFormulario);
//        if (!erroresVaidacion.isEmpty()) {
//            this.mostrarErroresValidacion(erroresVaidacion);
//        }

        String vigencia = datosFormulario.get("vigencia");
        String discapacitado = datosFormulario.get("discapacitado");
        String estado = datosFormulario.get("estado");
        Date fechaExpedicion = new Date();
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String fechaVen = datosFormulario.get("fechaVen");
        Date fechaV = formatoDelTexto.parse(fechaVen);
        
        String costo = datosFormulario.get("costo");
        
        Licencia licencia = new Licencia(vigencia, discapacitado, tramite.getId(), costo, fechaExpedicion,fechaV, estado, persona);

        return licencia;
    }

    private void mostrarErroresValidacion(List<String> erroresVaidacion) {
        //Nos va a concatenar los errores y nos pondra un enter
        String mensaje = String.join("\n", erroresVaidacion);
        JOptionPane.showMessageDialog(this, mensaje, "Errores de validacion", JOptionPane.WARNING_MESSAGE);
    }

    
    private void calculaFecha(){
        
        Date fechaExpedicion = new Date();
        String vigenciaS = (String) cmbVigencia.getSelectedItem();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaExpedicion);
        
        if (vigenciaS.equals("1 año")) {
            
            int suma = fechaExpedicion.getYear()+1;
            calendar.add(Calendar.YEAR, 1);
            Date fechaVencimiento = calendar.getTime();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaVencimientoString = sdf.format(fechaVencimiento);
            lblFechaVencimiento.setText(fechaVencimientoString);

        } else if (vigenciaS.equals("2 años")) {
            calendar.add(Calendar.YEAR, 2);
            Date fechaVencimiento = calendar.getTime();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaVencimientoString = sdf.format(fechaVencimiento);
            lblFechaVencimiento.setText(fechaVencimientoString);
            
        } else if (vigenciaS.equals("3 años")) {
            calendar.add(Calendar.YEAR, 3);
            Date fechaVencimiento = calendar.getTime();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaVencimientoString = sdf.format(fechaVencimiento);
            lblFechaVencimiento.setText(fechaVencimientoString);
        }
        
    }
//    
    private void calculaCosto(){
        String vigenciaS = (String) cmbVigencia.getSelectedItem();
        boolean discapacidad = chDiscapacitado.isSelected();
        

        if (vigenciaS.equals("1 año")) {
//           
            
            if (discapacidad) {
                lblCosto.setText("200");

            } else {
                lblCosto.setText("600");
            }

        } else if (vigenciaS.equals("2 años")) {
            
            if (discapacidad) {
                lblCosto.setText("500");
            } else {
                lblCosto.setText("900");
            }

        } else if (vigenciaS.equals("3 años")) {
            
            if (discapacidad) {
                lblCosto.setText("700");
            } else {
                lblCosto.setText("1100");
            }

        }
    }
    
    private void estado(){
        Date fecha = new Date();
        if(fecha.compareTo(new Date())==0){
            lblEstado.setText("activo");
        }else{
            
        }
    }
    
    
    private HashMap<String, String> extraerDatosFormulario() {
        String vigencia = (String) cmbVigencia.getSelectedItem();
        String dicapacitado = String.valueOf(chDiscapacitado.isSelected());
        String costo = lblCosto.getText();
        String fechaVen = lblFechaVencimiento.getText();
        String estado = lblEstado.getText();
       
        
        HashMap<String, String> datosFormulario = new HashMap<>();
        datosFormulario.put("vigencia", vigencia);
        datosFormulario.put("discapacitado", dicapacitado);
        datosFormulario.put("costo", costo);
        datosFormulario.put("fechaVen", fechaVen);
        datosFormulario.put("estado", estado);
        
        return datosFormulario;
    }

//    private List<String> validarDatosFormulario(HashMap<String, String> datosFormulario) {
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

        jPanel1 = new javax.swing.JPanel();
        btnCancelarRegistro = new javax.swing.JButton();
        btnAceptarRegistro = new javax.swing.JButton();
        lblCosto = new javax.swing.JLabel();
        chDiscapacitado = new javax.swing.JCheckBox();
        lblRfc = new javax.swing.JLabel();
        lblDiscapacitado = new javax.swing.JLabel();
        lblFechaVencimiento = new javax.swing.JLabel();
        cmbVigencia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 621));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelarRegistro.setText("Cancelar");
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, 30));

        btnAceptarRegistro.setText("Aceptar");
        btnAceptarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, 30));
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 210, 30));

        chDiscapacitado.setText("Discapacitado");
        jPanel1.add(chDiscapacitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));
        jPanel1.add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 210, 40));

        lblDiscapacitado.setText("Tienes alguna discapacidad?");
        jPanel1.add(lblDiscapacitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));
        jPanel1.add(lblFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 300, 40));

        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1 año", "2 años", "3 años" }));
        cmbVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVigenciaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Fecha de Vencimiento: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/SiLicencia.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblEstado.setText("jLabel3");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 598));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVigenciaActionPerformed
        // TODO add your handling code here:
        this.calculaCosto();
        this.calculaFecha();
        this.estado();
    }//GEN-LAST:event_cmbVigenciaActionPerformed

    private void btnAceptarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroActionPerformed
        ILicenciaDAO licenciaDAO = new LicenciaDAO();
         try {
           // Crear objeto Persona
             licenciaDAO.crearLicencia(this.agregarLicencia());
             Validaciones val = new Validaciones();
             val.mostrarMensaje("Se guardo exitosamente", "Info", "Guardado Correctamente");
             int si= JOptionPane.YES_OPTION;
             JOptionPane.showMessageDialog(this, "Trámite completado, regresemos al inicio :)","Regreso inicio",si);
             if(si==0){
                 this.setVisible(false);
                 MenuPrincipal menu= new MenuPrincipal();
                 menu.setVisible(true);
                 this.dispose();
             }
        } catch (ParseException ex) {
            Logger.getLogger(RegistroPersona.class.getName()).log(Level.SEVERE, null, ex);
            Validaciones val = new Validaciones();
            val.mostrarMensaje("No se completo el guardado", "Error", "Error, intente de nuevo");
        }
      
    }//GEN-LAST:event_btnAceptarRegistroActionPerformed

    private void btnCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        // TODO add your handling code here:
        int si_no=  JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar este trámite?","Cancelar", JOptionPane.YES_NO_OPTION);
        
        if(si_no == 1){
            
            this.setVisible(true);
           
            
        }else if(si_no == 0){
             JOptionPane.showMessageDialog(this, "Esta opción lo regresara al menú principal");
            
            this.setVisible(false);
            MenuPrincipal menu= new MenuPrincipal();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
//            java.util.logging.Logger.getLogger(SiLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SiLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SiLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SiLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SiLicencia().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarRegistro;
    private javax.swing.JButton btnCancelarRegistro;
    private javax.swing.JCheckBox chDiscapacitado;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDiscapacitado;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblRfc;
    // End of variables declaration//GEN-END:variables
}
