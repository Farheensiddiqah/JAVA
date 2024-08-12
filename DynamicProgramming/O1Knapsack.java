package DynamicProgramming;
/*
 * 0-1 Knapsack
 * ============
 * Types of knapsack problems
 * i) Fractional Knapsack (Greedy)
 * ii)0-1 Knapsack
 * iii) Unbounded Knapsack
 * 
 * i) Fractional Knapsack (Greedy)
 * ===================================
 * if we have a bag to fill and list of items like pepper,salt,sugar
 * --> and told to fill 10kg of bag with maximum profit
 * then we can fill with all pepper bcz cost is more or like that
 * 
 * ii) 0-1 Knapsack
 * =================
 * if we have to take 0 and or take none
 * 
 * ->eg== if we have given a bag to fill and told to fill 10kgs
 * with the items that are not and cant be divided
 * eg == laptop,cell,mobile,tablet
 * -> so that they can be added or not
 * 
 * iii)Unbounded Knapsack
 * ======================
 * -->Here we can fill anything our wish with unlimited with in the bag
 * to get the maximum of the profit
 * 
 * 
 */

public class O1Knapsack {
    /*
     * O-1 Knapsack
     * =============
     * val[] = 15,14,10,45,30
     * wt[] = 2,5,1,3,4
     * W(total allowed weight) = 7
     * ans  = max profit
     * 
     * Approch
     * =========
     * knapsack(val[],wt[],w,idx i){
     *  //base case
     *   if(i==0 || w==0)
     *       return 0
     *   //function
     *   if(wt<=W) //valid case
     *      ->Include (W-wt,i-1)
     *      ->exclude (W,i-1)
     *      take max of (include,exclude)
     *  else // not valid
     *    -> exclude (W,i-1)
     * }
     * //n== no of items
     */
    //TC===O(2^(n))
    public static int knapsackRecursion(int val[],int wt[],int W,int n){
        //base case
        if(n==0 || W==0){
            return 0;
        }

        if(wt[n-1]<=W){ // valid
            //include
            int ans1 = val[n-1]+knapsackRecursion(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsackRecursion(val, wt, W, n-1);
            return Math.max(ans1,ans2);
        } else{ //not valid
            return knapsackRecursion(val, wt, W, n-1);
        }
    }
    //Tc=== O(n*W)
    public static int knapsackMemorization(int val[],int wt[],int W,int n,int dp[][]){
        //base case
        if(n==0 || W==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){ // valid
            int ans1 = val[n-1]+knapsackMemorization(val, wt, W-wt[n-1], n-1, dp); //include
            int ans2 = knapsackMemorization(val, wt, W, n-1, dp); //exclude
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        } else{
            dp[n][W] = knapsackMemorization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }
    /*
     * Tabulation
     * =============
     * steps== for tabulation 
     * ---------------------
     * 1.create table
     * 2. meaning assign to (i,j) and initilize
     * 3. fill (bottom up) small to large
     * 
     * after making 2d array
     * ====================
     * -> with n+1 size nad w+1 size
     * 
     * dp[][](i,j) = i-items + j(W(knapsack size) ) == max profit
     */

     public static int knapsackTabulation(int val[],int wt[],int W){
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
                    int incProfit = v+dp[i-1][j-w];
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

     //To check 2d array of tabulation
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
        int W=7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("Using normal recursion = "+knapsackRecursion(val, wt, W, val.length));
        System.out.println("Using memorization technique = "+knapsackMemorization(val, wt, W,val.length , dp));
        System.out.println("Using Tabulation technique = "+knapsackTabulation(val, wt, W));
    }
}
