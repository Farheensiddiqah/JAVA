package Stacks;
import java.util.*;
/*
 * Stacks LIFO
 * 3 Operations
 * ============
 * 1.Push O(1) 
 * 2.Pop O(1)
 * 3.Peek O(1) -- Top element
 * 
 * --> every operations are related to topp only
 */
public class StackBasics {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        //isEmpty or  not
        public static boolean isEmpty(){
           return list.size()==0; 
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //peek -- just to get top
        public static int peek(){
             if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
  
}
