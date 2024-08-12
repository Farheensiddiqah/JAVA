package DynamicProgramming;
/*
 * Question 1 :Tribonacci Numbers The Tribonacci series is a generalization of the 
 * Fibonacci sequence where each term is the sum of the three preceding terms.
 * a(n) = a(n-1) + a(n-2) + a(n-3) 
 * with a(0) = a(1) = 0, a(2) = 1.
 * Input: 5
 * Output: 0, 0, 1, 1, 2
 * Input: 10
 * Output: 0, 0, 1, 1, 2, 4, 7, 13, 24, 44
 * Input: 20
 * Output: 0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149,274, 504, 927, 1705, 3136, 5768, 10609, 19513
 */
import java.util.*;
public class TribonacciNumbers {
    public static int triboci(int n){ //For nth number from 0th index
        if(n==0 || n==1){
            return 0;
        }else if(n==2){
            return 1;
        }

        return triboci(n-1)+triboci(n-2)+triboci(n-3);
    }
    public static void tribonacciByTabulation(int n){
        int dp[] = new int[n];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for(int i=3;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
    }
    public static void main(String[] args) {
        int n=20;
        System.out.println(triboci(n));
        System.out.println();
        tribonacciByTabulation(n);
    }
}
