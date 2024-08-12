package strings;

public class revserseAString {
    public static void main(String args[]){
        String str = "neha";
        String ans = "";
        for(int i = str.length()-1;i>=0;i--){
            char c =str.charAt(i);
            ans = ans +c;
        }
        System.out.println(ans);
    }
}
