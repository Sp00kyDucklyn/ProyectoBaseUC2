/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.TramiteDAO;
import dao.VehiculoDAO;
import dominio.Persona;
import dominio.Vehiculo;
import interfaces.IVehiculoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import utileria.Validaciones;

/**
 * Pantalla de vehiculo
 * @author xfs85
 */
public class FrmRegistroVehiculo extends javax.swing.JFrame {
/**
 * vehiculoDAO
 */
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    /**
     * ¨persona
     */
    private Persona persona;
    /**
     * vehiculo
     */
    private Vehiculo vehiculo;

    /**
     * Metodo constructor que recibe una persona
     * @param persona persona que hace el registro
     */
    public FrmRegistroVehiculo(Persona persona) {
        this.persona = persona;
        initComponents();
        
    }
/**
 * Metodo que agrega vehiculos
 * @return vehiculo
 * @throws ParseException exception
 */
    public Vehiculo agregarVehiculo() throws ParseException {
        //Extrer datos del formulario
        HashMap<String, String> datosFormulario = this.extraerDatosFormulario();
        //Validar datos del vehiculo //Puede existir clase validaciones
        List<String> erroresValidacion = this.validarDatosFormulario(datosFormulario);
        if (!erroresValidacion.isEmpty()) {
            this.mostrarErroresValidacion(erroresValidacion);
//            return;
        }

        String numSerie = datosFormulario.get("numSerie");
        String marca = datosFormulario.get("marca");
        String linea = datosFormulario.get("linea");
        String color = datosFormulario.get("color");
        String anio = datosFormulario.get("anio");

        Vehiculo vehiculo = new Vehiculo(numSerie, marca, linea, color, anio, persona);

        return vehiculo;
    }
/**
 * Metodo que muestra los errores de validacion
 * @param erroresValidacion errores de validacion
 */
    private void mostrarErroresValidacion(List<String> erroresValidacion) {
        //Nos va a concatenar los errores y nos pondra un enter
        String mensaje = String.join("\n", erroresValidacion);
        JOptionPane.showMessageDialog(this, mensaje, "Errores de validacion", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Metodo que extrae los datos del form
     * @return datos del formulario
     */
    private HashMap<String, String> extraerDatosFormulario() {
        String numSerie = txtNumSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        String anio = txtAnio.getText();

        //Diciendole llave y valor de cada llave
        HashMap<String, String> datosFormulario = new HashMap<>();
        datosFormulario.put("numSerie", numSerie);
        datosFormulario.put("marca", marca);
        datosFormulario.put("linea", linea);
        datosFormulario.put("color", color);
        datosFormulario.put("anio", anio);

        //Estos datos se extraen como strings y posteriormente se validan
        return datosFormulario;
    }

    /**
     * Metodo que valida los datos del formulario
     * @param datosFormulario datos del formulario
     * @return errores de validacion
     */
    private List<String> validarDatosFormulario(HashMap<String, String> datosFormulario) {

        List<String> erroresValidacion = new LinkedList<>();
        String numSerie = datosFormulario.get("numSerie");
        if (Validaciones.esTextoVacio(numSerie)) {
            erroresValidacion.add("El numero de serie esta vacio");
        }

        if (!Validaciones.validarCadena(numSerie)) {
            erroresValidacion.add("El numero de serie no cumple el formato correcto");
        }

        return erroresValidacion;

    }
    /**
     * Metodo que verifica el numero de serie
     * @param numSerie numero de serie
     * @return nimero de serie
     */
       private String buscarNumSerie(String numSerie) {
        txtNumSerie.getText();
        return numSerie;
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
        btnSiguiente = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        btnRegresoSeleccionTramite = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));
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
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 200, 30));

        txtLinea.setToolTipText("");
        txtLinea.setBorder(null);
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 332, 200, 30));

        txtAnio.setBorder(null);
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 422, 200, 30));

        txtColor.setBorder(null);
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 422, 190, 30));

        btnSiguiente.setBorder(null);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 570, 50, 40));

        botonGuardar.setBorder(null);
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 170, 30));

        botonCancelar.setBorder(null);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 180, 30));

        btnRegresoSeleccionTramite.setBorder(null);
        btnRegresoSeleccionTramite.setContentAreaFilled(false);
        btnRegresoSeleccionTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresoSeleccionTramiteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresoSeleccionTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 40, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/SiPlaca.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -19, 1010, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * numSerietxt
 * @param evt 
 */
    private void txtNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSerieActionPerformed
/**
 * marcatxt
 * @param evt evt 
 */
    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed
/**
 * guardar btn
 * @param evt evt
 */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
       
        List<String> erroresValidacion = new LinkedList<>();
        List<Vehiculo> vehiculos = vehiculoDAO.buscarNumSerie(txtNumSerie.getText());
        String numSerie = txtNumSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        String anio = txtAnio.getText();
        Validaciones val = new Validaciones();
        TramiteDAO tdao = new TramiteDAO();
        VehiculoDAO vdao = new VehiculoDAO();
        if (Validaciones.esTextoVacio(numSerie) || !Validaciones.validarCadena(numSerie)) {
            JOptionPane.showMessageDialog(this, "El numero de serie no cumple con el formato correcto");

        } else if(Validaciones.esTextoVacio(marca)|| Validaciones.esTextoVacio(linea) || Validaciones.esTextoVacio(color)||
          Validaciones.esTextoVacio(anio)){
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        } else if(vehiculos.isEmpty()){
            try {
                vehiculoDAO.crearVehiculo(this.agregarVehiculo());
            } catch (ParseException ex) {
                Logger.getLogger(FrmRegistroVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            val.mostrarMensaje("Se agrego exitosamente", "Info", "Guardado Correctamente ");
        }else {
          JOptionPane.showMessageDialog(this, "Numero de serie existente, ingrese otro");
        }

    }//GEN-LAST:event_botonGuardarActionPerformed
/**
 * cancelar
 * @param evt evt
 */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        FrmSeleccionTramite seleccion = new FrmSeleccionTramite();
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
/**
 * btnSiguiente
 * @param evt evt
 */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
//<<<<<<< HEAD:PruebaP/src/main/java/pantallas/FrmRegistroVehiculo.java
//        this.setVisible(false);
//        FrmPlaca placa = new FrmPlaca(persona);
//        placa.setVisible(true);
//        this.dispose();
//=======
        if (!buscarNumSerie(txtNumSerie.getText()).isEmpty()) {
            IVehiculoDAO vehiculoDAO = new VehiculoDAO();

            List<Vehiculo> vehiculos = vehiculoDAO.buscarNumSerie(txtNumSerie.getText());
            if (vehiculos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No encontro el numero de serie");
            } else {
                JOptionPane.showMessageDialog(this, "Se encontro el numero de serie");
                this.setVisible(false);
                FrmPlaca placa = new FrmPlaca("agregar",vehiculos.get(0));
                placa.setVisible(true);
                this.dispose();
            }
        }

//>>>>>>> main:PruebaP/src/main/java/pantallas/SiPlaca.java
    }//GEN-LAST:event_btnSiguienteActionPerformed
/**
 * btnRegreso
 * @param evt evt
 */
    private void btnRegresoSeleccionTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresoSeleccionTramiteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        FrmSeleccionTramite seleccion = new FrmSeleccionTramite();
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresoSeleccionTramiteActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton btnRegresoSeleccionTramite;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables

 
}
