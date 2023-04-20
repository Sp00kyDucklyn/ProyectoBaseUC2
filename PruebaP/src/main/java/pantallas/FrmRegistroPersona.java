/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.PersonaDAO;
import dominio.Persona;
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
public class FrmRegistroPersona extends javax.swing.JFrame {
    
    PersonaDAO personaDAO = new PersonaDAO();
//    Validaciones val = new Validaciones();
    /**
     * Creates new form RegistroPersona
     */
    public FrmRegistroPersona() {
        initComponents();
    }
    
     public Persona agregarPersona() throws ParseException{
        //Extrer datos del formulario
        HashMap<String,String> datosFormulario = this.extraerDatosFormulario();
        //Validar datos del videojuego //Puede existir clase validaciones
        List<String> erroresVaidacion = this.validarDatosFormulario(datosFormulario);
        if(!erroresVaidacion.isEmpty()){
            this.mostrarErroresValidacion(erroresVaidacion);
//            return persona;
        }
        
        
         String rfc = datosFormulario.get("rfc");
         String nombre = datosFormulario.get("nombre");
         String apellidoP = datosFormulario.get("apellidoP");
         String apellidoM = datosFormulario.get("apellidoM");
         Date fechaNa = new SimpleDateFormat("yyyy-MM-dd").parse(datosFormulario.get("fechaNa"));
         String telefono = datosFormulario.get("numTelefono");
         
         Persona persona = new Persona(rfc, nombre , apellidoP, apellidoM, fechaNa, telefono);

         return persona;
    }
    
    private void mostrarErroresValidacion(List<String> erroresVaidacion){
        //Nos va a concatenar los errores y nos pondra un enter
        String mensaje = String.join("\n", erroresVaidacion);
        JOptionPane.showMessageDialog(this, mensaje, "Errores de validacion", JOptionPane.WARNING_MESSAGE);
    }
    
    //Poner en variables individuales lo que estaba en las cajas
    //De texto
    //Uso de diccionarios, con llaves y values, asi el dia que esto cambie
    //Sea mas solido
    private HashMap<String,String> extraerDatosFormulario(){
        String nombre = txtNombre.getText();
        String apellidoP = txtApellidoP.getText();
        String apellidoM = txtApellidoM.getText();
        String rfc = txtRfc.getText();
        Date fechaNa = txtFechaNa.getDate();
        //Transformar numero de telefono a numero
        String numTelefono = txtNumT.getText();
        //Primero es mejor guardarlo en String, validarlo y luego convertirlo a int
//        String precio = this.jTextField2.getText();
        // Crear instancia de SimpleDateFormat con el formato deseado
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Convertir fecha a String con el formato deseado
        String fechaNaString = dateFormat.format(fechaNa);
        
        //Diciendole llave y valor de cada llave
        HashMap<String,String> datosFormulario = new HashMap<>();
        datosFormulario.put("nombre", nombre);
        datosFormulario.put("apellidoP", apellidoP);
        datosFormulario.put("apellidoM", apellidoM);
        datosFormulario.put("rfc", rfc);
        datosFormulario.put("fechaNa", fechaNaString);
        datosFormulario.put("numTelefono", numTelefono);
        
        //Estos datos se extraen como strings y posteriormente se validan
        return datosFormulario;
    }
    
//    //Es mejor hacer un metodo de validar por cada uno de los datos del hashmap
    private List<String> validarDatosFormulario(HashMap<String, String> datosFormulario){
        
        List<String> erroresValidacion = new LinkedList<>();
        String nombre = datosFormulario.get("nombre");
        String apellidoP = datosFormulario.get("apellidoP");
        String apellidoM = datosFormulario.get("apellidoM");
        String rfc = datosFormulario.get("rfc");
        String fechaNa = datosFormulario.get("fechaNa");
        String numTelefono = datosFormulario.get("numTelefono");
        
        if(Validaciones.esTextoVacio(nombre)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(nombre,50)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
        
        
        if(Validaciones.esTextoVacio(apellidoP)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(apellidoP,50)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
        
        if(Validaciones.esTextoVacio(apellidoM)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(apellidoM,50)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
        
        if(Validaciones.esTextoVacio(rfc)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(rfc,50)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
        
        if(Validaciones.esTextoVacio(fechaNa)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(fechaNa,50)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
        
        if(Validaciones.esTextoVacio(numTelefono)){
            erroresValidacion.add("Un campo esta vacio");
        }
        if(Validaciones.excedeLimite(numTelefono,10)){
            erroresValidacion.add("Un campo excede el limite de caracteres");
        }
//        String numeroT = datosFormulario.get("precio");
//         if(ValidadorDatos.esEntero(precio)){
//            erroresValidacion.add("El precio no es numero entero");
//        }
//         
         return erroresValidacion;
    }
    
    public String buscarRfc(String rfc){
        //NO DEJAR QUE EL TXT SE PERMITAN ESCRIBIR CARACTERES NO ESPECIFICADOS FALTA
        //FORZAR AL USUARIO ESCRIBIR 13 CARACTERES LISTO
        txtRfc.getText();

        return rfc;
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
        txtNumT = new javax.swing.JTextField();
        txtFechaNa = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtRfc = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumT.setBorder(null);
        jPanel1.add(txtNumT, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 190, 30));
        jPanel1.add(txtFechaNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 200, 30));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 30));

        txtApellidoP.setBorder(null);
        jPanel1.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, 30));

