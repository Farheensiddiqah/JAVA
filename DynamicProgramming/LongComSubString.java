package DynamicProgramming;
/*
 * Longest common subsequence
 * ==========================
 * a substring is a contigous sequence of characters within a string
 * 
 * eg ===
 * s1="abcde" s2="abgce"
 * ans = 2 //"ab"
 * 
 * s1 = "abcdgh" s2 = "acdghr"
 * ans = 4 //"cdgh"
 *
 * ---->variation of longest common subsequence
 * ------->almost same code
 * 
 * Approach
 * ========
 * 
 * a  b  c  d  e
 * 
 * a  b  g  c  e
 * 2  1  0  0  1
 * 
 * return largest ans = 2
 * 
 */
public class LongComSubString {
    public static int longSubstrings(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        //bottum Up approach
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans,dp[i][j]);
                } else{
                    //diff
                    dp[i][j] = 0;
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE"; //ans = 2
        System.out.println(longSubstrings(str1, str2));

    }
}
