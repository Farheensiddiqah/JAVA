package arrays;
import java.util.*;
public class linearsearch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[]= new int[5];
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        int key = 5;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println("found at index:"+i);
            }
        }
    }
}
