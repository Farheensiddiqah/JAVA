package arrayLists;
// import java.util.*;
import java.util.ArrayList;
public class syntaxesOperations {
    public static void main(String args[]){
        //Declaration of ArrayLists
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        //Operations
        //1.Add element - O(1)
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        //To add we also have another syntax
        //list1.add(indexno,noTobeadded); //O(n)

        System.out.println(list1);

        //2.Get Element - O(1)
        int element = list1.get(2);
        System.out.println("get elemnt at index 2 is "+ element);

        //3.Remove elemnt - O(n)
        list1.remove(1);
        System.out.println("remove elemnt at index 1 "+list1);

        //4.set - O(n)
        list1.set(0,10);
        System.out.println("set 10 at index 0 "+ list1);

        //5.contains - o(n)
        System.out.println(list1.contains(5));
        System.out.println(list1.contains(11));

        //6.Size function alos gives length
        System.out.println(list1.size());

        //To print arrList
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i));
        }
        System.out.println();
    }
}
