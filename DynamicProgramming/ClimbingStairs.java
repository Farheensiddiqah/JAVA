package DynamicProgramming;

import java.util.Arrays;

/*
 * Climbing Stairs
 * ====================
 * Count ways to reach the nth stair. The person can climb
 * either 1 stair or 2 stairs at a time.
 * 
 * if n=5
 * then ans = 8
 * 
 * 
 * And also there can be many variations
 * ====================================(IMP)
 * --> Eg= If they given that there are either 1 ,2 or 3 jumps 
 * then it is possible that just add ans with (n-3).. simillarly for n jumps
 * 
 * ways[n] = ways(n-1)+ways(n-2)+ways(n-3)
 * 
 */
public class ClimbingStairs {
    public static int climbRecursion(int n){
        //Tc==O(2^(n))
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbRecursion(n-1)+climbRecursion(n-2);
    }

    public static int climbMemorization(int n,int ways[]){
        //TC == O(n)
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = climbRecursion(n-1)+climbRecursion(n-2);
        return ways[n];
    }

    //Tabulation methods
    public static int climbingTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1;i<=n;i++){
            if(i == 1){
                dp[i] = dp[i-1]+0;
            } else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=5; //ans = 8
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);

        System.out.println("Using Normal Recursion = "+climbRecursion(n));
        System.out.println("Using Memorization  = "+climbMemorization(n,ways));
        System.out.println("Using Tabulation = "+climbingTabulation(n));
    }
}
