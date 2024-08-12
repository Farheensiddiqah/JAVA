package BinaryTrees;
import java.util.*;
/*
 * Left side  and right View of Tree
 * ======================
 *              1
 *             / \
 *            2   3
 *  
 * left view = 1 2
 * 
 * right view = 1 3
 * 
 */
public class RightAndLeftViewTree {
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
    //Left View
    //subFun
    public static void leftView(Node root,int level,ArrayList<Integer> leftList){
        if(root == null){
            return;
        }

        //when level becomes equal to list size then we can print that element 
        //since level will start traversing from the same direction as ---------> left view
        if(level == leftList.size()){
            leftList.add(root.data);
        }

        //since left view so first call left-->  right
        leftView(root.left, level+1, leftList);
        leftView(root.right,level+1,leftList);

    }

    //main
    public static void leftSideView(Node root,int level){
        ArrayList<Integer> leftList = new ArrayList<>();
        leftView(root,level,leftList);

        //to print list
        System.out.println("Left View ==  ");
        for(int i=0;i<leftList.size();i++){
            System.out.print(leftList.get(i)+" ");
        }
        System.out.println();
    }


    //right side view
    //subFun
    public static void rightView(Node root,int level,ArrayList<Integer> rightList){
        if(root == null){
            return;
        }

        //if level == rightList size then print because 
        //we will traverse from  <-------- direction
        if(level == rightList.size()){
            rightList.add(root.data);
        }

        //now since we are printing right view
        //first traverse in right side and then left side
        rightView(root.right, level+1, rightList);
        rightView(root.left, level+1, rightList);
    }
    //main()
    public static void rightSideView(Node root,int level){
        ArrayList<Integer> rightList = new ArrayList<>();
        rightView(root,level,rightList);

        //to print array
        System.out.println("right view ===  ");
        for(int i=0;i<rightList.size();i++){
            System.out.print(rightList.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        /*
         *         1(0)
         *        / \
         *   2(-1)   3(1)
         *      /
         *    4(-2)
         *
         * 
         * from above we can understand that
         * --> for right view
         * direction is        <-------------
         * 
         * --> for left view direction is 
         *      --------------->
         * 
         * so by simply changing recursion logic we can get the data
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        leftSideView(root, 0);
        rightSideView(root, 0);

    }
}


