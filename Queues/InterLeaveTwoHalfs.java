package Queues;
/*
 * Interleave 2 halfs of a queue(even length)
 *  1 2 3 4 5 6 7 8 9 10
 *  1 6 2 7 3 8 4 9 5 10
 * 
 * 
 * Approch :
 * 
 *create 2 queues and store the first half of the queue
    in a different queue 
    and then now just add them by below logic
 * TC-O(n)
 */
import java.util.*;
public class InterLeaveTwoHalfs {
    public static void printInterLeave(Queue<Integer> q1){
        Queue<Integer> q2 = new LinkedList<>();
        int size = q1.size();
        int q1size = (size)/2;
        for(int i=0;i<size/2;i++){
            q2.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        printInterLeave(q1);

        while(!q1.isEmpty()){
            System.out.print(q1.remove()+" ");
        }
        System.out.println();

    }
}
