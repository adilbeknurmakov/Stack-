/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Адильбек, adeka Tawit
 */
public class TreeTest {

    public static void main(String[] args) {

        Set<Student> students = new BSTSet();

        students.add(new Student("Mark", 123423));
        students.add(new Student("Bob", 223423));
        students.add(new Student("Jim", 3234));
        students.add(new Student("Dave", 43242));
        students.add(new Student("Richard", 5));
        students.add(new Student("Richard", 5));
        students.add(new Student("Bob", 223429));

        /*System.out.println(students.contains(new Student("Ulugbek", 556456)));
        System.out.println(students.contains(new Student("Bob", 223429)));
        */
        System.out.println(students);
        
        students.remove(new Student("Richard", 5));
        
        System.out.println(students);
        
        try {
            System.out.println(students.removeAny());
        } catch (Exception ex) {
            Logger.getLogger(TreeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(students);
    }

}
