package BinarySearchTrees;

//TC==O(n+m)==linear tc
import java.util.*;
/*
 * given ==  bst1
 *         2
 *        / \
 *       1   4
 * bst2 ===
 *        9
 *       / \
 *      3  12
 * merged============
 *             3
 *            /  \
 *           1    9
 *           \    / \
 *            2  4  12
 * 
 * Now the approach==
 * ------------------
 * 1.BST1 to inorder sequence
 * 2.BST2 to inorder sequence
 * 3.sort both arr1 and arr2(mearge)
 * 4.sorted arr  -> balanced BST
 */
public class MergeTwoBSTs {
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
    //inorder
    public static void getinorder(Node root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        getinorder(root.left,arr);
        arr.add(root.data);
        getinorder(root.right,arr);
    }

    //merge bsts
    public static Node mergebst(Node root1,Node root2){
        //step1==inorder--root1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinorder(root1,arr1);

        //step1==inorder--root2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getinorder(root2,arr2);

        //step 3 ==merge
        int i=0,j=0;
        ArrayList<Integer> finalList = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalList.add(arr1.get(i));
                i++;
            } else{
                finalList.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalList.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalList.add(arr2.get(j));
            j++;
        }
        //step 4 == sorted arr --> balanced bst
        return createBST(finalList, 0, finalList.size()-1);
    }

    //sorted arr -> balanced bsts
    public static Node createBST(ArrayList<Integer> arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr,st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    //to print we use preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        /*
         *         BST1
         *          2
         *         / \
         *        1   4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         * BST========
         *          9
         *         / \
         *        3   12
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        
        Node root = mergebst(root1,root2);

        preorder(root);
    }
}
