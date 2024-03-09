package Lab2;

import java.util.NoSuchElementException;

public class Queue<Data>{
    private Node<Data> head=null;
    private Node<Data> tail=null;
    private int size=0;

    public void enqueue(Data data){
        Node<Data> newNode=new Node<>();
        newNode.data=data;
        if(size==0){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public Data dequeue(){
        Data data;
        if(size==0){
            throw new NoSuchElementException("Queue is empty");
        }
        else if(size==1){
            data=head.data;
            head=tail=null;
        }
        else{
            data=head.data;
            head=head.next;
        }
        size--;
        return data;
    }

    public Data peek(){
        if(size==0){
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
}
