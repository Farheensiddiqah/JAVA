package divideAndConquer;
/* Question1: Apply Merge sort to sort an array of Strings 
.(Assume that all the characters in all the Strings are in lowercase).(EASY)
 Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}
 Sample Output 1: arr = { "earth", "mars", "mercury","sun"} */
public class stringSort {
    // public static void mergesortt(String arr[],int si,int ei){
    //     if(si>=ei){
    //         return;
    //     }
    //     int mid = (si+ei)/2;
    //     mergesortt(arr,si,mid);
    //     mergesortt(arr,mid+1,ei);
    //     merge(arr,si,mid,ei);
    // }
    // public static void merge(String arr[],int si,int mid,int ei){
    //     int temp[] = new int[ei-si+1];
    //     int i = si;
    //     int j = mid+1;
    //     int k = 0;
    //     while(i<=mid && j<=ei){
    //         if(arr['a'-i]<arr[j]){
    //             temp[k]=arr[i];
    //             k++;
    //             i++;
    //         } else{
    //             temp[k]=arr[j];
    //             k++;
    //             j++;
    //         }
    //     }
    //     while(i<=mid){
    //             temp[k]=arr[i];
    //             i++;
    //             k++;
    //     } 
    //     while(j<=ei){
    //             temp[k] = arr[j];
    //             j++;
    //             k++;
    //     }
    //      for(k=0,i=si;k<temp.length;k++,i++){
    //         arr[i] = temp[k];
    //     }
       
    // }
    // public static void main(String args[]){
    //     String arr[] = {"sun","earth","mars","mercury"};
    //     mergesortt(arr,0,arr.length-1);
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
        
    // }
}
