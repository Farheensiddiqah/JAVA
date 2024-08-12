package Hashing;
import java.util.*;
/*
 * Find Itinerary from Tickets
 * ===========================
 * "Chennai" -> "Bengaluru"
 * Mumbai -> Delhi
 * Goa -> Chennai
 * Delhi -> Goa
 * 
 * output
 * =======
 * Mumbai->Delhi->Goa->Chennai->Bengaluru
 */


public class ItineryTickets { //O(n)
    public static String getstart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }

        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        
        String start = getstart(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()){
            System.out.print("->"+tickets.get(start));
            start = tickets.get(start);
        }
    }
}
