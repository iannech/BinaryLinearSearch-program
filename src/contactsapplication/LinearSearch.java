/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsapplication;

import java.util.ArrayList;

/**
 *
 * @author Kevin Korir
 */
public class LinearSearch {
    private ArrayList<PersonModel> person;
    private String key;

    /**
     * @param person the person to set
     */
    public void setPerson(ArrayList<PersonModel> person) {
        this.person = person;
    }

    
    
    /**
     * Implement the binary search algorithm based on the fields above
     */
    public int LinearSearch(){
        int size=person.size();
        
        for(int i=0; i<size; i++){
            if(person.get(i).getFirstName().compareTo(key)==0){
               return i; 
            }
        }
        return -1;
        
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
}
