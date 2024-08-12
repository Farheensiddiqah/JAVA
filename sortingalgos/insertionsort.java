package sortingalgos;

public class insertionsort {
    public static void main(String[] args) {
        int arr[]={5,4,1,2,3};
        for(int i=1;i<arr.length;i++) {
            int curr=arr[i];
            int prev = i-1;
            //finding out the correct position to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1] = curr;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
