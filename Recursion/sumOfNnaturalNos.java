package Recursion;
import java.util.*;
public class sumOfNnaturalNos {
    public static int printsum(int n){
        if(n==1){
            return 1;
        }
        return n+printsum(n-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(printsum(n));
    }
}
