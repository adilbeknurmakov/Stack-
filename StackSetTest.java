/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author  Adilbek Nurmakov & Ulugbek Adilbekov
 */
package csci152.impl;

import csci152.adt.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Адильбек
 */
public class StackSetTest {
    public static void main(String[] args){
        
            Set<Student> students =  new LListStackSet();
            
            students.add(new Student("Mark", 123423));
            students.add(new Student("Bob", 223423));
            students.add(new Student("Jim", 3234));
            students.add(new Student("Dave", 43242));
            students.add(new Student("Richard", 5));            
            students.add(new Student("Richard", 5));            
            
            System.out.println(students);
            
            try {
            System.out.println(students.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("lalala");
            }
            System.out.println(students);
            System.out.println(students.remove(new Student("Mark",123423)));
            System.out.println(students);
            System.out.println(students.remove(new Student("Mark",1)));
    }
}

