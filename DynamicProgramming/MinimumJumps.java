package DynamicProgramming;
/*
 * Min Array Jumps
 * ===============
 * 
 * Given int arr[] = 2,3,1,1,4 
 * min jumps = 2
 * 
 * Implementation
 * ==============
 * 1) Make Table (of 1d array of size n)
 * 
 * 2)Assign meaning + do initialization to table
 * (intialize with -1 and meaning is we can perform 2 number of steps from 0 index from above example)
 * 
 * 3)Bottom Up
 * small prblm -> large problm
 * 
 * Approach
 * =======
 * 
 * for(int i=n-2 to 0)
 *   int steps = arr[i] , ans = Postive infinity
 *   for(int j=i+1;j<=i+steps && j<n;j++)
 *      if(dp[j] != -1)
 *         ans = min(ans,dp[j]+1)
 *   dp[i] = ans if != potive infy
 * 
 */
import java.util.*;
public class MinimumJumps {
    public static int minJumps(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps;j++){
                if(dp[j] != -1){
                    ans = Math.min(ans,dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        print(dp);
        return dp[0];
    }
    public static void print(int dp[]){
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println("Minimum Jumps = "+minJumps(nums));
    }
}
