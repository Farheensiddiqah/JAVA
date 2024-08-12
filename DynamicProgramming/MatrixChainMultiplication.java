package DynamicProgramming;
/*
 * Matrix Basics
 * ==============
 * ---> For a multiplication of matrix
 *    
 * if (A.B)
 *    /   \
 *  a*b   c*d
 * 
 * 3 Rules
 * =======
 * 1) b == c
 * 2)final result  => matrix[a*d]
 * 3) operations => a * b * d
 *                 
 * Eg === 
 *  A = 1*2 [ 1 2 ]
 *  B = 2*3
 *     [ 1 3 4]
 *     [ 2 5 6]
 * 
 * ans == [1*1+2*2,1*3+2*5, 1*4+2*6]
 *     ==  [5 13 16]
 * 
 * and by rules
 * ------------
 * 1) b==c (2 == 2)
 * 2) final result matrix[a*d] == matrix[1*3]
 * 3) operations  = a*b*d
 *           == 1*2*3 =6
 */
/*
 * Matrix Chain Multiplication
 * ============================
 * arr[] = 1,2,3,4,3
 * Find Min Cost
 * 
 * --->
 * From the arr given [1 2 3 4 3]
 *  
 *   A    B    C    D
 *  1*2  2*3  3*4  4*3
 * 
 * -->We also can take many combinations as
 *       /          |            \
 *  (((AB) C) D)   ((AB)(CD))   ((A(BC))D) ..........
 * 
 * -->So from these we should find the correct combination
 * 
 * that gives us the min cost
 * 
 * 
 * For an another eg=
 * ---------------------------------------------------
 *      A  B  C
 *       /    \
 *   ((AB)C)  (A(BC))
 *     |
 *     v
 *   (A1.C)
 * 
 *  -->  A     B     C
 *     (1*3)  (3*5) (5*6)
 *      |-------|
 * cost = 1*3*5(a*b*d)
 * result = A1 => 1*5 (a*d)
 * 
 * ===> now that became 
 *     
 *      A1   C
 *    1*5   5*6
 *     |-----|
 * cost = 1*5*6 =30
 * result = 1*6 
 * 
 * -------------------------------------------------
 * 
 * Approach
 * ---------
 * 1) i = starting point
 * 2) j = ending point
 * 3) k = start -> end
 * --> Ai = arr[i-1] * arr[i]
 * 
 *   A    B
 * (a*b) (c*d)
 * cost = a*b*d (result)
 * size = a*d
 * 
 * 
 * APPROCH (PSEUDO CODE)
 * ====================
 * 
 * int mcm(arr[],int i,int j){
 *     int ans = postive infy
 *     for(int i to j-1)
 *       cost1 = mcm(arr,i,k)
 *       cost2 = mcm(arr,k+1,j)
 *       cost3 = arr[i-1]*arr[k]*arr[j]
 *       finaCost = cost1+cost2+cost3
 *       ans = min(ans,finalCost)
 * }
 * 
 * 
 * Here we got cost3 = arr[i-1]*arr[k]*arr[j] as
 *        cost1 = mcm(arr,i,k)
 * --> for cost1 = Ai = arr[i-1] * arr[i] (a*b)
 *                 Ak = arr[k-1] * arr[k] (c*d)
 *  and cost = a*b*d
 *        cost1 = arr[i-1] * arr[k]
 * 
 * ---> simillarly
 *      cost2 = mcm(arr,k+1,j)
 *   for cost2 = A(k+1) = arr[k] * arr[k-1]
 *               Aj  =  arr[j-1] * arr[j]
 *        so cost2 = arr[k]*arr[j]
 * 
 * --> so now from cost1 and cost2
 *        cost1 = arr[i-1] * arr[k] (a*b)
 *        cost2 = arr[k]*arr[j] (c*d)
 *   so cost3 = a * b * d
 *      cost3 = arr[i-1]*arr[k]*arr[j]
 *      
 * 
 */
import java.util.*;
public class MatrixChainMultiplication {
    public static int mcm(int arr[],int i,int j){
        //base case
        if(i==j){
            return 0; //single matrix case
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcm(arr, i, k); //Ai.....Ak  => arr[i-1]*arr[k]
            int cost2 = mcm(arr, k+1, j); //A(i+1)...Aj => arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans,finalCost);
        }
        return ans; //mincost
    }

    //Memorization
    public static int mcmUsingMemorization(int arr[],int i,int j,int dp[][]){
        //Base case
        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmUsingMemorization(arr, i, k, dp);
            int cost2 = mcmUsingMemorization(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    //Tabulation
    public static int mcmUsingTabulation(int arr[],int n){
        int dp[][] = new int[n][n];

        //initialization
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        //bottom-up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[j]*arr[k];
                    dp[i][j] = Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }

    //To print dp
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
        int arr[] = {1,2,3,4,3}; //n=5
        int n =arr.length;
        System.out.println("MCM = "+mcm(arr, 1, n-1));

        //Memorization
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(mcmUsingMemorization(arr, 1, n-1, dp));

        //Tabulation
        System.out.println(mcmUsingTabulation(arr, n));
    }
}
