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
public class ArrayStack<T> implements StackInterface<T> {
    private int topIndex;
    private T[] stack;
    private static final int initialCapacity = 50;
    
    public ArrayStack(){
        this(initialCapacity);
    }
    
    public ArrayStack(int initialCapacity){
        stack =(T[]) new Object[initialCapacity];
        topIndex = -1;
    }
    
    public void push(T newEntry){
        topIndex++;
        
        if (topIndex >= stack.length){
            doubleArray();
        }
        stack[topIndex] = newEntry;
    }
    
    public T pop(){
        T top = null;
        
        if (!isEmpty()){
            top = stack[topIndex]; //retrieve the data
            stack[topIndex] = null; //delete the top data
            topIndex--; //decrement the topindex
        }
        
        return top;
    }
    
    public T peek(){
        T top = null;
        
        if (!isEmpty()){
            top = stack[topIndex]; //retrieve the top
        }
        
        return top;
    }
    
    public boolean isEmpty(){
        return topIndex < 0;
    }
    
    public void clear(){
        topIndex = -1;
    }
    
    public void doubleArray(){
        T[] oldStack = stack;
        int oldSize = oldStack.length;
        
        stack = (T[]) new Object[oldSize * 2];
        
        System.arraycopy(oldStack, 0, stack, 0, oldSize);
    }
    
    
}
