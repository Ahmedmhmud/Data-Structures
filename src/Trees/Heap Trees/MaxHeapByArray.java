package com.mycompany.data.structures;

public class MaxHeapByArray <T extends Comparable<T>> {
    private T[] arr;
    private int size;
    private int capacity;
    
    public MaxHeapByArray(int capacity){
        this.arr = (T[]) new Comparable[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    
    public void swap(int x, int y){
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public T peek(){
        if(isEmpty()){
            return null;
        }
        
        return arr[0];
    }
    
    public void percolateDown(int index){
        int leftChild = 2 * index + 1;
        while(leftChild < size){
            int comparing = leftChild;
            if(leftChild + 1 < size){
                if(arr[leftChild].compareTo(arr[leftChild + 1]) < 0)
                    comparing = leftChild + 1;
            }
            
            if(arr[index].compareTo(arr[comparing]) < 0){
                swap(index, comparing);
                index = comparing;
                leftChild = 2*index + 1;
            }else{
                break;
            }
            
        }
    }
    
    public void percolateUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;
            if(arr[parent].compareTo(arr[index]) < 0){
                swap(index, parent);
                index = parent;
            }else{
                break;
            }
        }
    }
    
    public void insert(T item){
        if(isFull()){
            System.out.println("Heap is full!!!");
            return;
        }
        
        arr[size] = item;
        this.percolateUp(size);
        size++;
    }
    
    public void delete(int index){
        if(isEmpty()){
            return;
        }
    
        arr[index] = arr[size - 1];
        size--;
    
        if(index < size){
            int parent = (index - 1) / 2;
            if(arr[index].compareTo(arr[parent]) > 0){
                percolateUp(index);
            } else {
                percolateDown(index);
            }
        }
    }
    
    public T extractRoot(){
        if(isEmpty()){
            return null;
        }
        
        T temp = arr[0];
        delete(0);
        return temp;
    }
    
    public static <T extends Comparable<T>> MaxHeapByArray heapify(T[] array){
        MaxHeapByArray<T> tree = new MaxHeapByArray<>(array.length);
        for (T item : array) {
            tree.insert(item);
        }
        return tree;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Tree: []";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Tree: [");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
