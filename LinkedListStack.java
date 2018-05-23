/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author  Adilbek Nurmakov & Ulugbek Adilbekov
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Ulugbek 'algiz' Adilbekov, Adilbek 'adilbek' Nurmakov
 */
public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        Node<T> nTop = new Node<T>(value);
        nTop.setLink(top);
        top = nTop;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if(size == 0)throw new Exception("No! 0 elements in here");
        Node<T> noMore = top;
        top = top.getLink();
        size--;
        return noMore.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    public String toString(){
        String ans = "";
        Node<T> cur;
        cur = top;
        while(cur!=null){
            ans+=cur.getValue() + " ";
            cur = cur.getLink();
        }
        return ans;
    }
    
}
