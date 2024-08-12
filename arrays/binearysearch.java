package arrays;
import java.util.*;
public class binearysearch {
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            int arr[] = new int[6];
            for(int i=0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            int key = 10;
            int start = 0,end=arr.length-1;
            int ans=-1;
            while(start<=end) {
                //mid
                int mid =(start+end)/2;
                if(key==arr[mid]){
                    ans=mid;
                }
                if(key<arr[mid]){
                    end=mid-1;  //left condition
                } else{
                    start = mid+1;  //start condition
                }
            }
            if(ans==-1){
                System.out.println("Not Found");
            } else{
                System.out.println("Found at index:"+ans);
            }
        }

    }
}
//TC - log(n)