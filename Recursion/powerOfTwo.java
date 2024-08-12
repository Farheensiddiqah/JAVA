package Recursion;

public class powerOfTwo {
    //O(n)-Time complexity
    public static int powerfunction(int x,int n){
        if(n==0){
            return 1;
        }
        return x*powerfunction(x,n-1);
    }


    /* To make it more optimized here we have to do 
    for example -- if x=2 and n=10
    == 2^10 == 2^(n/2) * 2^(n/2); ==>  2^5*2^5;=========>for even
       2^5  == 2 * 2^(n/2) * 2^(n/2); ==> 2*2^2*2^2 =====>for odd
       then in that way we can optimise our code more and more   */
    
    //TC: log(n)
    public static int optimizedfun(int x,int n){
        if(n==0){
            return 1;
        }
        int halfpow = optimizedfun(x,n/2);
        int halfpowsq = halfpow * halfpow;
        //if n is odd
        if(n%2 != 0){
            halfpowsq = x * halfpowsq;
        }
        return halfpowsq;
    }
    public static void main(String args[]){
        int x=2;
        int n=10;
        System.out.println(powerfunction(x,n));
        System.out.println(optimizedfun(x,n));
    }
}
