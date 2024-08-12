package BinarySearchTrees;

public class SizeOfLargestBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max=max;
        }
    }

    //intialize with 0
    public static int maxBst = 0;

    public static Info largestBST(Node root){
        //base case
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftinfo = largestBST(root.left);
        Info rightinfo = largestBST(root.right);
        //size
        int size = leftinfo.size +rightinfo.size+1;
        //min
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        //max
        int max = Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));
        //isvalid
        if(root.data <= leftinfo.max || root.data >= rightinfo.min){
            return new Info(false,size,min,max);
        }
        if(leftinfo.isBST && rightinfo.isBST){
            maxBst = Math.max(maxBst,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }

    public static void main(String[] args) {
        /*
         *            50
         *           /  \
         *          30  60
         *         /\   / \
         *        5 20  45 70
         *                 /\
         *                65 80
         * given bst
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80); 

        /*
         * expected bst with nodes as 
         * ans = 5(size)
         *           60
         *          /  \ 
         *         45  70
         *             /\
         *            65 80
         */
        Info info = largestBST(root);
        System.out.println("largest bst of size == "+maxBst);
    }
}
