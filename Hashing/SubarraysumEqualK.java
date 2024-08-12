package Hashing;
/*
 * Subarray sum equal to k
 * =======================
 * return number of such subarrays
 * 
 * arr = {1,2,3} k=3
 * 
 * ans = 2(1 2) (3)
 * 
 * approach == subarray ==logic ==imp
 * 
 * sum(i+1,j) = sum(o,j) - sum(0,i)--doubt
 * 
 * sum(i,j) = sum(0,j) - sum(0,i-1)
 * 
 * subarray --illustration
 * =================
 *    ans,sum(i,j)
 *   (-----)
 * --i
 * -------j
 */
import java.util.*;
public class SubarraysumEqualK {
    public static void main(String[] args) { //O(n)
        int arr[] = {10,2,-2,-20,10};
        int k= -10;

        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,count)
        map.put(0,1);

        int sum = 0;
        int ans = 0;

        for(int j=0;j<arr.length;j++){
            sum+=arr[j]; //sum(j)
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum , map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
    }
}
