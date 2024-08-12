package BinarySearchTrees;
import java.util.*;
/*
 *              8
 *             / \
 *            5   10
 *           / \    \
 *          3  6    11
 *                    \ 
 *                     14
 * --> here we get 3 paths
 *  1 . 8 5 3
 *  2. 8 5 6
 *  3. 8 10 11 14
 *    
 */
public class RootToLeafPathBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data= data;
        }
    }
    //Root to leaf ka path
    public static void rootToLeafPath(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right==null){
            printPath(path);
        }

        rootToLeafPath(root.left,path);
        rootToLeafPath(root.right,path);

        path.remove(path.size()-1);

    }
    //To print the path
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"-> ");
        }
        System.out.println("null");
    }

    //To insert
    public static Node insert(Node root,int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data < value){
            //add in right
            root.right = insert(root.right,value);
        }
        
        if(root.data > value){
            //add in left
            root.left = insert(root.left,value);
        }
        return root;
    }

    //To print
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<>();
        int values[] = {8,5,3,6,10,11,14};

        Node root= null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        rootToLeafPath(root, path);

    }
}
