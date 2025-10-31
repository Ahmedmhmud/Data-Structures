package com.mycompany.data.structures;

public class QueueByList<T> extends MyAbstractQueue<T>{
    private T []arr;
    private int front;
    private int back;
    private int capacity;
    
    public QueueByList(){
        capacity = 10;
        arr =(T[]) new Object[capacity];
        size = 0;
        front = 0;
        back = 0;
    }
    
    public QueueByList(int capacity){
        arr =(T[]) new Object[capacity+1];
        size = 0;
        front = 0;
        back = 0;
        this.capacity = capacity+1;
    }
    
    @Override
    public int getSize(){
        return this.size;
    }
    
    @Override
    public void enqueue(T data){
        if(isFull()){
            throw new IllegalStateException("The queue is full");
        }
        
        arr[back%capacity] = data;
        size++;
        back = (back+1) % capacity;
    }
    
    @Override
    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty");
        }
        
        T temp = arr[front];
        front = (front+1) % capacity;
        size--;
        return temp;
    }
    
    public boolean isFull(){
        return front == ((back+1) % capacity);
    }
    
    @Override
    public boolean isEmpty(){
        return front == back;
    }
    
    @Override
    public void clear(){
        size = 0;
        front = 0;
        back = 0;
    }
    
    @Override
    public T front(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty");
        }
        
        return arr[front];
    }
    
    @Override
    public T back(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty");
        }
        
        return arr[(back-1 + capacity) % capacity];
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue: []";
        }
        String s = "Queue: [";
        for (int i = 0; i < size; i++) {
            s += (arr[i] + "");
            if (i < size - 1) s += ", ";
        }
        s += "]";
        return s;
    }
}
