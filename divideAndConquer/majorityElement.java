package divideAndConquer;
/* Question 2 :Given an array nums of size n, return 
the majority element. (MEDIUM)The majority element is the
element that appears more than ⌊n/2⌋ times.
You may assume that the majority element always exists in the 
array.
Sample Input 1: nums = [3,2,3]
Sample Output 1: 3

Sample Input 2: nums = [2,2,1,1,1,2,2]
Sample Output 2: 2

Constraints(extra Conditions): ●n == nums.length
   ●1 <= n <= 5 * 104
   ●-109 <= nums[i] <= 109 */
public class majorityElement {
public static void sortt(int arr[]){
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        //swap
        if(arr[i]>arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
      }
    }
    int indx = (arr.length)/2;
    System.out.println(arr[indx]);
}
 public static void main(String args[]){
    int arr[] = {2,2,1,1,1,2,2};
    sortt(arr);
 }   
}
