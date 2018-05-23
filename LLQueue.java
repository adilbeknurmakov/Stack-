/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author Адильбек
 */
public class LLQueue<T> implements Queue<T> {
    private int size=0;
   private  Node<T> back, front;
   public LLQueue(){
       size=0;
       back,front=null;
   }
    
    
    
}
