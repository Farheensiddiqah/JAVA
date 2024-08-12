package Stacks;
import java.util.*;
public class StackInBuilt {
    public static void main(String[] args) {
        Stack<Integer> s =new Stack<>();
        s.push(5);
        s.push(6);
        s.push(7);
        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
