package BinaryTrees;
import java.util.*;
/*  LOWEST COMMON ANCESTOR
    ============================
 *   Ancestor ====
 *  means print all its parents and grand parents
 *  till it reaches the root of the trees
 *   
 * example:    if the tree given as
 *                       1
 *                      / \
 *                     2   3
 *                    / \   \
 *                   4  5    6
 *  and given n1 = 4 and n2 = 6
 * 
 * so now ancestors of 4 == 4 2 1
 *                     6 == 6 3 1
 *  
 * APProach 1
 * ==========
 * -->Now in approch 1 we will traverse and store 
 * --->n1 ancestors in one array and n2 ansectors in another array
 * ------>now we can compare two arrays 
 * ----> By comparing when we find the lowest common number
 * -----> thnen we can print that as an answer
 */
public class LowestCommonAncestor {
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
    //Approch 1--TC:O(n) && but space complexity is more
    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root == null){
            return false;
        }

        //add rooot node first
        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right,n,path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root, n2, path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node ans = path1.get(i-1);
        return ans;

    } 


    //Approach2 --linear Sc and Tc
    public static Node lca2(Node root,int n1,int n2){
        //Base case
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        //if leftLca = value and rightlca = null
        if(rightlca == null){
            return leftlca;
        }
        //if rightlca==value and leftlca==null
        if(leftlca == null){
            return rightlca;
        }

        //if not found in leftlca and rightlca 
        return root;
    }

    //MINIMUM DISTANCE BETWEEN TWO NODES
    public static int lcaDist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left,n);
        int rightDist = lcaDist(root.right,n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        } else{
            return leftDist+1;
        }

    }
    public static int minDistance(Node root,int n1,int n2){
        //First find lowest common ancestor
        Node lca = lca2(root,n1,n2);

        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1+dist2;
    }

    public static void main(String[] args) {
        /*
         *                      1
        *                      / \
        *                     2   3
        *                    / \   \
        *                   4  5    6
         */

        Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.right = new Node(6);
         int n1=4;
         int n2=6;
         System.out.println("The lowest common ansectors of n1 and n2 are");
         System.out.println("Using approach 1 is "+lca(root,n1,n2).data);
         System.out.println("Using approach 2 is " +lca2(root,n1,n2).data);

         System.out.println("Minimum Distance betweeen two nodes n1 and n2 are == ");
         System.out.println(minDistance(root,n1,n2));
    }
}
