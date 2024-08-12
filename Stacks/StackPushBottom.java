package Stacks;
import java.util.*;
public class StackPushBottom {
    public static void pushAtBottom(Stack<Integer> s,int data){
        //base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //recursion
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
        
    }

    public static void revesreStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        revesreStack(s);
        pushAtBottom(s,top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        //3 2 1
        //output- 1 2 3
        // pushAtBottom(s,4);

        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
            
        // }
        
        revesreStack(s);
        printStack(s);
    }
}
