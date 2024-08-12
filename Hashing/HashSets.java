package Hashing;
import java.util.*;
/*
 * It is same as hashmap
 * =======================
 * ->But set means no duplicates (unique) elements
 * -> unordered map
 * ->Nulls are allowed
 * 
 * Implementation
 * ==============
 * 
 * sets -> are implemented using maps 
 * maps -> implementation is used as shown
 * 
 */
public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        
        set.add(1);
        set.add(2);
        set.add(6);
        set.add(6);
        set.add(1);

        System.out.println(set);

        set.remove(1);

        if(set.contains(1)){
            System.out.println("set contains 2");
        } else{
            System.out.println("doesnt contains 2");
        }

        set.clear();
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
