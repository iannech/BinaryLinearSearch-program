/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsapplication;

/**
 *
 * @author Kevin Korir
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
public class ContactsApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(() -> {
            MainFrame ui=new MainFrame();
            ui.setVisible(true);
            ui.setLocationRelativeTo(null);
        });
        
        
      
      
    }
    
}
