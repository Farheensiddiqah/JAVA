package linkedLists;
public class LinkedList {
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

    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //When reached to previous node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //To remove First node
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    //To remove Last Element
    public int removeLast() {
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            int val=head.data;
            head = tail = null;
            size=0;
            return val;
        }
        //prev = i=size-2
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;
    }

    //To print LL
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

    //Iterative method of searching
    public int itrSearch(int key){ //O(n)
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

    //Reverse a LL
    public void reverse(){ //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Delete Nth Node from end
    public void deleteNthNodeFromEnd(int n){
        //Calculate size
        int sz=0;
        Node temp =head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        //If n==sz
        if(n==sz){
            head = head.next; //Remove first
            return;
        }
        //sz-n
        int idx=1;
        int idxToFind = sz-n;
        Node prev = head;
        while(idx < idxToFind){
            prev = prev.next;
            idx++;
        }
        prev.next = prev.next.next;
        return;
    }

    //To find mid Node
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next; //+1 step
            fast = fast.next.next; //+2 step
        }
        return slow; //Slow is mid Node
    }

    
    //Code To Check palindrome or not
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //Step1 - findMid
        Node midNode = findMid(head);
        //step2 - reverse 2nd Half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right side head
        Node left = head;
        //step3 - check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //Detecting wheather it is a cycle or not
    //Also known as a floyds algo
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true; //Cycle exists
            }
        }
        return false; //cycle doesnt exists
    }

    //if Cycle is detected then remove that cycle
    public static void removeCycle(){
        //Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next=null;
        prev.next=null;
    }

    //MERGE SORT
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //mid
    }
    private Node merge(Node head1,Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(head1 != null && head2 != null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1=head1.next;
                temp=temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }
    //Merge sort
    public Node mergeSort(Node head){
        if(head==null || head.next == null){
            return head;
        }
        //find Mid
        Node mid = getMid(head);
        //left and right Merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }

    //ZigZag
    public void zigZagFun(){
        //Find Mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //Reverse 2nd Half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;
        //alt merge - zig zag merge
        while(left != null && right !=  null){
            nextL=left.next;
            left.next = right;
            nextR=right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // System.out.println("Size of ll "+ll.size);
        // ll.print();
        // ll.removeFirst();
        // System.out.println("Size of ll "+ll.size);
        // ll.print();
        // ll.removeLast();
        // System.out.println("Size of ll "+ll.size);
        // ll.print();
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // ll.print(); 
        // ll.reverse();
        // System.out.println("REVERSE OF LL");
        // ll.print(); //Did reverse
        // ll.deleteNthNodeFromEnd(2);
        // System.out.println("Delete from end");
        // ll.print();

        // //Check Palindrome
        // //Seperately by undo everything 
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();
        // //1->2->2->1
        // System.out.println("checkPalindrome");
        // System.out.println(ll.checkPalindrome());

        //To check isCycle
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // //1->2->3->1
        // System.out.println(isCycle());

        //To check remove cycle
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // //1->2->3->2
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        //To check Merge Sort
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // //5 4 3 2 1
        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZagFun();
        System.out.println("In Zig Zag Format");
        ll.print();

    }
}
