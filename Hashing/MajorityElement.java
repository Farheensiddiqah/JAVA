package Hashing;
import java.util.*;
/*
 * Majority Element
 * ================
 * Given an integer array of size n,find all the elements that appear
 * more than [n/3] times.
 * 
 * nums[] = {1,3,2,5,1,3,1,5,1}
 * output = 1
 * 
 * nums[] = {1,2}
 * output = 1,2
 * 
 */
public class MajorityElement {
    public static void main(String[] args) {
        // int arr[] = {1,3,2,5,1,3,1,5,1};
        int arr[] = {1,2};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            } else{
                hm.put(num,1);
            }
            //The above conditions can also be written as
            //hm.put(arr[i], hm.getOrDefault(arr[i],0)+1); (// 0 as default value)

            if(hm.get(num)>(arr.length)/3){
                System.out.println(num);
            }
        }

        //or can print in this way
        // Set<Integer> keySet = hm.keySet();
        // for(Integer key : keySet){
        //     if(hm.get(key) > arr.length/3){
        //         System.out.println(key);
        //     }
        // }
    }
}
