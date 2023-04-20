/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.PersonaDAO;
import dao.PlacaDAO;
import dao.VehiculoDAO;
import dominio.Persona;
import dominio.Placa;
import dominio.Tramite;
import dominio.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import utileria.Validaciones;

/**
 * Pantalla de placas
 * @author xfs85
 */
public class FrmPlaca extends javax.swing.JFrame {

    /**
     * Creates new form FrmPlaca
     */
    Tramite tramite = new Tramite();
    Persona persona = new Persona();
    Vehiculo vehiculo = new Vehiculo();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    PlacaDAO pdao = new PlacaDAO();
    Placa placa = new Placa();
    String fuente;
    
    
//    Placa placa = new Placa();
//<<<<<<< HEAD:PruebaP/src/main/java/pantallas/FrmPlaca.java
//  
    
   /**
    * Metodo constructor que recibe vehiculo y la fuente donde se ingresa al frame
    * @param fuente
    * @param vehiculo 
    */
    public FrmPlaca(String fuente,Vehiculo vehiculo) {
//=======
//
//    public SiPlaca2(Persona persona, Vehiculo vehiculo) {
//>>>>>>> main:PruebaP/src/main/java/pantallas/SiPlaca2.java
        initComponents();
        this.fuente = fuente;
        this.vehiculo = vehiculo;
        
        
        rfc.setText(vehiculo.getPersona().getRfc());
        lblnumSerie.setText(vehiculo.getNumSerie());
        pdao.placaActiva(lblnumSerie.getText());
        generarNumPlacas();
        
//        if (pdao.llamarListaPlacas(vehiculo.getId()) == null) {
//            lblCosto.setText("1500");
//        } else if(vehiculo.getPlacas() != null){
//            lblCosto.setText("1000");
//        }
         
          if(fuente.equals("agregar")){
              lblCosto.setText("1500");
          }else if(fuente.equals("renovar")){
              lblCosto.setText("1000");
              lblPlacas.setText(placa.getNumPlacaNu());
              
          }
        
        calculaFecha();
        
        cmbVehiculos.setVisible(false);
        //crearCmbVehiculos(cmbVehiculos);
    }
  
/**
 * Metodo que agrega la placa
 * @return placa
 * @throws ParseException 
 */
    private Placa agregarPlaca() throws ParseException {
        
        
        HashMap<String, String> datosFormulario = this.extraerDatosFormulario();
        String numPlacaNu = lblPlacas.getText();
        Date fechaExpedicion = new Date();

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String fechaVen = datosFormulario.get("fechaVencimiento");
        Date fechaVencimiento = formatoDelTexto.parse(fechaVen);
//        List <Placa> placas = new ArrayList<>();
//        placas = pdao.llamarListaPlacas(vehiculo.getId());

        String costo = lblCosto.getText();
        String estado = datosFormulario.get("estado");
        Placa placa = new Placa();
        //Vehiculo vehiculoSeleccionado = (Vehiculo) cmbVehiculos.getSelectedItem();
        if(pdao.llamarListaPlacas(vehiculo.getId()) == null){
            placa = new Placa(numPlacaNu,tramite.getId(), costo, fechaVencimiento,fechaExpedicion, estado);
            pdao.placaActiva(vehiculo.getNumSerie());
            return placa;
        }else if(vehiculo.getPlacas() != null){
             pdao.DesactivarPlaca(vehiculo.getNumSerie());
             placa = new Placa(numPlacaNu, vehiculo, tramite.getId(), costo, fechaExpedicion, fechaVencimiento, estado, vehiculo.getPersona());
             
             return placa;
        }
       

        return placa;
    }

