package com.mycompany.data.structures;

public abstract class MyAbstractStack<T> {
    abstract public int getSize();
    abstract public void push(T item);
    abstract public T pop();
    abstract public T top();
    abstract public void clear();
    abstract public boolean isEmpty();
    @Override
    abstract public String toString();
}
