package DynamicProgramming;
import java.util.*;
/*
 * Target sum
 * ===========
 * variation of 0-1 knapsack
 * 
 * numbers[] = [4,2,7,1,3]
 * Target sum = 10
 * ans == if found then print true else false
 * 
 * ans = n items => subset sum = target? (T/F)
 * 
 * dp(i,j) for i items =>( if subset sum = j)? (T/F)
 * 
 * eg == i=3 j = 5
 *  i = 3 (items)[4,2,7] then is equal to target = 5? (T/F) 
 * 
 *                  i th
 *                  / \
 *                 /   \
 *               valid   invalid
 *              include   exclude
 *       (arr[i-1]<=sum)
 *         /  \
 *        /    \
 *     include  exclude
 * dp[i-1][j-v]
 *  = true
 * 
 * 
 * include
 * =======
 * dp[i-1][j-1] = true
 * dp[i][j] = true
 * 
 * exclude
 * ========
 * dp[i-1][j] = true
 * dp[i][j] = true
 * 
 * 
 */
public class TargetSumSubset {
    //TC == O(n*sum)
    public static boolean targetSubset(int arr[],int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i = items j= target sum
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }   //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int numbers[] = {4,2,7,1,3};
        int targetSum = 10;
        System.out.println(targetSubset(numbers, targetSum));

    }
}
