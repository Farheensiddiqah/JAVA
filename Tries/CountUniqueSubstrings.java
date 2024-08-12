package Tries;
/*
 * Count Unique Substrings(IMP--Microsoft,Google)
 * =====================
 * Given a string of length n of lowercase alphabet characters,
 * we need to count total number of distinct substrings of this 
 * strings
 * 
 * str = "ababa"
 * ans = 10
 * 
 * First cut suffix
 * ===================
 * ->For abcdef
 *     bcdef
 *      cdef
 *        def
 *         ef
 *          f
 * 
 * ->        (Take all prefix of this suffix)
 *   ababa - a ab aba abab ababa
 *   baba -  b ba bab baba  
 *    aba - a ab aba
 *     ba - b ba
 *      a - a
 * 
 * --> Remove duplicates and add " " empty string and print
 * 
 * Approach==
 * ========
 * 1.substring == all prefix of all suffix ==all suffix of 
 * 2.unique prefix == count of node of tries
 */
public class CountUniqueSubstrings {
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

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }
    public static void main(String[] args) {
        String str = "ababa";

        //suffix -> insert in trie
        for(int i=0;i<str.length();i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}
