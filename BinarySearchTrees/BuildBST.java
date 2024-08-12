package BinarySearchTrees;
/*
 * Binary Search Trees
 * ===================
 * 
 * --> It is faster than normal binary Tree because
 * ---> left Side of the trees values are less < than root
 * --->right side values of trees are always  > than root
 * 
 * ---> it satisfies for even all the sub roots also
 * 
 * TC==O(H)---h means height of tree
 * 
 * 
 * but in worst case it can also be O(N)
 * 
 * 
 * HERE WE Can Find ====
 * 1.Search
 * 2.Delete
 * 3.Insert
 * 
 * For Deletion======
 * --> we have 3 cases 
 *       1.leaf node (no childs further) then we can delete directly
 *   2.If subTrees root node then find parent child and attach
 *  3. if root node then find Inorder succesor and replace 
 * Inorder Succesor means
 * ====================
 * --> if we want to delete then the next element which is in right subtree
 * eg: if root node is 5 than delete 7 in sequence of sorted
 *   1 2 3 5 7 9
 */
public class BuildBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    //To insert
    public static Node insert(Node root,int val){
        //first value is node
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subTree
            root.left = insert(root.left,val);
        } else{
            //right subTRee
            root.right = insert(root.right,val);
        }
        return root;
    }

    //To Search
    public static boolean search(Node root,int value){
        if(root == null){
            return false;
        }
        if(root.data == value){
            return true;
        }

        //left subTree Search
        if(root.data>value){
            return search(root.left,value);
        }else{
            //right subTree
            return search(root.right,value);
        }
    }

    //To print the tree
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //To Delete any node
    public static Node delete(Node root,int value){
        if(root.data > value){
            //In left side
            root.left = delete(root.left,value);
        } else if(root.data<value){
            //in right side
            root.right = delete(root.right, value);
        } else{
            //To delete
            //case1 = leaf node
            if(root.left == null && root.right == null){
                return null;
            } 
            //case 2 == child node
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }

            //case 3 == if root value should be deleted
            //Inorder succesor
            Node IS = inorderSuccesor(root.right);
            //since we get next big element from right only
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;

    }
    public static Node inorderSuccesor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] ={5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();
        System.out.println("To search number in Bst");
        System.out.println("================");
        if(search(root,7)){
            System.out.println("Found value");
        } else{
            System.out.println("Not Found");
        }

        System.out.println();
        System.out.println("Delete the node 1");
        root = delete(root,5);
        System.out.println("============");
        inorder(root);
    }
}
