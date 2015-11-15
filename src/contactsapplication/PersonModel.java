/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Korir
 */
public class PersonModel {
      private String firstName;
      private String lastName;
      private String phone;
      private String email;
      private String homeAddress;
      

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress the homeAddress to set
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public PersonModel(){
        
    }
    public PersonModel(String fName, String lName, String phone, String email, String physicalAddr){
        this.firstName=fName;
        this.lastName=lName;
        this.email=email;
        this.homeAddress=physicalAddr;
        this.phone=phone;
                
    }
    
    public int Add(){
          /**
           * Add the values to the database
           */
        try{
            /**
           * Make a connection to the database and add values into the respective relation
           */
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactsdb", "root", "");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO `contacts`(`first_name`, `last_name`, `phone`, `email`, `physical_address` ) VALUES ('"+firstName+"','"+lastName+"','"+phone+"','"+email+"','"+homeAddress+"')");
            JOptionPane.showMessageDialog(null, "The Contact was successfully added "
                    + "into the database", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            return 0;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Oops! Something went wrong. Error Message: "+e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
      }
      
      
}
