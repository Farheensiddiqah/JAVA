package linkedLists;

public class SearchKeyInLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Step1 = create new node
        Node newNode = new Node(data);
        size++;
        //If there is no nodes
        if(head==null){
            head=tail=newNode;
            return;
        }
        //Step2 = newNode next = head
        newNode.next = head; //link

        //step3 = head = newNode
        head = newNode;

    }
    public void addLast(int data){
        //1.Create a newNode first
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            return;
        }
        //Step2-
        tail.next = newNode;
        //step3-
        tail = newNode;
    }


    public int itrSearch(int key){
        Node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        //Key not found
        return -1;
    }

    //Recursive method of searching
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    
    public void print(){ //O(n)
        if(head == null){
            System.out.println("LL is Empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2,3);
        ll.print();
        System.out.println(ll.recSearch(3));
        System.out.println(ll.recSearch(10));

    }
}
