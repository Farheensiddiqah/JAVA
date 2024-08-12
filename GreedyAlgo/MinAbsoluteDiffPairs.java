package GreedyAlgo;
/*
 * Given two Arrays A and B of equal length n.pair each element
 * of array A to an element in array B, such that sum S of absolute 
 * difference of all the pairs is minimum
 * 
 * a=[1,2,3]
 * b=[2,1,3]
 * ans=0
 */
import java.util.*;
public class MinAbsoluteDiffPairs {
    public static void minAbsoluteSum(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int diff=0;
        for(int i=0;i<a.length;i++){
            diff += Math.abs(a[i]-b[i]);
        }
        System.out.println(diff);
    }
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,1,3};
        // int a[] = {4,1,8,7};
        // int b[] = {2,3,6,5};
        minAbsoluteSum(a,b);
    }
}
