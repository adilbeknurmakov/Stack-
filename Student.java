/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author  Adilbek Nurmakov adeka
 */
public class Student implements Comparable{
     private String name;
    private int id;
    
    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    Student(String bob, String marley, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }
     @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
          Student sobj=(Student) obj;
          return id==sobj.id && name.equals(sobj.name);
    }
        return false;
    }
    public String toString(){
        return "{" + name + ", " + id + "}";
    }
    
    @Override
    public int compareTo(Object adeka) {
        return (int) (id - ((Student)adeka).getId());
    }
}
