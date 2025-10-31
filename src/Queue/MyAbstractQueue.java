package com.mycompany.data.structures;

abstract public class MyAbstractQueue<T> {
    protected int size;
    
    public MyAbstractQueue(){
        
    }
    
    abstract public int getSize();
    abstract public void enqueue(T data);
    abstract public T dequeue();
    abstract public boolean isEmpty();
    abstract public void clear();
    abstract public T front();
    abstract public T back();
    @Override
    abstract public String toString();
}
