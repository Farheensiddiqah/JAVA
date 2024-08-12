package Recursion;

public class arrSortUsgRecursion {
    public static boolean checksort(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return checksort(arr,i+1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,5,3,4};
        System.out.println(checksort(arr,0));
    }
}
