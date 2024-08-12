package Recursion;

public class numToStrWord {
    public static void convertToWord(int n,String arr[]){
        if(n==0){
            return;
        }
        int lastdigit = n%10;
        convertToWord(n/10,arr);
        System.out.print(arr[lastdigit]+" ");
        
    }
    public static void main(String args[]){
        int n = 2002;
        String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        convertToWord(n,arr);
    }
}
