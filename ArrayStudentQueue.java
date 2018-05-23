/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.StudentQueue;

/**
 *
 * @author Адильбек
 */
public class ArrayStudentQueue implements StudentQueue{
private Student[] values;
private int size;
private int front;
private int back;

public ArrayStudentQueue(){
    values= new Student[5];
    size=0;
    front=0;
    back=0;
}
    @Override
    public void enqueue(Student value) {
        if(size==values.length){
            Student[] newVals=new Student[2*values.length];
            for(int j=0,k=front;j<size;j++,k=(k+1)%values.length){
                newVals[j]=values[k];}
        
        values=newVals;
        front=0;
        back=size;}
        
    values[back]=value;
    back =(back + 1)% values.length;
        size++;
    }

    @Override
    public Student dequeue() throws Exception {
        if(size==0){ throw new Exception("The stack is empty");
    }
        Student result=values[front];
        front=(front+1)%values.length;
        size--;
        return result;
    }
        

    @Override
    public int getSize() {
      return size;
    }

    @Override
    public void clear() {
        size=0;
    }
    
}
