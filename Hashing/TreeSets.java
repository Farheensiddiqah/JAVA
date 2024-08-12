package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 * TreeSet
 * =========
 * Sorted as ascending order
 * 
 * Null values are not allowed
 * 
 * ->internnaly redblack trees 
 * are used and to implement hashMap
 * ->Hashmaps are used to implement hashSet
 * 
 * HashSet,LinkedHashSet===allows null value
 * 
 */
import java.util.*;
public class TreeSets {
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
        
        TreeSet<String> tm = new TreeSet<>();
        tm.add("Delhi");
        tm.add("Mumbai");
        tm.add("Hyderabad");
        tm.add("Bengaluru");
        System.out.println("Tree Set");
        System.out.println(tm);
    }
}
