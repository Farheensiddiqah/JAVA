package BinarySearchTrees;

public class SortedArrToBalancedBST {
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
    //sorted array to balanced BST
    public static Node sortArrToBalanceBST(int arr[],int st,int end){
        //base case
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);

        root.left = sortArrToBalanceBST(arr,st,mid-1);
        root.right = sortArrToBalanceBST(arr,mid+1,end);
        return root;
    }

    //To print preorder function
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        /*
         *         8
         *        / \
         *       5   11
         *      / \   / \ 
         *     3  6  10 12
         * expecred balanced bst
         */

         Node root = sortArrToBalanceBST(arr,0,arr.length-1);

         preorder(root);
    }
}
