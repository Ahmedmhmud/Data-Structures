package com.mycompany.data.structures;

public abstract class MyAbstractList<T> implements MyList<T>{
    protected int size;
    
    public MyAbstractList(){
        
    }
    
    abstract public int getSize();
    abstract public void add(T item, int index);
    abstract public void append(T item);
    abstract public void set(T item, int index);
}
