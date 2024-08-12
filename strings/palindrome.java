package strings;

public class palindrome {
    public static void main(String[] args) {
        String str="racecar";
        boolean ans=true;
        int len=str.length();
        for(int i=0;i<(len/2);i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                ans=false;
                break;
            }
        }
        System.out.println(ans);
    }
}
