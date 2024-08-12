package arrayLists;
import java.util.*;
//Inbuilt function to sort
// Collections.sort(listname);
public class sortingArr {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println("Before sort "+ list);

        //Inbuilt sort---For Ascendind order
        Collections.sort(list);
        System.out.println("After sort in ascending "+list);

        //Inbuilt for decending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("After sort in decinding order "+list);
    }
}
