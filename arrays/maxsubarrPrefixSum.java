package arrays;

public class maxsubarrPrefixSum {
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        int prefix[] = new int[arr.length];
        int currsum=0,maxsum=Integer.MIN_VALUE;

        //finding prefix sum
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++) {
            int start = i;
            for(int j=i;j<arr.length;j++){
                int end =j;
                if(start==0){
                    currsum=prefix[end];
                }else{
                    currsum = prefix[end]-prefix[start-1];
                }
                if(maxsum<currsum){
                    maxsum=currsum;
                }

            }
        }
        System.out.println("maxsum is "+maxsum);
    }
}

//tc= o(n^2)