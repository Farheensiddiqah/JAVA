package DynamicProgramming;
/*
 * Edit Distance
 * =============
 * -> Variation of lcs qn
 * 
 * Given two strings word1 and word2, return the minimum 
 * number of operations required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 *  1. Insert a character
 *  2. Delete a character
 *  3. Replace a charcter
 * 
 * word1 = "intention", word2 = "execution"  ===> ans = 5
 * 
 * intention -> intention (remove 't')
 * inention  -> enention  (replace 'i' with 'e')
 * enention  -> exention  (replace 'n' with 'x')
 * exention ->  exection  (replace 'n' with 'c')
 * exection  -> execution (insert 'u')
 * 
 * Approach
 * ==========
 * 1) same
 *   str1(n) -> str2(m) == str1(n-1) -> str2(m-1)
 * 
 * 2)Different
 *   1) add == str1(n) str2(m-1) +1
 *   2) delete == str1(n-1)str2(m)+1
 *   3) replace == str1(n-1)str2(m-1)+1
 * 
 * --> make 2d array
 * =================
 * ->for(int i to n+1)
 *    for(int j to m+1)
 *       if(i==0) -> dp[i][j] = j
 *       if(j==0) -> dp[i][j] = i
 * 
 * 
 */
public class EditDistanceLCS {
    public static int editDistance(String word1,String word2){
        int n=word1.length();
        int m=word2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //diff
                    int add = dp[i][j-1]+1;
                    int del = dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add,Math.min(del,rep));
                    
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution"; //ans==5
        System.out.println(editDistance(word1,word2));
    }
}
