package com.mycompany.data.structures;

public class QueueByLinkedList<T> extends MyAbstractQueue<T>{
    private Node<T> head;
    private Node<T> tail;
    
    private class Node<T>{
        T data;
        Node<T> next;
        
        private Node(T data){
            this.data = data;
            next = null;
        }
    }
    
    public QueueByLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public void enqueue(T data){
        if(isEmpty()){
            head = new Node<T>(data);
            tail = head;
        }else if(head == tail){
            Node<T> newNode = new Node(data);
            tail = newNode;
            head.next = tail;
        }else{
            Node<T> newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    @Override
    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty");
        }else if(head == tail){
            Node<T> temp = tail;
            tail = null;
            head = null;
            size = 0;
            return temp.data;
        }else{
            Node<T> temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
    }
    
    @Override
    public boolean isEmpty(){
        return head == null;
    }
    
    @Override
    public T front(){
        if(isEmpty())
            return null;
        return head.data;
    }
    
    @Override
    public T back(){
        if(isEmpty())
            return null;
        return tail.data;
    }
    
    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        if(head == null){
            return "Queue: []";
        }
        
        String s = "Queue: [";
        Node<T> curr = head;
        for(int i = 0; i < size; i++){
            s += (curr.data + "");
            if(i == size - 1){
                s += "]";
            }else{
                s += ", ";
            }
            curr = curr.next;
        }
            
        return s;
    }
}
