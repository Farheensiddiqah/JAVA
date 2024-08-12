package Hashing;
import java.util.*;
public class HashSet_Iterations {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Hyderabad");
        cities.add("Bengaluru");

        //method 1 
        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        System.out.println();

        //method 2 
        for(String city: cities){
            System.out.println(city);
        }
    }
}
