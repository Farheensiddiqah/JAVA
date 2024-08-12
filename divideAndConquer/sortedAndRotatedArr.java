package divideAndConquer;

public class sortedAndRotatedArr {
    public static int search(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid = (si+ei)/2;
        if(arr[mid]==target){
            return mid;
        }
        //mid on l1
        if(arr[si] <= arr[mid]){
            //case a: left
            if(arr[si] <= target && target <= arr[mid]){
                return search(arr,target,si,mid-1);
            } else {
                //case b: right
                return search(arr,target,mid+1,ei);
            }
        //mid on l2
        } else{
            //case c - right
            if(arr[mid] <= target && target <= arr[ei]){
                return search(arr,target,mid+1,ei);
            } else{
                //case d - left
                return search(arr,target,si,mid-1);
            }
        }
    }
    public static void searchByLoop(int arr[],int target){
        for(int i=0;i<arr.length;i++){
            if(target == arr[i]){
                System.out.println("By Loop "+i);
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 6;
        int tarIndx = search(arr,target,0,arr.length-1);
        System.out.println(tarIndx);
        searchByLoop(arr,target);
    }
}
