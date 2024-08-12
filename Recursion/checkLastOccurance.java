package Recursion;

public class checkLastOccurance {
    public static int lastoccur(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int found = lastoccur(arr,key,i+1);
        if(found == -1 && arr[i]==key){
            return i;
        }
        return found;
    }
    public static void main(String args[]){
        int arr[]={5,5,5,5};
        int key=5;
        System.out.println(lastoccur(arr,key,0));
    }
}
