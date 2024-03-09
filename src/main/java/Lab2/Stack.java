package Lab2;

import java.util.NoSuchElementException;

public class Stack<Data>{
    private Node<Data> top=null;
    private int size=0;

    public void push(Data data){
        Node<Data> newNode=new Node<>();
        newNode.data=data;
        newNode.next=top;
        top=newNode;
        size++;
    }

    public Data pop(){
        if(size==0){
            throw new NoSuchElementException("Stack is empty");
        }

        Data data=top.data;
        top=top.next;
        size--;
        return data;
    }

    public Data peek(){
        if(size==0){
            throw new NoSuchElementException("Stack is empty.");
        }
        return top.data;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
}