    /**
     * Metodo que agrega el combo box de vehiculos
     * @param cmbVehiculos 
     */
    private void crearCmbVehiculos(JComboBox cmbVehiculos) {
        pdao.crearCmbVehiculos(cmbVehiculos);
        cmbVehiculos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el vehículo seleccionado
                Vehiculo vehiculos = (Vehiculo) cmbVehiculos.getSelectedItem();
                if (vehiculos != null) {
                    lblCosto.setText("1500");
                }
            }
        });
    }

    /**
     * Metodo que establece el estado de las placas
     */
  private void estadoActivo(){
        Date fecha = new Date();
        if(fecha.compareTo(new Date())==0){
            lblEstado.setText("activo");
        }else{
        }
       
    }

  /**
   * Metodo que extrae los datos del formulario
   * @return datos del formulario
   */
    private HashMap<String, String> extraerDatosFormulario() {
        String estado = lblEstado.getText();
        String fechaVencimiento = lblFechaVencimiento.getText();

        HashMap<String, String> datosFormulario = new HashMap<>();
        datosFormulario.put("estado", estado);
        datosFormulario.put("fechaVencimiento", fechaVencimiento);

        return datosFormulario;
    }

    /**
     * Metodo que calcula la fecha de expedicion y de vencimiento
     * de la placa
     */
    private void calculaFecha() {

        Date fechaExpedicion = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaExpedicion);

        int suma = fechaExpedicion.getYear() + 1;
        calendar.add(Calendar.YEAR, 1);
        Date fechaVencimiento = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaVencimientoString = sdf.format(fechaVencimiento);
        lblFechaVencimiento.setText(fechaVencimientoString);
    }
    
    /**
     * Metodo que genera el numero de placas
     */
    private void generarNumPlacas(){
        int numeros = 0;
        String numero;
        final String cadena = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int longitud = 3;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < longitud; i++){
        double aleatorio = Math.random() * cadena.length();
        int posicion = (int) aleatorio;
        char letra = cadena.charAt(posicion);
        sb.append(letra);
    }
        numeros = (int) (Math.random() * 1000 + 99);
        numero = String.valueOf(numeros);
        
        lblPlacas.setText(sb.toString() + "-" + numero);
        
        if(lblPlacas.getText().length() != 7){
            generarNumPlacas();
        }
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
        lblnumSerie = new javax.swing.JLabel();
        cmbVehiculos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        rfc = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblPlacas = new javax.swing.JLabel();
        lblFechaVencimiento = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 612));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblnumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 180, 30));

        cmbVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVehiculosActionPerformed(evt);
            }
        });
        jPanel1.add(cmbVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 210, 40));

        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 180, 30));

        rfc.setToolTipText("");
        jPanel1.add(rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 190, 30));
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 190, 30));

        lblPlacas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(lblPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 160, 50));
        jPanel1.add(lblFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 200, 40));

        btnHistorial.setBorder(null);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 180, 30));

        btnCancelar.setToolTipText("");
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/SiPlaca2 (1).png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -140, 1020, 860));

        lblEstado.setText("jLabel2");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, -1, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        VehiculoDAO vdao = new VehiculoDAO();
        estadoActivo();
        String numSerie = lblnumSerie.getText();
//        calculaCosto();
        List<Vehiculo> vehiculos = vdao.buscarNumSerie(numSerie);
        if(!vehiculos.isEmpty()){
          int  respuesta = JOptionPane.showConfirmDialog(this, "La placa está activa, ¿Desea desactivarla?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                pdao.DesactivarPlaca(numSerie);
                
            }else{
                return;
            }
            
            try {
            pdao.crearPlaca(this.agregarPlaca());
            Validaciones val = new Validaciones();
            val.mostrarMensaje("Se guardo exitosamente", "Info", "Guardado Correctamente");
             int si= JOptionPane.YES_OPTION;
             JOptionPane.showMessageDialog(this, "Trámite completado, regresemos al inicio :)","Regreso inicio",si);
             if(si==0){
                 this.setVisible(false);
                 FrmMenu menu= new FrmMenu();
                 menu.setVisible(true);
                 this.dispose();
             }
        } catch (ParseException ex) {
            Logger.getLogger(FrmPlaca.class.getName()).log(Level.SEVERE, null, ex);

            Validaciones val = new Validaciones();
            val.mostrarMensaje("Se guardo exitosamente", "Info", "Guardado Correctamente");
        }
        }
        
    

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehiculosActionPerformed

    }//GEN-LAST:event_cmbVehiculosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmSeleccionTramite sm = new FrmSeleccionTramite();
        this.setVisible(false); 
        sm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (!rfc.getText().isEmpty()) {

                PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(rfc.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
             } else {
                JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                this.setVisible(false);
                FrHistorialLicencia historial = new FrHistorialLicencia(persona.get(0));
                historial.setVisible(true);
                this.dispose();
            }

        }
        
//        FrHistorialPlaca hp = new FrHistorialPlaca(persona);
//        this.setVisible(false);
//        hp.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPlaca().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JComboBox<String> cmbVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblPlacas;
    private javax.swing.JLabel lblnumSerie;
    private javax.swing.JLabel rfc;
    // End of variables declaration//GEN-END:variables
}
