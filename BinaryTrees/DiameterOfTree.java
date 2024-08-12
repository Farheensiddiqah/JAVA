package BinaryTrees;
/*
 * Diameter of tree
 * =================
 * means no.of nodes in the longest path between
 * 2 leaves
 */
import java.util.*;
public class DiameterOfTree {
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

    //Height Of Tree
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;

    }

    //Approach 1 with tc: O(n^2)
    public static int diameter1(Node root){
        if(root==null){
            return 0;
        }
        int leftD = diameter1(root.left);
        int leftHeight = heightOfTree(root.left);
        int rightD = diameter1(root.right);
        int rightHeight = heightOfTree(root.right);

        int selfDiam = leftHeight+rightHeight+1;

        return Math.max(selfDiam, Math.max(leftD,rightD));
    }

    //Approach 2 -- with O(n) TC
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter2(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam,ht);

    }

    public static void main(String[] args) {
        /*
         *                  1
         *                 / \
         *                2   3
         *              / \   / \
         *             4  5  6  7
         * 
         * Height is 3
         * count of nodes=7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.println("Diameter of the Tree = "+diameter1(root));
        System.out.println("Diameter of the Tree with linear time  = "+diameter2(root).diam);
    }
}
