package Recursion;

public class lenOfStrByRecursion {
    public static int countLen(String s,int c){
        if(c==s.length()){
            return c;
        } else {
            return countLen(s,c+1);
        }
        
    }
    public static void main(String args[]){
        String s="FarheenSiddiqah";
        System.out.println(countLen(s,0));
    }
}
