package backtracking;
/* Find and print all the permutations possible
 * and also if the input string = "abc"
 * then total number of permutations are (n)!
 * so from here n=0 so n = 3! where 3*2*1
 * where outputs are : abc,acb,bac,bca,cab,cba;
 */
public class permutations {
    public static void findPermutations(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion --- TC: O(n * n!)
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            //abcde = ab+de = abde where we can remove the character using substring
            String newstr = str.substring(0,i)+str.substring(i+1);
            findPermutations(newstr,ans+curr);
        }

    }
    public static void main(String args[]){
        String str = "abc";
        findPermutations(str,"");
    }
}
