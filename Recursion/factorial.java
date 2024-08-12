package Recursion;
import java.util.*;
public class factorial {
    public static int printfac(int n){
        if(n==0){
            return 1;
        }
        // int fnm1 = printfac(n-1);
        int fn = n * printfac(n-1);
        return fn;

    }
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(printfac(n));
        }
    }
}
