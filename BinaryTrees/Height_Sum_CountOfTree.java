package BinaryTrees;
import java.util.*;
public class Height_Sum_CountOfTree {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    //To calculate height of the tree
    public static int height(Node root){
        if(root==null){
            return 0;
        }

        //Calculate left height by recursion
        int lh =  height(root.left);
        //Calculate right height by recursion
        int rh = height(root.right);
        //Take max of two
        return Math.max(lh,rh)+1;
    }

    
    //To calculate the count of nodes
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        //left nodes calculation
        int lc = count(root.left);
        //right count calculation
        int rc = count(root.right);
        return (lc+rc)+1;
    }

    //To calculate sum
    public static int sumOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfTree(root.left);
        int rightSum = sumOfTree(root.right);
        return leftSum+rightSum+root.data;
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

        System.out.println("Height of the Tree is  =  "+height(root));
        System.out.println("Count of Nodes in a tree is = "+count(root));
        System.out.println("Sum of the total nodes in tree is =  "+ sumOfTree(root));
    }
}
