package com.mycompany.data.structures;

public class DoublyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> head;
    
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        private Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public DoublyLinkedList(){
        head = null;
        size = 0;
    }
    
    public DoublyLinkedList(T data){
        head = new Node(data);
        size = 1;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public void add(T data, int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        
        Node<T> newNode = new Node(data);
        if(index == 0){
            newNode.next = head;
            if(head != null)
                head.prev = newNode;
            head = newNode;
        }else{
            Node<T> curr = head;
            for(int i = 0; i < index-1; i++)
                curr = curr.next;
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next = newNode;
            if(newNode.next != null)
                newNode.next.prev = newNode;
        }
        
        size++;
    }
    
    @Override
    public void append(T data){
        if(head == null){
            head = new Node(data);
        }else{
            Node<T> newNode = new Node(data);
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        
        size++;
    }
    
    @Override
    public void set(T item, int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index "+ index);
        
        Node<T> curr = head;
        for(int i = 0; i < index; i++)
            curr = curr.next;
        curr.data = item;
    }
    
    
    
    @Override
    public void deleteByIndex(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        
        if(index == 0){
            head = head.next;
            head.prev = null;
        }else{
            Node<T> curr = head;
            for(int i = 0; i < index-1; i++)
                curr = curr.next;
            if(curr.next.next != null){
                curr.next.next.prev = curr;
            }
            curr.next = curr.next.next;
        }
        
        size--;
    }
    
    @Override
    public void deleteByValue(T item){
        int index = isExist(item);
        if(index == -1){
            System.out.println("Element doesn't exist");
            return;
        }
        
        while(index != -1){
            deleteByIndex(index);
            index = isExist(item);
        }
    }
    
    @Override
    public T getItem(int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index " + index);
        
        Node<T> curr = head;
        for(int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }
    
    @Override
    public boolean isEmpty(){
        return head == null;
    }
    
    @Override
    public int isExist(T item){
        if(head == null)
            return -1;
        
        Node<T> curr = head;
        for(int i = 0; curr != null; i++){
            if(curr.data.equals(item))
                return i;
            curr = curr.next;
        }
        
        return -1;
    }
    
    public void clear(){
        head = null;
        size = 0;
    }
    
    public boolean contains(T item){
        return isExist(item) != -1;
    }
    
    public void display(){
        if(head == null){
            System.out.println("List is empty");
        } else{
            Node<T> curr = head;
            System.out.print("List from start: ");
            while(curr.next != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println(curr.data);
            
            System.out.print("List from end: ");
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.prev;
            }
            System.out.println();
        }
    }
    
    @Override
    public String toString(){
        if(head == null){
            return "List: []";
        }
        
        String s = "List: [";
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
