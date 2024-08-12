package Recursion;
import java.util.*;
public class printDec {
    // public static void printDecc(int n){
    //     //write first base class
    //     if(n==1){
    //         System.out.println(n);
    //         return;
    //     }
    //     System.out.print(n+" ");
    //     printDecc(n-1);
    // }
    public static void printasc(int n){
        //write base class
        if(n==1){
            System.out.println(1);
            return;
        }
        printasc(n-1);
        System.out.println(n);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // printDecc(n);
        printasc(n);
    }
}
