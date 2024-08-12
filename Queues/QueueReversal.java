package Queues;
import java.util.*;
public class QueueReversal {
    public static void QueueReverseByStack(Queue<Integer>q,Stack<Integer> s){
        while(!q.isEmpty()){
            s.push(q.peek());
            q.remove();
        }

        while(!s.isEmpty()){
            q.add(s.peek());
            s.pop();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        QueueReverseByStack(q,s);

        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
