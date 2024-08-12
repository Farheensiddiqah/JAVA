package Heaps;
/*
 * Heaps
 * =====
 * visualize --> heap(using binary Trees)
 * Implement --> array
 * 
 * Heap must satisfy following conditions
 * ======================================
 * 
 * 1.Binary Tree
 * --------------
 * at most 2 children
 * 
 * 2.Complete Binary Tree
 * ----------------------
 * Complete Binary Tree is a Binary Tree in which all the levels are
 * completely filled expect possibly the last one, which is filled 
 * from the left to right
 * 
 * 3.Heap Order Property
 * ======================
 * children >= parent(minHeap)
 * children <= parent(maxHeap)
 * 
 * Note
 * -----
 * 1. Here we wont implement heaps in trees with classes nodes
 * because the time complexity becomes more
 * 2.And here one property is defined as
 *   if(node )index = i is given(parent--> child)
 *    leftChild = 2i+1
 *    rightchild = 2i+2
 * 3.If child (x)  ---> parent ((x-1)/2)
 */
import java.util.*;
public class HeapImplementation {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){//O(logn)
            //add at last index
            arr.add(data);

            int x= arr.size()-1; //x is child index
            int par = (x-1)/2; //parent index

            while(arr.get(x) < arr.get(par)){ //O(logn)------->can change min to max
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minidx = i;

            if(left < arr.size() && arr.get(minidx) > arr.get(left)){ //----->can change to < in arr.get(mindx) >arr.get(left)
                minidx = left;
            }

            if(right < arr.size()  && arr.get(minidx) >  arr.get(right)){ //------>same here also change in second condition
                minidx = right;
            }

            if(minidx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);

                heapify(minidx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //step 1 - swap first and last 
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 --delete last
            arr.remove(arr.size()-1);

            //step-3--heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
