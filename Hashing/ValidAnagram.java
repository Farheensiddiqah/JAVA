package Hashing;
/*
 * Valid Anagram
 * =============
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise. An anagram is a word or phase formed by rearranging
 * the letters of a different word or phrase, typically using all the 
 * original letters exactly once.
 * 
 * s="race" t ="care"   ==== TRUE
 * s="heart" t="earth"  ==== TRUE
 * s= "tulip" t = "lipid" === false
 */
import java.util.*;

import strings.charAtmethod;
public class ValidAnagram {
    // public static void isAnagram(String s,String t){  //Brute force done by mee
        
    //     TreeMap<Character,Integer> sm = new TreeMap<>();
    //     TreeMap<Character,Integer> tm = new TreeMap<>();

    //     for(int i=0;i<s.length();i++){
    //         char s1 = s.charAt(i);
    //         char t1 = t.charAt(i);
    //         if(sm.containsKey(s1)){
    //             sm.put(s1,(sm.get(s1)+1));
    //         }else{
    //             sm.put(s1,1);
    //         }

    //         if(tm.containsKey(t1)){
    //             tm.put(t1,(tm.get(t1))+1);
    //         } else{
    //             tm.put(t1,1);
    //         }

    //     }

    //     System.out.println(sm);
    //     System.out.println(tm);

    //     int c=0;
    //     for(int i=0;i<s.length();i++){
    //         char s2 = s.charAt(i);
    //         char t2 = t.charAt(i);  
    //         if((sm.get(s2) == tm.get(t2))) {
    //             c++;
    //         }         
    //     }
    //     if(c==s.length()){
    //         System.out.println("True");
    //     }else{
    //         System.out.println("false");
    //     }
    // }

    public static boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                } else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                //if null
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "neek"; //O(n)
        String t = "knee";

        System.out.println(isAnagram(s,t));
        // isAnagram(s, t);


        
    }
}
