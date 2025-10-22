package com.mycompany.data.structures;

public class StackByLinkedList<T> extends MyAbstractStack<T> {
    SinglyLinkedList<T> l;
    
    public StackByLinkedList(){
        this.l = new SinglyLinkedList();
    }

    @Override
    public int getSize() {
        return l.getSize();
    }

    @Override
    public void push(T item) {
        l.add(item, 0);
    }

    @Override
    public T pop() {
        if(l.isEmpty())
            return null;
        
        T temp = l.getItem(0);
        l.deleteByIndex(0);
        return temp;
    }

    @Override
    public T top() {
        if(l.isEmpty())
            return null;
        return l.getItem(0);
    }

    @Override
    public void clear() {
        l.clear();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public String toString() {
        if(l.isEmpty()){
            return "Stack: []";
        }
        return l.toString().replace("List", "Stack");
    }
}
