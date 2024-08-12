package Tries;
/*
 * Prefix Problem (IMP) --Microsoft and google
 * ================
 * Find the shortest unique prefix for every word
 * in a given list
 * Assume no word is prefix of another
 * 
 * arr[] = {"zebra","dog","duck","dove"};
 * ans = {"z","dog","du","dov"}
 * 
 * approch
 * ========
 * 1.create a trie
 * 2.Take frequency count
 * 3.if frequency count found as 1
 * then break it till there and print
 */
public class PrefixProblem { //TC==O(L)
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            freq= 1;
        }
    }

    public static Node root = new Node();

    //insert
    public static void insert(String word){
        Node curr = root;
        for(int level = 0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            } else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root,String ans){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i] != null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra","dog","duck","dove"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }

        root.freq = -1;
        findPrefix(root,"");
    }
}
