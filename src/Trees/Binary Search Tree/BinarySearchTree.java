package com.mycompany.data.structures;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    
    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public BinarySearchTree() {
    }
    
    public BinarySearchTree(T obj){
        this.root = new Node<>(obj);
    }
    
    public boolean search(T item){
        return abstractedSearch(root, item);  // To prevent exposing the abstracted details of the BST
    }
    
    private boolean abstractedSearch(Node<T> current, T item){
        if(current == null)
            return false;
        
        if(item.compareTo(current.data) == 0){
            return true;
        } else if(item.compareTo(current.data) < 0) {
            return abstractedSearch(current.left, item);
        } else {
            return abstractedSearch(current.right, item);
        } 
    }
    
    public boolean insert(T item){
        if(root == null){
            root = new Node<>(item);
            return true;
        }
        return abstractedInsert(root, item);
    }
    
    private boolean abstractedInsert(Node<T> current, T item){
        if(item.compareTo(current.data) == 0){
            return false;
        } else if(item.compareTo(current.data) < 0) {
            if(current.left == null){
                current.left = new Node<>(item);
                return true;
            }
            return abstractedInsert(current.left, item);
        } else {
            if(current.right == null){
                current.right = new Node<>(item);
                return true;
            }
            return abstractedInsert(current.right, item);
        }
    }
    
    public boolean delete(T item){
        if(root == null){
            return false;
        }
        return abstractedDelete(null, root, item);
    }
    
    private boolean abstractedDelete(Node<T> parent, Node<T> current, T item){
        if(current == null){
            return false;
        }
        
        if(item.compareTo(current.data) == 0){
            if(current.right != null && current.left != null){
                Node<T> xSucc = current.right;
                parent = current;
                while(xSucc.left != null){
                    parent = xSucc;
                    xSucc = xSucc.left;
                }
                current.data = xSucc.data;
                current = xSucc;           
            }
            
            Node<T> subTree = current.left;
            if(subTree == null)
                subTree = current.right;
            if(parent == null){
                root = subTree;
            } else if(parent.left == current){
                parent.left = subTree;
            } else{
                parent.right = subTree;
            }
            return true;
        } else if(item.compareTo(current.data) < 0){
            return abstractedDelete(current, current.left, item);
        } else{
            return abstractedDelete(current, current.right, item);
        }
    }
    
    public void print(){
        printTree(root);
    }
    
    private void printTree(Node<T> smallTree){
        if(smallTree == null){
            return;
        }
        
        printTree(smallTree.left);
        System.out.println(smallTree.data);
        printTree(smallTree.right);
    }
}