package DynamicProgramming;
/*
 * Minimum Partitioning(o-1 Knapsack Model concept)
 * =====================
 * numbers[] = {1,6,11,5}
 * min diff = 1
 * 
 * Explanations
 * -----------------
 * -> divide them as set1 and set2
 * where if we perform modulo also we should get minimum sum
 * 
 * {1 6 11 5}
 *     /   \
 *   set1   set2
 *   {nums}  {nums}
 *    sum1    sum2
 * 
 * |sum2-sum1|  => min 
 * 
 * Approach
 * =========
 * 1)Find total sum of given arr
 * 2)create dp[n+1][W+1]  (n=nums.length and w=sum/2)
 * 3) 0-1 Knapsack
 * 4) dp[n][w] = sum1
 *  so) sum2 = sum-sum1
 * 
 * MinDiff = |sum1-sum2|
 *     
 */
public class MinimumPartitioning {
    //TC == O(n*W)
    public static int minPartitions(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        //fill bottom Up 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1] <= j){ //valid
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                } else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int nums[] = {1,6,11,5};
        System.out.println(minPartitions(nums));
    }
}
