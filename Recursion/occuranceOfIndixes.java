package Recursion;
/* Question1:For a given integer array of size N.
You have to find all the occurrences(indices)
of a given element(Key)and print them.
Use a recursive function to solve this problem.
Sample Input: arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2},key = 2
Sample Output: 1 5 7 8
*/
public class occuranceOfIndixes {
    public static void countFun(int arr[],int indx,String s,int key){
        //base case
        if(indx==arr.length){
            System.out.println(s);
            return;
        }
        //condition
        if(arr[indx]==key){
            countFun(arr,indx+1,s+indx+" ",key);
        } else {
            countFun(arr,indx+1,s,key);
        }

    }
    public static void main(String args[]){
        int arr[] = {3,2,4,5,6,2,7,2,2};
        int key = 2;
        countFun(arr,0,"",key);
    }
}
