package arrayLists;
import java.util.*;
public class maxOfArr {
    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(3);
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            // if(mx < arr.get(i)){
            //     mx = arr.get(i);
            // }
            mx = Math.max(mx,arr.get(i));
        }
        System.out.print("Max no is " + mx);
    }
}
