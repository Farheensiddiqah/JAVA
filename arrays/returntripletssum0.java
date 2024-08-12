package arrays;

public class returntripletssum0 {
    public static void main(String[] args) {
        int nums[]= {-1,0,1,2,-1,4};
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k= j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        System.out.println(nums[i]+"and"+nums[j]+"and"+nums[k]);
                    }
                }
            }
        }
    }
}
