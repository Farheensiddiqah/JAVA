package DynamicProgramming;
/*
 * Some Basics Things about Recursion
 * ==================================
 * case 1 = Min,max,Largest,samllest--(Comparision)
 * case 2 = Count,sum,ways,total ways,all ways (Sum)
 * 
 * Coin Change
 * ===========
 * --> Variation of Unbounded knapsack
 * 
 * coins[] = [1,2,3]
 * sum = 4
 * {1,1,1,1}{1,1,2}{2,2}{1,3}
 * 
 * coins[] = [2,5,3,6]
 * sum = 10
 * {2,2,2,2,2}{2,2,3,3}{2,2,6}{2,3,5}and{5,5}
 * 
 * Appraoch 
 * ========
 * -> same as unbounded knapsack 2d array
 * -> create an 2d array 
 * where
 *     (i,j)==
 *      i coins \
 *               ----> no of ways?
 *      j coins/
 * 
 * --> code is almost same as unbounded knapsack
 * the only difference is in( valid case-->include profit case -> dont add value again)
 * just because here we dont want maxprofit we want just no of ways
 */
public class CoinChange_Knapsack { //Tc==O(n*W)
    public static int coinChangeKnapsack(int coins[],int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        //initialize - sum is 0
        //i->coins; j--> sum/change
        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<sum+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){ //include(Valid)
                    int includeSum = dp[i][j-coins[i-1]];
                    int excludeSum = dp[i-1][j];
                    dp[i][j] = includeSum+excludeSum;
                }//inValid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
   public static void main(String[] args) {
    int coins[] =  {1,2,3}; //sum =4
    // int coins[] = {2,5,3,6}; //sum = 10
    int sum = 4;
    System.out.println(coinChangeKnapsack(coins, sum));
   } 
}

// class Solution {
//     public long count(int coins[], int n, int sum) {
        
//         long dp[] = new long[sum+1];
//         dp[0] = 1;
        
//         for(int i = 0; i< n; i++) {
//             for(int j = coins[i]; j <= sum; j++) {
//                 dp[j] = dp[j] + dp[j - coins[i]];
//             }
//         }
//         return dp[sum];
//     }
// }


