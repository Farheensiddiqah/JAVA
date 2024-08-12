package Heaps;
/*
 * Connect N ropes
 * ================
 * Given are N ropes of different lengths, the task is 
 * to connect these ropes into one rope with minimum
 * cost,such that the cost to connect two ropes is equal to
 * the sum of their lengths
 * 
 * ropes = {4,3,2,6};
 * ans = 29
 * 
 * ans== connect 2&3(5)
 *       connect 5&4(9)
 *       connect 9&6(15)
 * 
 * 
 * If we have used greedy algo approach we would have got wrong
 * ans and priority can be more optimized and exact ans
 * beacuse== if we follow greedy approach we get ans == 43
 * for this input (int ropes[] = {2,3,3,4,6};) which is not minimum and ans
 */
import java.util.*;
public class ConnectNRopes {
    public static void main(String[] args) {
        // int ropes[] = {4,3,2,6};
        int ropes[] = {2,3,3,4,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost =0;
        while(pq.size() >1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost+=(min1+min2);
            pq.add(min1+min2);
        }

        System.out.println("Cost of N minimum connected ropes is = "+cost);
    }
}
