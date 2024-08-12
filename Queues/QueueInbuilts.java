package Queues;
import java.util.*;
public class QueueInbuilts {
    public static void main(String[] args) {
        //Two ways to implement they are Linked List and ArrayDeque
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
