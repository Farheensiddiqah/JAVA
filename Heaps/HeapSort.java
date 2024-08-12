package Heaps;

public class HeapSort {
    public static void heapify(int arr[],int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxidx = i;

        if(left < size && arr[left] > arr[maxidx]){
            maxidx = left;
        }

        if(right < size && arr[right] > arr[maxidx]){
            maxidx = right;
        }

        if(maxidx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;

            //now fix again
            heapify(arr,maxidx,size);
        }
    }
    //(O(nlogn))--tc
    public static void heapSort(int arr[]){
        //step 1 == build maxHeap
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            //to fix and make maxheap
            heapify(arr,i,n);    
        }

        //step 2 ==push largest at end
        for(int i=n-1;i>=0;i--){
            //swap largest-first with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //To make fix and make max heap
            heapify(arr,0,i);
        }
    }
   public static void main(String[] args) {
    int arr[] = {1,2,4,5,3};
    heapSort(arr);
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
   } 
}
