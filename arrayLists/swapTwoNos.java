package arrayLists;
import java.util.*;
public class swapTwoNos {
    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp = list.get(idx1);
        // idx1 = idx=2;
        // idx2 = temp 

        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);

    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        int idx1 = 1, idx2 = 3;
        System.out.println("Before Swapped "+list);
        swap(list,idx1,idx2);
        System.out.println("Swapped indexes are 1 and 3 "+list);
    }
}
