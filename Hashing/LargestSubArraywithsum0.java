package Hashing;
/*
 * Largest sub Arrau=y eith sum zero
 */
import java.util.*;
public class LargestSubArraywithsum0 {
    public static void main(String[] args) { //O(n)
        int arr[] = {15,-2,2,-8,1,7,10,23};

        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,idx)

        int sum = 0;
        int len = 0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len,i-map.get(sum));
            } else{
                map.put(sum,i);
            }
        }

        System.out.println("largest size is = "+len);
    }
}
