package DynamicProgramming;
/*
 * Rod Cutting
 * ============
 * Given a rod of length n inches and an array of prices that 
 * includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the 
 * rod and selling the pieces.
 *  
 * length = 1 2 3 4  5  6  7  8 
 * price =  1 5 8 9 10 17 17 20
 * 
 * rod Length = 8
 * 
 * -----Approach
 * =============
 * ->same as unbounded knapsack code 
 * ->just by changing the variable names we can write same code
 *  
 */
public class RodCutting_Knapsack {
    public static int rodCuttingKnapsack(int lengths[],int price[],int rodLength){
        int n = price.length;
        int dp[][] = new int[n+1][rodLength+1];
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<rodLength+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodLength+1;j++){
                if(lengths[i-1]<=j){ //valid
                    int includerod = price[i-1]+dp[i][j-lengths[i-1]];
                    int excluderod = dp[i-1][j];
                    dp[i][j] = Math.max(includerod,excluderod);
                } else { //not valid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodLength];
    }
    public static void main(String[] args) {
        int lengths[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println(rodCuttingKnapsack(lengths, price, rodLength));
    }
}
