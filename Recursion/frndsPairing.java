package Recursion;
/* Friends Pairing Problem
 * Given n friends, each one can remain single or
 * can be paired only once. Find out the total number of ways 
 * in which friends can remain single or can be paired up
 */
public class frndsPairing {
    public static int pairing(int n){
        //base case
        if(n==1 || n==2){
            return n;
        }
        //work
        //if single
        int fnm1 = pairing(n-1);
        //if pair
        int fnm2 = (n-1)*pairing(n-2);
        //Total Ways
        return fnm1+fnm2;
        /*
         * or can be written directly as 
         * return pairing(n-1)+(n-1)*pairing(n-2);
         */
    }
    public static void main(String args[]){
        int n=3;
        System.out.println(pairing(n));
    }
}
