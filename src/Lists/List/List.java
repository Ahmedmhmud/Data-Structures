package com.mycompany.data.structures;

public class List<T> extends MyAbstractList<T>{
    private T[] arr;
    private int capacity;
    
    public List(){
        capacity = 10;
        size = 0;
        arr = (T[]) new Object[capacity];
    }
    
    public List(int capacity){
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        size = 0;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    private void expand(){
        this.capacity *= 2;    // Like C++
        T[] arr2 = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, arr2, 0, size);
        arr = arr2;
    }
    
    @Override
    public void add(T item, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        if(isFull())
            expand();
        
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }
    
    @Override
    public void append(T item){
        if(isFull()){
            expand();
        }
        
        arr[size] = item;
        size++;
    }
    
    public void set(T item, int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
            
        arr[index] = item;
    }
    
    @Override
    public void deleteByIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        for(int i = index; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
    }
    
    @Override
    public void deleteByValue(T item){
        int index = isExist(item);
        if(index == -1){
            System.out.println("Element doesn't exist");
        }
        
        while(index != -1){
            deleteByIndex(index);
            index = isExist(item);
        }
    }
    
    @Override
    public T getItem(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        return arr[index];
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    @Override
    public int isExist(T item){
        for(int i = 0; i < size; i++){
            if(arr[i].equals(item))
                return i;
        }
        return -1;
    }
    
    public boolean contains(T item){
        return isExist(item) != -1;
    }
    
    public void clear(){
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List: []";
        }
        String s = "List: [";
        for (int i = 0; i < size; i++) {
            s += (arr[i] + "");
            if (i < size - 1) s += ", ";
        }
        s += "]";
        return s;
    }
}
