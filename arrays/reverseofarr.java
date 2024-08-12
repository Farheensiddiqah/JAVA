package arrays;
import java.util.*;
public class reverseofarr {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int first=0,last = arr.length-1;
        while(first<last){
            int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
            first++;
            last--;
        }
        // int n=1234;
        // int rev=0;
        // while(n!=0){
        //     int rem=n%10;
        //     rev=(rev*10)+rem;
        //     n=n/10;
        // }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
        }
     }
}
