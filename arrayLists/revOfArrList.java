package arrayLists;
import java.util.*;
public class revOfArrList {
    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        for(int i=arr.size()-1;i>=0;i--){ //O(n)
            System.out.print(arr.get(i)+" ");
        }
    }
}
