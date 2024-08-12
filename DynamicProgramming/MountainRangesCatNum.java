package DynamicProgramming;
/*
 * Mountain Ranges
 * ====================
 * Form of Catalans Number
 * ---------------
 * Mountains and valleys at any moment the number of down strokes
 * cannot be more than number of up strokes.
 * 
 *    /             \
 *   /               \
 *  Up strokes      Down Strokes
 * 
 * 
 * For eg = n=3
 *   if given  /\/\/\
 * ans === 5 ways
 * 
 *  /\/\/\ -------(1)
 *  
 *   /\
 *  /  \/\ ---------(2)
 * 
 *     /\
 *  /\/  \ -------(3)
 *  
 *   /\
 *  /  \
 * /    \  ------(4)
 * 
 * 
 *  /\/\
 * /    \  ------(5)
 * 
 * For catalans Number 
 * cn = c0*c(n-1) + c1*c(n-2) + c2*c(n-3) +.....
 * 
 * Mn = m0*m(n-1) + m1*m(n-2) + m2*m(n-3) +........
 * 
 * We can say that for n pairs ==>  Cn (Mountain Ranges)
 * 
 */
public class MountainRangesCatNum {
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println("Number of ways of arranging mountain ranges are = "+mountainRanges(n));
    }
}
