package sortingalgos;
//theory came from bubble chemistry lab theory like while when we 
//boil water then small vapours evaporates and large store inside
//simillary  with n-1 turns with each turn it will get sorted
//eg: 321
 //n-1 turns
public class bubblesort {
    public static void main(String[] args) {
        int arr[]= {5,6,3,2,4,1};
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]) {
                //swapping
                int temp= arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
