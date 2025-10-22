package com.mycompany.data.structures;

public interface MyList<T> {
    
    public void deleteByIndex(int index);
    public void deleteByValue(T item);
    public T getItem(int index);
    public boolean isEmpty();
    public int isExist(T item);
    @Override
    public String toString();
}
