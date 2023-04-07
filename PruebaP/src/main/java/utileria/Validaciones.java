/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author hoshi
 */
public class Validaciones {

    public static boolean esTextoVacio(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    //Le puedo mandar numero de caracteres que permites
    public static boolean excedeLimite(String texto, int limiteCaracteres) {
        //Siempre checar lo de los nulls
        //Se puede hacer el trim pero preferente que no
        if (texto == null || texto.length() > limiteCaracteres) {
            return true;
        }
        return false;
    }
    
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
     * @param texto
     * @return
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
    
    // Esta validación nos puede ayudar en las placas y numero de serie 
    // de un vehiculo
   public static boolean validarCadena(String cadena) {
        Pattern pattern = Pattern.compile("^[A-Za-z]{3}-[0-9]{3}$");
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    } 
    
    
}
