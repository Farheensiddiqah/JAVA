package divideAndConquer;
/* 
 *  TC: avg : O(nlogn) worst : O(n^2)  space: O(1)
    Pivot and partition rule
    -> 1. Pivot(last element) 
       2. partition

    Worst Case of Quick sort occurs when pivot is always the smallest or the largest element.
    with the eg:     1 2 3 4 5 if pivot: 5
    
 */

public class quickSort {
   public static void quicksortt(int arr[],int si,int ei){
      if(si>=ei){
         return;
      }
      //last elememt - pivot
      int pidx = partition(arr,si,ei);
      quicksortt(arr,si,pidx-1); //left
      quicksortt(arr,pidx+1,ei); //right

   }
   public static int partition(int arr[],int si,int ei){
      int pivot = arr[ei];
      int i = si-1;
      for(int j=si;j<ei;j++){
         if(arr[j]<=pivot){
            i++;
            //swap
            int temp= arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
         }
      }
      i++;
      int temp= pivot;
      arr[ei]=arr[i];
      arr[i]=temp;
      return i;
   }
    public static void main(String args[]){
      int arr[] = {6,3,9,8,2,5};
      quicksortt(arr,0,arr.length-1);
      for(int i=0;i<arr.length;i++){
         System.out.println(arr[i]);
      }
    }
}
