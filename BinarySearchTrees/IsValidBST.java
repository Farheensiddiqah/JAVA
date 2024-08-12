package BinarySearchTrees;
/*
 * To check wheather given bst is valid or not
 * we can check in 2 approaches
 * 1. approch == 
 *   if we print inorder traversal we should get sorted numbers
 * 
 * 2.approch==
 *  check if max value in left subtree < node and
 *   min value in right subtree > node
 */
public class IsValidBST {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
        }
    }

    //Is Valid BST
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left,min,root) && isValidBST(root.right, root, max);
    }

    //To insert
    public static Node insert(Node root,int value){
        //To insert first element
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data > value){
            root.left = insert(root.left,value);
        }else {
            root.right = insert(root.right, value);
        }

        return root;
    } 

    //To print we use inorder Traversal
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        // int values[] = {8,5,3,6,10,11,14}; //valid caase
        int values[] = {1,1,1};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }

    }
}
