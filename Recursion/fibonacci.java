package Recursion;
import java.util.*;
public class fibonacci {
    public static int printfibnac(int n){
        if(n==0 || n==1){
            return n;
        }
        return printfibnac(n-1)+printfibnac(n-2);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(printfibnac(n));
    }
}
