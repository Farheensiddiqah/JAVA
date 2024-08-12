package Hashing;
/*
 * Operations
 * ===========
 * ->All in linear time O(1)
 * 1.put(key,value);
 * 2.get(value);
 * 3.containsKey(key);
 * 4.remove(key)
 * 
 * 
 * -->It is unordered map
 * 
 * intilization==
 * HashMap<KeyData_type,ValueData_type> hm = new HashMap<>();
 * 
 * for iteration
 * ===========
 * Set<Integer> Keys = hm.keySet();
 */
import java.util.*;
public class HashMapOperations {
    public static void main(String[] args) {
        //Create HashMap
        HashMap<String,Integer> hm = new HashMap<>();

        //insert--O(1)
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        //Using Loop
        for(String k: keys){
            System.out.println("Keys "+k+",values= "+hm.get(k));
        }

        System.out.println(hm);

        //get--O(1)
        int population = hm.get("India");
        System.out.println(population);

        //containsKey--O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("UK"));

        //remove--O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //clear
        hm.clear();

        //isEmpty()
        System.out.println(hm.isEmpty());



        
    }
}
