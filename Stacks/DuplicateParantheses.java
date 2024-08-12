package Stacks;
import java.util.*;
public class DuplicateParantheses {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            //closing
            if(ch==')'){
                int count=0;
                while(!s.isEmpty() && s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate
                } else{
                    s.pop(); //opening pair
                }
            } else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b))"; // true--it has duplicate parathesis which is extra
        String str1 = "(a-b)";  //false-- since it doesnot have any duplicate paranthesis
        System.out.println(isDuplicate(str1));
    }
}
