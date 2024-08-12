package BinarySearchTrees;
//TC==O(n)
import java.util.*;
public class ConvertBSTtoBalancedBST {
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
    
    //preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //Inorder
    public static void inorder(Node root,ArrayList<Integer> sortlist){
        if(root == null){
            return;
        }
        inorder(root.left,sortlist);
        sortlist.add(root.data);
        inorder(root.right,sortlist);
    }

    //create sorted array --> balanced bst
    public static Node createBST(ArrayList<Integer>sortlist,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(sortlist.get(mid));
        root.left = createBST(sortlist,st,mid-1);
        root.right = createBST(sortlist,mid+1,end);
        return root;
    }

    //Bst to balanced Bst
    public static Node bstToBalancedBST(Node root){
        //find inorder--to get sorted arr
        ArrayList<Integer> sortlist = new ArrayList<>();
        inorder(root,sortlist);

        //now make sorted list -> balanced bst 
        root =createBST(sortlist,0,sortlist.size()-1);
        return root;
    }

    public static void main(String[] args) {
        /*
         *             8
         *            / \
         *           6  10
         *          /    \
         *          5     11
         *         /       \
         *        3         12
         * given bst
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = bstToBalancedBST(root);
        preorder(root);

        /*
         *             8
         *            / \
         *           5   11
         *          /\    /\
         *         3  6  10 12
         * expected bst
         */
    }
}
