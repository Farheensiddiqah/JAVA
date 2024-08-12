package BinaryTrees;
import java.util.*;
public class KthAncestor {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int KthAnces(Node root,int n,int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = KthAnces(root.left,n,k);
        int rightDist = KthAnces(root.right,n,k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int maxx = Math.max(leftDist,rightDist);

        if(maxx+1 == k){
            System.out.println(root.data);
        }
        return maxx+1;
    }

    public static void main(String[] args) {
        /*
         *                  1
         *                 / \
         *                2   3
         *              / \   / \
         *             4  5  6  7
         * 
         * int node = 5, int k=2;
         * here 5th node first ancestor is 2
         * and second anscestor is 1
         * 
         * so answer is 1
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n=5;
        int k=2;
        System.out.println("Ancestor of "+n+" in "+k+"nd position is == ");  
        KthAnces(root, n, k);      
    }
}
