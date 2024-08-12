package GreedyAlgo;
/*
 * Kth largest odd number in a given range We 
 * have two variables L and R,indicating a 
 * range of integers from L to R inclusive,
 * and a number K,the task is to find Kth 
 * largest odd number.If K>number of odd 
 * numbers in the range L to R then return 0.
 * Sample Input 1: L = -3, R = 3, K = 1
 * Sample Output 1: 3
 */
import java.util.*;
public class KthLargestOddNo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int l = -3,r=3,k=1;
        for(int i=l;i<=r;i++){
            if((i%2)!=0){
                arr.add(i);
            }
        }
        Collections.sort(arr,Comparator.reverseOrder());
        // for(int i=0;i<arr.size();i++){
        //     if(i==k-1){
        //         System.out.println(arr.get(i));
        //     }
        // }
        System.out.println("Kth odd Number = "+arr.get(k-1));
    }
}
