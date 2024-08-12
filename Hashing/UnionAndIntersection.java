package Hashing;
/*
 * Union and Intersection
 * ======================
 * union
 * -------
 * set1 (U) set2 == unique only
 * 
 * eg: s1 = 1,2,3,4
 * s2 = 4,5,1
 * output==1,2,3,4,5
 * 
 * Intersection
 * --------------
 * set1 (^) set2 == common value only
 * 
 * eg: s1= 1,2,3,4
 *     s2= 1
 * output== 1
 * 
 */
import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();

        //union
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("Union = ");
        System.out.println(set);
        System.out.println("Union size = "+set.size());
        System.out.println();


        //intersection
        System.out.println("Intersection = ");
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set2.add(arr1[i]);
        }
        int count = 0;
        for(int i=0;i<arr2.length;i++){
            if(set2.contains(arr2[i])){
                count++;
                System.out.print(arr2[i]+" ");
                set2.remove(arr2[i]);
            }
        }
        System.out.println();
        System.out.println("size of intersection " +count);
    }
}
