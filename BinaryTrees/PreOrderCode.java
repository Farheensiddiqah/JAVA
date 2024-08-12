package BinaryTrees;
import java.util.*;
//TC==O(n)
public class PreOrderCode {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //PreOrdee == root left and right
        public static void preOrder(Node root){ //O(n)
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
       }

       //InOrder == left root right
       public static void inOrder(Node root){
           if(root==null){
              return;
           }
           inOrder(root.left);
           System.out.print(root.data+" ");
           inOrder(root.right);
       }

       //Postorder -- left right root
       public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");  
       }

       //Level Order Traversal
       public static void levelOrder(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            //till queue is not empty 
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }

       }
    }



    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data); //To print root Node
        
        //preorder
        System.out.println("Pre Order is ---");
        tree.preOrder(root);

        //inOrder
        System.out.println();
        System.out.println("InOrder is ----");
        tree.inOrder(root);

        //postOrder
        System.out.println();
        System.out.println("Post Order is ---");
        tree.postOrder(root);

        //level Order
        System.out.println();
        System.out.println("Level Order is ---");
        tree.levelOrder(root);

    }
}
