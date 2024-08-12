package arrays;
import java.util.*;
public class largestno {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int arr[]=new int[5];
        for(int i=0;i<arr.length;i++) {
            arr[i] = s.nextInt();
        }
        int largest =  Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        System.out.println("largest no is:"+largest);
    }
}
