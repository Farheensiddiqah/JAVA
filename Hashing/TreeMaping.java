package Hashing;
import java.util.*;
/*
 * Tree Map
 * =========
 * Keys are sorted automatically
 * put,get,remove are O(logn)
 * 
 * NOTE-IMP
 * ========
 * ->the internal data structure used for tree map
 * is Red Black Trees which is(sel balancing tree)
 */
public class TreeMaping {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",100);
        tm.put("China",150);
        tm.put("America",50);
        tm.put("Indonesia",100);

        System.out.println(tm);
    }
}
