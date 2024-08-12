package BinaryTrees;
/*
 * SubTree of another Tree
 * =========================
 * Given the roots of two binary trees root and subroot,
 * return true if there is subtree of root
 * with the same structure and node values of subroot
 *  and false otherwise
 * 
 * input=====
 * 
 *  Normal Tree   1
 *               / \
 *              2   3
 *             /\    \
 *            4  5    6
 * 
 * subtree==      2
 *               /\
 *              4  5
 * 
 * >>> It is a subTree
 * 
 * Approch 
 * ==========
 * 
 * -> 1.First find subroot in the tree
 * -->2.check if identical (subTree,node of tree)
 * 
 *---> here to check wheather identical or not
 ---> we can check using
 *  some non identical conditions were we can return false
 *  1...(if(node.data)!=subroot.data)  
 *  2..(node == null) || (subRoot==null)   ===or if any nodes next data becomes 
 *         null and other tree has some value
 *  3.leftsubtree --> non identical
 *  4. rightsubtree -->becomes non identical
 *  Because if non identical means complete tree becomes non identical
 */
import java.util.*;
public class SubTreeOfAnotherTree {
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
    
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        } else if(node == null || subRoot==null || node.data != subRoot.data){
            return false;
        }

        //if left Subtree returns non identical
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        //if right subtree says not identical then false
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    
    public static boolean isSubTree(Node root,Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        //here we have checked  wheather left subtree  and tree same and right side tree same
        //if any one is same also from or condition we will get true
        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);

    }
    public static void main(String[] args) {
        /*
         *  Normal Tree   1
         *               / \
         *              2   3
         *             /\    \
         *            4  5    6 
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.right = new Node(6);

         /*
          *    2
              / \
             4   5

          */
          Node subRoot = new Node(2);
          subRoot.left = new Node(4);
          subRoot.right = new Node(5);
          System.out.println("Is the subTree of another Tree =  "+isSubTree(root,subRoot));
          
    }
}