        txtRfc.setBorder(null);
        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });
        jPanel1.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 190, 30));

        txtApellidoM.setBorder(null);
        txtApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 190, 30));

        btnSiguiente.setBorder(null);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 50, 40));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 20));

        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 200, 40));

        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Registro Personas (2).png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 650));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String rfc = txtRfc.getText();
       String numTelefono = txtNumT.getText();
       Validaciones val = new Validaciones();
       PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> persona = personaDAO.buscarRfc(txtRfc.getText());
        
        if(txtRfc.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellidoM.getText().isEmpty() || txtApellidoP.getText().isEmpty() || txtFechaNa.getDate() == null
         || txtNumT.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Error: Existen campos vacios");
           
       }else if(txtFechaNa.getDate().after(new Date())){
           JOptionPane.showMessageDialog(this, "Ingrese una fecha valida");
       }else if(!Validaciones.validarRFC(rfc)){
           JOptionPane.showMessageDialog(this, "Error: RFC en formato NO valido");
       }else if(!persona.isEmpty()){
           JOptionPane.showMessageDialog(this, "RFC repetido, ingrese otro");
       }else if(!Validaciones.validarTelefono(numTelefono)){
         JOptionPane.showMessageDialog(this, "Telefono escrito en un formato NO valido");
       }else{
           try {
            //Crear objeto Persona
            personaDAO.crearPersona(this.agregarPersona());
        } catch (ParseException ex) {
            Logger.getLogger(FrmRegistroPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
//        control.guardar(nombreM, raza, color,observaciones,alergico,atencion, 
//                nombreD, celular);
        
        val.mostrarMensaje("Se guardo exitosamente", "Info", "Guardado Correctamente");
       }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         this.setVisible(false);
         FrmSeleccionTramite seleccion = new FrmSeleccionTramite();
         seleccion.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int si_no=  JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar este trámite?","Cancelar", JOptionPane.YES_NO_OPTION);
        
        if(si_no == 1){
            
            this.setVisible(true);
           
            
        }else if(si_no == 0){
             JOptionPane.showMessageDialog(this, "Esta opción lo regresara al menú principal");
            
            this.setVisible(false);
            FrmMenu menu= new FrmMenu();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
         if (!buscarRfc(txtRfc.getText()).isEmpty()) {

                PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(txtRfc.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                    this.setVisible(false);
                    FrmLicencia licencia = new FrmLicencia(persona.get(0));
                    licencia.setVisible(true);
                    this.dispose();
                 }

            }
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMActionPerformed

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmRegistroPersona().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private com.toedter.calendar.JDateChooser txtFechaNa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumT;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
