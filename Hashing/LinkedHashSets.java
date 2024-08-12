package Hashing;
/*
 * Linked List
 * ===========
 * ->ordered using doubly linked list
 * -->order means what ever we add we get that only first
 * 
 * performance
 * ============
 * LinkedHashMap < HashMap
 * LinkedHashSet < HashSet
 * 
 * if we dont want order better to use just hashmap
 */
import java.util.*;
public class LinkedHashSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Hyderabad");
        cities.add("Bengaluru");
        System.out.println("Using hashSets");
        System.out.println(cities);   
        
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Hyderabad");
        lhs.add("Bengaluru");
        System.out.println("using LinkedHashSet");
        System.out.println(lhs);

    }
}
