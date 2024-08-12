package sortingalgos;
//tc:o(n^2)
public class selectionsort {
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        for(int i=0;i<arr.length-1;i++){
            int smallnum=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[smallnum]){
                    smallnum = j;
                }
            }
            int temp = arr[smallnum];
            arr[smallnum] = arr[i];
            arr[i] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
