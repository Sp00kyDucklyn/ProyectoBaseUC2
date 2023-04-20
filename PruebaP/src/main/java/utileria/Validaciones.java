/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;

import com.mysql.cj.jdbc.Blob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Clase que se encarga de las validaciones del sistema
 * @author hoshi
 */
public class Validaciones {
/**
 * Metodo que valida si una campo de texto es vacio
 * @param texto texto a validar
 * @return Condicion en caso de que sea vacio
 */
    public static boolean esTextoVacio(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return true;
        }
        return false;
    }
/**
 * Metodo que valida si un campo de texto excede el limite de caracteres
 * @param texto texto a validar
 * @param limiteCaracteres limite de caracteres admitidos
 * @return condicion
 */
    //Le puedo mandar numero de caracteres que permites
    public static boolean excedeLimite(String texto, int limiteCaracteres) {
        //Siempre checar lo de los nulls
        //Se puede hacer el trim pero preferente que no
        if (texto == null || texto.length() > limiteCaracteres) {
            return true;
        }
        return false;
    }
    /**
     * Metodo que valida que un campo de texto cumple con el formato de fecha
     * @param texto texto a validar
     * @return condicion verdadero/falso
     */
    public static boolean esFecha(String texto){
         try {
            Date.parse(texto);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
//    public static boolean esFechaValida(){
//        
//    }

    /**
     * La chamba de este codigo es NOMAS decirme si se puede convertir a entero
     * o no, se debe hacer un metodo aparte dentro de la clase para el conversor
     * a entero
     *
     * @param texto texto a validar
     * @return true/false
     */
    public static boolean esEntero(String texto) {
        //Esto es para usar la excepcion de la clase integer
        //Si lanza la excepcion jeje
        //Si se usa expresion regular entonces usas java regex
        //Y usas una que te convenza
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
/**
 * Metodo que se encarga de mostrar un mensaje al usuario
 * @param mensaje mensaje que se mostrara al usuario
 * @param tipo tipo de mensaje
 * @param titulo titulo del mensaje
 */
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
 /**
  * Metodo que se encarga de validar que una cadena cumple el formato requerido
  * ideal para numero de serie y placas
  * @param cadena cadena a validar
  * @return matcher
  */
   public static boolean validarCadena(String cadena) {
        Pattern pattern = Pattern.compile("^[A-Za-z]{3}-[0-9]{3}$");
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    } 
   /**
    * Metodo que valida si el rfc cumple con el formato debido
    * @param rfc rfc a validar
    * @return matcher
    */
   public static boolean validarRFC(String rfc) {
    // Expresión regular para validar el formato de RFC
    Pattern pattern = Pattern.compile("^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$");
    Matcher matcher = pattern.matcher(rfc);
    return matcher.matches();
   
    }
   /**
    * Metodo que valida que un telefono cumple con el formato debido
    * @param telefono telefono a validar
    * @return matcher
    */
  public static boolean validarTelefono(String telefono) {
    // Eliminar cualquier espacio o guión que pueda haber en el número
    telefono = telefono.replace(" ", "").replace("-", "");
    // Verificar que el número tenga exactamente 10 dígitos
    if (telefono.length() != 10) {
        return false;
    }
    // Verificar que todos los caracteres del número sean dígitos
    for (int i = 0; i < telefono.length(); i++) {
        if (!Character.isDigit(telefono.charAt(i))) {
            return false;
        }
    }
    return true;
}
}
