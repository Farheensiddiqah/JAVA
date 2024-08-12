package arrays;
import java.util.*;
public class distinctnums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = new int[4];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        int c=0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    c=1;
                }
            }
        }
        if(c==1){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
