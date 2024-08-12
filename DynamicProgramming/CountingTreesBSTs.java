package DynamicProgramming;
/*
 * Counting BST trees
 * =====================
 * Find number of all possible BSTs with the given n nodes.
 * 
 * >>>>Just a question of catalans 
 * 
 * n=3 (10,20,30)
 * ans = 5
 * 
 * 5 ways are
 * ---------
 *      10            10           20         30        30
 *     /  \           / \          / \        /         /   
 *    .    20        .   30       10  30     20        10
 *          \            /                  /           \
 *           30         20                  10           20
 * 
 * 
 *  if we observe the pattern also
 * c0*c2 +c1*c1 +c2*c1
 * 
 */
public class CountingTreesBSTs {
    //Tc == O(n^2)
    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0]= 1;
        dp[1]= 1;

        for(int i=2;i<n+1;i++){
            //ci ->bst(i node)
            for(int j=0;j<i;j++){
                //ci = cj* ci-j-1
                //and also in left subtree can be arranged in dp[j] ways
                //right subtree in dp[i-j-1] ways
                // dp[i] += dp[j] * dp[i-j-1];
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(countBST(n));
    }
}
