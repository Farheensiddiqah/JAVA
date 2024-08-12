package Hashing;
import java.util.*;
/*
 * HASHING QUESTIONSQuestion 1 :
 * Question 2 :Two Sum Given an array of integers arr[] and an integer 
 * target,return indices of the two numbers such that they add up to 
 * target.Youmayassumethateachinputwouldhaveexactlyonesolution,andyoumay 
 * not use the same element twice.You can return the answer in any order.
 * Sample Input 1: arr = [2, 7, 11, 15], target = 9 Sample Output 1: [0, 1]
 * As arr[0] + arr[1] == 9, we return [0, 1].
 * Sample Input 2: arr = [3,2,4], target = 6 Sample Output 2: [1, 2]
 */
public class TwoSum {
    public static void main(String[] args) {
        // int arr[] = {2,7,11,15};
        int  arr[] = {3,2,4};
        int target = 6;

        HashMap<Integer,Integer> hm = new HashMap<>();

        int sum = 0;

        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],i);
        }
        for(int j=0;j<arr.length;j++){
            sum = Math.abs(target-arr[j]);
            if(hm.containsKey(sum) && (sum != arr[j]  && hm.get(sum)!=j)){
                System.out.println(j+" "+hm.get(sum));
                break;
            }
        }
    }
}
