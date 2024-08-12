package GreedyAlgo;
/*
 * Lexicographically smallest string of length N and sum K 
 * We have two integers N and K.The task is to print the 
 * lexicographically smallest string of length N consisting 
 * of lower-case English alphabets such that the sum of the 
 * characters of the string equals to K where 
 * ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ..... and ‘z’ = 26. 
 * Sample Input 1: N = 5, K = 42 
 * Sample Output 1: aamz
 * Sample Input 2: N = 3, K = 25
 * Sample Output 2: aaw
 */


//To be done later


// import java.util.*;
// public class LexicographicallySmallestString {
//     public static void main(String[] args) {
//         int n=3,k=25;

//         ArrayList<Character> arr = new ArrayList<>();
//         int arrNos[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
//         Character arrAlpha[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

//         int total=k;
//         while(total!=0){
//             for(int i=n-1;i>=0;i++){
//                 if(total>= 26){
//                     total-=26;
//                     arr.add(arrAlpha[26]);
//                 }else{
//                     if(i<total){
//                         total -= i;
//                         arr.add(arrAlpha[i]);
//                     }
             
//                 }
//             }
//         }

//         //to print
//         for(int i=0;i<arr.size();i++){
//             System.out.print(arr.get(i));
//         }

//     }   
// }
