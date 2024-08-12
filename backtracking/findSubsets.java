package backtracking;
//Always  remeber that for eg : input : abc 
// len = 3(n) then all subsets are always == 2^(n)
public class findSubsets {
    public static void subsets(String s,String ans,int i){
        //base case
        if(i==s.length()){
            if(ans.length() == 0){
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        //Backtracking choices

        //if yes that means to add
        subsets(s,ans+s.charAt(i),i+1);
        //if no not to add
        subsets(s,ans,i+1);
    }
    public static void main(String args[]){
        String s = "abc";
        subsets(s,"",0);
    }
}
