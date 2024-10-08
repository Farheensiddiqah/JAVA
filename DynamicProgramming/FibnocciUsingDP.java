package DynamicProgramming;

public class FibnocciUsingDP {
    //fibocci code
    // public static int fib(int n){
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     return fib(n-1)+fib(n-2);
    // }
    //But then we can observe in explanation it is calculating same number for multiple times
    public static int fibUsingMemorization(int n,int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        return f[n] =fibUsingMemorization(n-1,f)+fibUsingMemorization(n-2,f);
    }

    //Using Tabulation
    public static int fibUsingTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int f[] = new int[n+1]; 
        System.out.println(fibUsingMemorization(n,f));
        System.out.println(fibUsingTabulation(n));
    }
}
