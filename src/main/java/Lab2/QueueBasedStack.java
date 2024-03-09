package Lab2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasedStack<Data>{
    private java.util.Queue<Data> q1;
    private java.util.Queue<Data> q2;

    public QueueBasedStack(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(Data data){
        q2.add(data);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Data> temp=q1;
        q1=q2;
        q2=temp;
    }

    public Data pop(){
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.remove();
    }

    public Data peek() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
