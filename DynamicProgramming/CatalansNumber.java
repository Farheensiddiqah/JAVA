package DynamicProgramming;
/*
 * Catalans Number
 * ===============
 * c0 = 1
 * c1 = 1
 * c2 = c0.c1 + c1.c0 = 2
 * c3 = c0.c2 + c1.c1 + c2.c0 = 5
 * c4 = 
 * 
 * the values of c0 and c1 are already given as 1 and 1
 * 
 *---> and also we can also observe the pattern as
 *   cn == c0*cn-1 + c1*cn-2 + c2*cn-3 +..+cn-1*c0
 * 
 * Memorization code
 * =================
 * --> can be done using 1d array
 * 
 */
import java.util.*;
public class CatalansNumber {
    public static int catalansUsingRec(int n){
        if(n==0 || n==1){
            return 1;
        }

        int ans = 0; //cn

        for(int i=0;i<=n-1;i++){
            ans += catalansUsingRec(i)*catalansUsingRec(n-i-1);
        }

        return ans;
    }
    public static int catalansUsingMemorization(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans += catalansUsingMemorization(i, dp) * catalansUsingMemorization(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    //Tc== O(n*n)
    public static int catalanTab(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){ //ci
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1]; //ci = cj * ci-j-1
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(catalansUsingRec(n));

        //memorization'
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalansUsingMemorization(n, dp));

        //tabulation
        System.out.println(catalanTab(n));
    }
}
