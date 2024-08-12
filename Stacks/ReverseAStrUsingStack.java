package Stacks;
import java.util.*;
//Reverse a string using stack--imp
public class ReverseAStrUsingStack {
    public static String reverseAStr(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char ch = s.pop();
            result.append(ch);
        }
        return result.toString();

    }
    public static void main(String[] args) {
        String str = "neha";
        String res = reverseAStr(str);
        System.out.println(res);

    }
}
