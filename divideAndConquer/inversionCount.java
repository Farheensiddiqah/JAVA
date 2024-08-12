package divideAndConquer;
/*  Question 3 :Given an array of integers. Find theInversion Count in the array.
 (HARD) Inversion Count:For an array,inversion count in dicates how far
 (or close) the array is from being sorted.If the array is already
 sorted then the inversion count is 0.
 If an array is sorted in the reverse order then the inversion count 
 is the maximum.Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] 
 and i < j.
Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}Sample Output 1: 3, because it has 3 inversions -(2, 1), (4, 1), (4, 3).farheensiddiqah19@gmail.com
Sample Input 2: N = 5, arr[ ] = {2, 3, 4, 5, 6}Sample Output 2: 0, because the array is alreadysorted
Sample Input 3: N = 3, arr[] = {5, 5, 5}SampleOutput3:0, because all the elements of the array are the same & already in a 
sorted manner.(Hint: A sorting algorithm will be used to solvethis question.)Note-Thisquestionisimportant.Evenifyouarenotabletocomeupwiththeapproach,please understand the solution */

// Brute Force - solution

public class inversionCount {
    public static void inversionsortt(int arr[]){
        int c=0;
        for(int i=0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;j++){
            //swap
            if(arr[i]>arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                c++;
            }
          }
        }
        System.out.println(c);
    }
     public static void main(String args[]){
        int arr[] = {2,4,1,3,5};
        inversionsortt(arr);
     } 
}


//optimized 
//To be done