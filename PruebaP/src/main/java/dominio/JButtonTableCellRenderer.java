/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import pantallas.FrmPersona;

/**
 *
 * @author hoshi
 */
public class JButtonTableCellRenderer extends JButton implements TableCellRenderer{
    
    private final JButton button;
    
    public JButtonTableCellRenderer() {
        button = new JButton("Selección");
       
        button.addActionListener((ActionEvent e) -> {
            // Acción que se realiza al hacer clic en el botón
            System.out.println("popo");
        });
    }

    
    @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
      private void mostrarPantallaFrmPersona() {
        //Esta forma es mas flexible
        //this.setVisible(false);
        FrmPersona frmPersona = new FrmPersona();
        frmPersona.setVisible(true);
//        //Forma anonima de llamar al formato
//        new AgregarVideojuegoForm().setVisible(true);
    }
}
    

