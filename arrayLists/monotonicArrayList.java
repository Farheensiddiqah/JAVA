package arrayLists;
import java.util.*;
//Monotonic means either incresing or decresing number
public class monotonicArrayList {
    public static boolean monotonicfun(ArrayList<Integer> list){
        for(int i=0;i<list.size()-2;i++){
            if((list.get(i) >= list.get(i+1)) && (list.get(i+1) >= list.get(i+2))){
                return true;
            }else if((list.get(i) <= list.get(i+1)) && (list.get(i+1) <= list.get(i+2))){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(monotonicfun(list));
    }
}
