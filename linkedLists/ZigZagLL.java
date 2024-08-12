package linkedLists;
import java.util.LinkedList;

import linkedLists.LinkedList.Node;
/*
 * For a linked List: L(1)->L(2)->L(3)...L(n-1)->L(n)
 * convert to zig zag as
 * L(1)-> L(n)->L(2)->L(n-1)->L(3)->L(n-2);
 */
public class ZigZagLL {
    public static Node head;
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
        LinkedList ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        //1 2 3 4 5
        // System.out.println(ll);
        // ll.head = ll.zigZagFun();
        

    }

}
