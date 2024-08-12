package arrays;
//main aim is to just focus on positive nums
//as if we found any negative nos so rather than negative subraction just make it zero
public class kadanesalgo {
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            currsum = currsum+arr[i];
            if(currsum<0){
                currsum=0;
            }
            maxsum=Math.max(currsum,maxsum);
        }
        System.out.println("max sub array sum:"+maxsum);
    }
}
