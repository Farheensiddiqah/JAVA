package Stacks;
import java.util.*;
/*
 * next greater number problem
 */
public class NextGreaterElement {
    public static void nextGreater(int arr[]){
                //Brute Force Approch
        int an = -1;
        String s= "";
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    an = arr[j];
                    break;
                }
            }
            if(an != -1){
                System.out.print(an+" ");
                an = -1;
            } else{
                System.out.print(an+" ");
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};   // -1 -1 8 8 8
        // nextGreater(arr);
        Stack<Integer> s = new Stack<>();
        int nxtGreat[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
        // for(int i=0;i<arr.length;i++){-- for next greater left
            //while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            //ifElse
            if(s.isEmpty()){
                nxtGreat[i] = -1;
            } else {
                nxtGreat[i] = arr[s.peek()];
            }
            //push in s again
            s.push(i);
        }
        for(int i=0;i<nxtGreat.length;i++){
            System.out.print(nxtGreat[i]+" ");
        }
        /*
         * this problem can be solved using 
         * next Greater Right -- this above prblm
         * next Greater Left  -- just change the for loop
         * next smaller right --- same problem just change the condition in while loop
         * next smaller left -- 1.change for loop and change the condition in while loop
         */
    }
}
