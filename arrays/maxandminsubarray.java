package arrays;
import java.util.*;
public class maxandminsubarray {
    public static void main(String args[]){
        int arr[]={2,4,6,8,10};
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                int summ=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                    summ += arr[k];
                    maxsum=Math.max(maxsum,summ); 
                    minsum=Math.min(minsum,summ);
                }
                System.out.println();
            }
        }
        System.out.println(maxsum);
        System.out.println(minsum);
    }
}
