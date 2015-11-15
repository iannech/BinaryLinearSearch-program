/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsapplication;

import java.util.Comparator;

/**
 *
 * @author Kevin Korir
 * 
 * Details
 * This class implements the Java Comparator class that takes an element in an
 * object and compares it with another element in another object and thus allowing 
 * a one to sort data based on the FirstName field. 
 */
public class MyComp implements Comparator<PersonModel> {

    @Override
    public int compare(PersonModel o1, PersonModel o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }

}
