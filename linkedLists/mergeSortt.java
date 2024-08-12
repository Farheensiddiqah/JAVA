package linkedLists;
import java.util.LinkedList;

import linkedLists.LinkedList.Node;
public class mergeSortt {
    public static Node head;
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
    public static void main(String[] args) {
        LinkedList ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //5 4 3 2 1
        // System.out.println(ll);
        // ll.head = ll.mergeSort(ll.head);
        // System.out.println(ll);
    }
}
