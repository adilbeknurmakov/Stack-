/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author  Adilbek Nurmakov & Ulugbek Adilbekov
 */
package csci152.impl;


import csci152.adt.Set;
import csci152.adt.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LListStackSet<T> implements Set<T>{
    private Stack<T> vals;
    
    public LListStackSet(){
        vals = new LinkedListStack(); 
    }
    
    public void add(T value) {
        if (!this.contains(value)) {
            vals.push(value);
        }
    }

    public int getSize() {
        return vals.getSize();
    }

    public void clear() {
        vals = new LinkedListStack(); 
    }
    
    public String toString(){
        return vals.toString();
    }

    @Override
    public boolean contains(T value) {
        boolean found = false;
        Stack<T> buf = new LinkedListStack();
        while(vals.getSize() > 0){
            T x;
            try {
                x = vals.pop();
                if(x.equals(value)){
                    found = true;
                }
                buf.push(x);
            } catch (Exception ex) {
                Logger.getLogger(LListStackSet.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        vals = buf;
        return found;
    }
    
    @Override
    public boolean remove(T value) {
        if(!this.contains(value))return false;
        Stack<T> buf = new LinkedListStack();
        while(vals.getSize() > 0){
            T x;
            try {
                x = vals.pop();
                if(!x.equals(value)){
                    buf.push(x);
                }
            } catch (Exception ex) {
                Logger.getLogger(LListStackSet.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        vals = buf;
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(vals.getSize() == 0)throw new Exception("kitten!");
        return vals.pop();
    }
    
}


