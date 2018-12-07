/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Tarc
 */
public class ArrayQueue<T> implements QueueInterface<T>  {
    private int backIndex;
    private T[] queue;
    private static final int frontIndex = 0;
    private static final int initialCapacity = 50;
    
    public ArrayQueue(){ //FIXED FRONT
        this(initialCapacity);
    }
    
    public ArrayQueue(int initialCapacity){
        queue =(T[]) new Object[initialCapacity];
        backIndex = -1;
    }
    
    public void enqueue(T newEntry){
        if (isArrayFull()){
            doubleArray();
        }
        
        backIndex++; //increase the backIndex
        queue[backIndex] = newEntry; //store the data inside
    }
    
    public T dequeue(){
        T front = null;
        
        if (!isEmpty()){
            front = queue[frontIndex]; //retrieve the front data
            
            //data shifting
            for (int i = frontIndex; i<backIndex;i++){
                queue[i] = queue[i+1];
            }
            backIndex--; //decreament the backIndex
        }
        return front;
    }
    
    public T getFront(){
        T front = null;
        
        if (!isEmpty()){
            front = queue[frontIndex];
        }
        
        return front;
    }
    
    public boolean isEmpty(){
        return backIndex == -1;
    }
    
    public void clear(){
        backIndex = -1;
    }
    
    private boolean isArrayFull(){
        return backIndex == queue.length - 1;
    }
    
    public void doubleArray(){
        T[] oldqueue = queue;
        int oldsize = oldqueue.length;
        queue = (T[])new Object[oldsize * 2];
        System.arraycopy(oldqueue, 0 , queue, 0, oldsize);
    }
}
