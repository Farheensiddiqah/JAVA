package DynamicProgramming;
/*
 *  * iii)Unbounded Knapsack
 * ======================
 * -->Here we can fill anything our wish with unlimited with in the bag
 * to get the maximum of the profit , that means any number of times
 * 
 * --> It is also a similar version of 0-1 knapsack
 * 
 * 
 * Only difference between 0-1 knapsack and unbounded knapsack
 * ===========================================================
 * -> In 0-1 Knapsack here it was like an item can be included once
 * or can be excluded by only one time to get max profit
 * 
 * --> But then here the only difference is here we can include same 
 * items also as our wish many times to get the max profit
 * 
 *--> If we observe the 2d array matrix also the every (i,j) represents

                --- i items consider 
               |                    \
 *       (i,j)-                      ---> max profit
 *             |                   /
 *             --- j size knapsack
 * 
 * 
 * 
 * ---> from the code also we will observe the diffrence 
 * 
 * 0-1 knapsack
 * =================
 *  public static int knapsackTabulation(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){ //valid
                    int incProfit = v+dp[i-1][j-w];-----> The only change here is we can include same items so dp[i][j-w]
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                } else  {
                    //exclude
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
     }
 * 
 * 
 * 
 */
public class UnboundedKnapsack {
    public static int unboundedKnapsackFun(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int [n+1][W+1];

        //intialize with 0
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1]<=j){ //valid
                    int incProfit = val[i-1]+dp[i][j-wt[i-1]];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                } //exclude
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
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
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(unboundedKnapsackFun(val, wt, W));;

    }
}
