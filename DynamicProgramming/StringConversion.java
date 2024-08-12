package DynamicProgramming;
/*
 * String Conversion
 * ======================
 * Convert string1 to string2 with only insertion and deletion.
 * print number of deletions and insertions
 * 
 * eg == s1 = abcdef
 *       s2 = aceg
 * ans = 4 (3 delete and 1 insert)
 * 
 * Approach
 * ---------
 * 
 * 1.Find lcs of both str1 and str2
 * 2. then (lcs.length()-str1.length()) == x delete operations
 * 3. then (lcs.length()- str2.length()) == y addition operations
 * 
 * 
 */
import java.util.*;
public class StringConversion {
    public static int ans = 0;
    public static int lcs(String s1,String s2,int n,int m){
        int dp[][] = new int[n+1][m+1];

        //intialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j] = 0;
                }
            }
        }

        //work
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ins = dp[i-1][j]+1;
                    int del = dp[i][j-1]+1;
                    dp[i][j] = Math.min(ins, del);
                }
            }
        }
        ans = dp[n][m];
        return dp[n][m];
    }
    public static void main(String[] args) {
        // String s1 = "abcdef";
        // String s2 = "aceg";
        String s1="pear";
        String s2 = "sea";
        int n=s1.length();
        int m= s2.length();
        System.out.println(lcs(s1, s2, n, m));
        System.out.println(ans);
        int del =Math.abs(n-ans);
        int ins = Math.abs(m-ans);
        System.out.println(del);
        System.out.println(ins);
    }
}
