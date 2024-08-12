import java.util.*;

public class rombus{
    public static void solidrhombus(int no){
       for(int i=1;i<=no;i++) {
        //spaces=n-i
        for(int j=1;j<=(no-i);j++){
            System.out.print(" ");
        }
        //stars = 2*n-i
        for(int j=1;j<=no;j++){
            if(i==1||i==no||j==1||j==no){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            } 
        }
        System.out.println();
       }
    }
    public static void main(String args[]){
        solidrhombus(5);
    }
}

// import java.util.*;
// public class basics{
//     public static void main(String args[]) {
//         Scanner sc= new Scanner(System.in);
//         int n= sc.nextInt();
//         for(int i=1;i<=n;i++) {
//             //spaces
//             for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }
//             //stars
//             for(int j=1;j<=((2*i)-1);j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//         //2nd half
//         for(int i=n;i>=1;i--) {
//              //spaces
//              for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }
//             //stars
//             for(int j=1;j<=((2*i)-1);j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }