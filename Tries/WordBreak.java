package Tries;
/*
 * WORD BREAK PROBLEM(Most impp = google asked)
 * ==================
 * Given an input string and a dictionary of words, find out
 * if the input string can be broken into a space seperated sequence
 * of dictionary words.
 * 
 * words[] = {i,like,sam,samsung,mobile,ice}
 * key = "ilikesamsung"
 * 
 * output = true
 */
public class WordBreak {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    //insert
    public static void insert(String word){
        Node curr = root;
        for(int level = 0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    //search
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0;level<key.length();level++){
            int idx = key.charAt(level)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //word break
    public static boolean wordBreaks(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            //can compare here using two substrings
            //S(0,1) and S(i)
            if(search(key.substring(0, i)) && wordBreaks(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i","like","sam","samsung","mobile","ice"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        String key = "ilikesamsung";
        
        System.out.println(wordBreaks(key));
    }
}
