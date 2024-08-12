package BinaryTrees;
import java.util.*;
/*
 * Left side View of Tree
 * ======================
 *              1
 *             / \
 *            2   3
 *  
 * left view = 1 3
 * 
 */
public class LeftViewOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach 1
    static int maxLevel = 0;
    public static void leftView(Node root,int level,ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        //If maxLevel<level then we can print that max number
        if(maxLevel < level){
            ans.add(root.data);
            maxLevel=level;
        }
        leftView(root.left,level+1,ans);
        leftView(root.right,level+1,ans);
    }
    public static void view(Node root,int level){
        ArrayList<Integer> ans = new ArrayList<>();
        leftView(root,level,ans);        
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i));
        }
    }
    public static void main(String[] args) {
        /*
         *         1(0)
         *        / \
         *   2(-1)   3(1)
         * 
         * from above we can understand that the maximum number in level we should print
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        int level=1;
        view(root, level);
    }
}
