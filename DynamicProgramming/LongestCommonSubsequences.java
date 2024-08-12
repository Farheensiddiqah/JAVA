package DynamicProgramming;
/*
 * Longest Common Subsequence
 * ==========================
 * A sequence of a string is a new string generated from the 
 * original string with some characters(can be none) deleted
 * without changing the relative order of the remaining characters
 * 
 * str1 = "abcde", str2 = "ace"
 * ans = 3 //"ace"
 * 
 * str1 = "abcdge", str2 = "abedg"
 * ans = 4 //"abdg"
 * 
 * Implementation
 * =================
 * str1 = "abcde", str2 = "ace"
 * ans = 3 //"ace"
 * ============
 * --> do loop from backwards
 * 
 *       abcde    ace
 *        5        3
 *            | (+1)since we found same e 
 *            V
 *      abcd     ac
 *        4       2
 *          /    \
 *         /      \
 *   abc  ac      abcd a
 *    3    2       4   1
 *      |(+1)same
 *      v
 *   ab   a
 *    2    1
 *        /  \
 *       /    \
 *    a  a    ab " "
 *    1  1     2  0
 *     |(+1)same
 *     v
 * " "   " "
 *   return 0
 * 
 * --> In these way we get 3 as answer
 * 
 * 
 * 
 * Approch
 * =========
 * Recursion
 * -----------Code
 * n=str1.length;
 * m=str2.length;
 * lcs(str1,str2,n,m){
 *    if(n==0 || m==0)
 *         return 0 --> base case
 *    if str1(n-1) == str2(m-1) //if same
 *       return lcs(str1,str2,n-1,m-1)+1
 *    if diff
 *       ans 1 = lcs(str1,str2,n-1,m)
 *       ans2 = lcs(str1,str2,n,m-1)
 *       return max(ans1,ans2)
 * }
 * 
 * Memorization
 * ------------
 * ->in memorization we can just use an 2d array to store ans and 
 * reuse when required
 * 
 * 
 * Tabulation
 * ===========
 * 
 * steps in general
 * ------
 * 1. create table
 * 2. assign meaning to index + and initialize (base case)
 * 3. fill up from (bottom up) 
 *   (small -> large)
 * 
 * Pseudo code
 * ------------
 * 
 * for(int i=1 to n+1)
 *   for(int j=1 to m+1)
 *     if(str1[i-1] == str2[j-1])(same)
 *         dp[i][j] = dp[i-1][j]+1
 *     else (diff)
 *         ans1 = dp[i-1][j]
 *         ans2 = dp[i][j-1]
 *         dp[i][j] = max(ans1,ans2)
 * 
 * 
 * 
 * 
 * 
 */
public class LongestCommonSubsequences {
    public static int lcsUsingRecursion(String str1,String str2,int n,int m){ //TC=O(2^(n*m))
        //Base Case
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){ //same
            return lcsUsingRecursion(str1, str2, n-1, m-1)+1;
        } else{ //diff
            int ans1 = lcsUsingRecursion(str1, str2, n-1, m);
            int ans2 = lcsUsingRecursion(str1, str2, n, m-1);
            int ans = Math.max(ans1,ans2);
            return ans;
        }
    }

    public static int lcsUsingMemorization(String str1,String str2,int n,int m,int dp[][]){ 
        //TC==O(n*W)
            //base case
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
                //if same
            dp[n][m] = lcsUsingMemorization(str1,str2,n-1,m-1,dp)+1;
            return dp[n][m];
        }//diff
        else{
            int ans1 = lcsUsingMemorization(str1,str2,n-1,m,dp);
            int ans2 = lcsUsingMemorization(str1,str2,n,m-1,dp);
            dp[n][m] = Math.max(ans1,ans2);
            return dp[n][m];
        }
    }

    //Tabulation
    public static int lcsUsingTabulation(String str1,String str2,int n,int m){
        int dp[][] = new int[n+1][m+1];

        //intialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1]+1;
                }//diff
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) { 
        // String str1 = "abcdge";
        // String str2 = "abedg"; //lcs = "abdg"; length = 4
        String str1 = "abcde";
        String str2 = "ace"; //ans = 3 ("ace")
        int n = str1.length();
        int m = str2.length();
        System.out.println("Using normal recursion = "+lcsUsingRecursion(str1, str2, str1.length(), str2.length()));

        //memorization
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memorizartion technique = "+lcsUsingMemorization(str1,str2,n,m,dp));

        //Tabulation
        System.out.println("Using Tabulation  = "+lcsUsingTabulation(str1, str2, n, m));
    }
}
