package Hashing;
import java.util.*;
/*
 * LinkedHashMap
 * =============
 * Keys are insertion done in ordered
 * 
 * --> Because in hashmap we use array with linkedlist
 * and cannot be stored sequentially
 * 
 * IMPORTANT
 * ============
 * --> but then we use doubly LinkedList to store indexes
 * so that we can get ordered wise
 * 
 * 
 * ->rest all is same as hashMap
 */
public class LinkedHashMaping {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm  = new LinkedHashMap<>();
        lhm.put("India",150);
        lhm.put("China",100);
        lhm.put("USA",50);

        System.out.println(lhm);


    }
}
