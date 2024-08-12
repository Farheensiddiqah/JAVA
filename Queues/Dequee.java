package Queues;

/*
 * Deque(Double ended queue)
 * which is different from dequeue-which only means deleting an element
 * --> The specality of this is here we can add from the front and from last also
 * --> and also get thr first element from front and end also
 * 
 * operations
 * ==========
 * addFirst();
 * addLast();
 * removeFirst(),removeLast();
 * getFirst();,getLast();
 */
import java.util.*;
public class Dequee {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1); //1
        deque.addFirst(2); //2 1
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque); //1
    }
}
