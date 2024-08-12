package BinarySearchTrees;
/*
 * if a range is given to print n1 and n2
 * we should print the values which are there in the tree
 */
public class PrintRangeOfValueBST {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
        }
    }


    //To print in a range
    public static void printRange(Node root,int start,int end){
        if(root == null){
            return;
        }
        if(root.data >= start && root.data <= end){ //case 1 
            printRange(root.left,start,end);
            System.out.print(root.data+" ");
            printRange(root.right,start,end);
        }else if(root.data < start){
            //righht side
            printRange(root.right,start,end);
        } else if(root.data > start){
            //left side
            printRange(root.left,start,end);
        }
    }

    //To insert
    public static Node insert(Node root,int value){
        //To insert first element
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data < value){
            root.right = insert(root.right,value);
        }
        if(root.data > value){
            root.left = insert(root.left, value);
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
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();
        System.out.println("print all range ");
        printRange(root, 5, 12);

        System.out.println();
    }
}
