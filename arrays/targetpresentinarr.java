package arrays;
//Should check wheather target is in nums or not and return its index value
public class targetpresentinarr {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans=i;
                break;
            }
        }
        if(ans==0){
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }
}
