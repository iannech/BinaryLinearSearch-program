/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Korir
 * 
 * Details
 * This is a class that receives the first name from the main UI and passes it
 * on to the search algorithm depending on which type of search is needed,
 * be it binary or linear.
 */
public class SearchContact {
    private String fName;
    private String searchType;
    private long startTime;
    private long endTime;

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    
    /**
     *
     * @return
     */
    public PersonModel Search(){
        
        PersonModel personFound = null;
        /**
         * connect to db
         */        
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactsdb", "root", "");
   
        }
        /**
         * Catch any error that occurs
         */
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error Message: "+e.getMessage()
                    + "", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        
        /**
             * Load Data from the db into an ArrayList with the Model class as the datatype
             */
            ArrayList<PersonModel> person=Person();
      
            /**
             * Send the array to the appropriate sorting algorithm class.
             */
            switch (this.searchType) {
                case "Linear":
                    LinearSearch ln=new LinearSearch();
                    ln.setPerson(person);
                    ln.setKey(fName);
                    /**
                     * Log the start time and end time
                     */
                    setStartTime(System.nanoTime());
                    int index=ln.LinearSearch();
                    setEndTime(System.nanoTime());

                    
                    /**
                     * The person found is then assigned to the personModel personFound.
                     */
           
                    personFound=person.get(index);
                    
                    break;
                case "Binary":
                    /**
                    * Sort the ArrayList using the MyComp comparator class based on first name
                    * This will allow us to implement binary search
                    */           
                   Collections.sort(person, new MyComp());
                   BinarySearch bs=new BinarySearch();
                   bs.setKey(fName);
                   bs.setPerson(person);
                   
                   /**
                     * Log the start time and end time
                     */
                    setStartTime(System.nanoTime());
                    int index2=bs.BinarySearch();
                    setEndTime(System.nanoTime());
                   
                     personFound=person.get(index2);
                    break;
                
            }
            return personFound;            
    }
    
    /**
     * An method that will read all values from the database and store them in an
     * ArrayList
     * @return 
     */
    private ArrayList<PersonModel> Person(){
        /**
         * connect to db
         */        
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactsdb", "root", "");
            /**
             * Create an ArrayList to hold the data
             */
            ArrayList<PersonModel> person=new ArrayList<>();
            Statement stmt=con.createStatement();
            ResultSet rset=stmt.executeQuery("SELECT * FROM contacts");
            while(rset.next()){
                
                person.add(new PersonModel(rset.getString("first_name"), rset.getString("last_name"),
                rset.getString("phone"), rset.getString("email"), rset.getString("physical_address")));
            }
            /**
             * Close the Connection and ResultSet.
             */
            con.close();
            rset.close();
            
            return person;
        }
        catch(Exception e){
            /**
             * Catch any errors that may arise
             */
              e.printStackTrace();
        }
        return null;
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    
}
