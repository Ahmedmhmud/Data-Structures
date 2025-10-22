package com.mycompany.data.structures;

public class StackByList<T> extends MyAbstractStack<T> {
    private List<T> l;
    
    public StackByList(){
        this.l = new List();
    }
    
    public StackByList(int capacity){
        this.l = new List(capacity);
    }
    
    @Override
    public int getSize(){
        return l.getSize();
    }
    
    @Override
    public void push(T item){
        l.append(item);
    }
    
    @Override
    public T pop(){
        T temp = this.top();
        l.deleteByIndex(l.getSize() - 1);
        return temp;
    }
    
    @Override
    public T top(){
        if(isEmpty()){
            return null;
        }
        return l.getItem(l.getSize() - 1);
    }
    
    @Override
    public void clear(){
        l.clear();
    }
    
    @Override
    public boolean isEmpty(){
        return l.isEmpty();
    }

    @Override
    public String toString(){
        if(isEmpty()){
            return "Stack: []";
        }
        return l.toString().replace("List:", "Stack:");
    }
}
