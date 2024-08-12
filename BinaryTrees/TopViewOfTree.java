package BinaryTrees;
import java.util.*;
/*
 *  TopView in trees means  we should print the elements that we will we able to see if
 * we keep any lens and see from upwards
 * 
 * Sample Tree:    
 *             1
 *            / \
 *           2   3
 *          /\   /\
 *         4  5  6  7
 * --> from above sample tree we can tell the top view nodes are
 *   4 5 1 3 7
 * --> we can see 5 and 6 because in the real time view they will be in the same line
 * 
 * 
 * 
 * Approach
 * ========
 * 1.HashMap
 * 2.Horizantal Axis(-1,0,1)..
 * 3.Level Order traversal to check
 * 
 * --> Here we will use HashMap DSA in this problem
 * ---> and then we will use horizantal axis property
 * --> where from the horizantal axis we can divide root node as 0
 * as:                 1(0)
 *                     / \
 *                2(-1)  3(+1)
 *                /  \     / \
 *            4(-2) 5(0) 6(0) 7(2) ----->Using axis property
 * 
 * 
 * ---> And then we will use level order traversal and check wheather 
 * it is repeted or not if number is not repeted then print otherwise dont print
 *
 */
public class TopViewOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info{
        Node node;
        //Horizantal Distance
        int hd;
        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){//First time my horizantal distance occuring
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }                
            }


        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        /*
         *  *          1
         *            / \
         *           2   3
         *          /\   /\
         *         4  5  6  7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
        
         topView(root);


    }
}
