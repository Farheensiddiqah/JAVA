package arrayLists;
import java.util.*;
/*
 * Lonely Numbers in ArrayList(MEDIUM)
 * You are given an integer arraylist nums.A number x is lonely when it appears only once,and no adjacent numbers (i.e. x + 1 and x - 1) 
 * appear in the arraylist.Return all lonely numbers in nums. You may return the answer in any order.
 * Sample Input 1: nums = [10,6,5,8]
 * Sample Output 1: [10,8]
 * Explanation :- 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
 * - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
 * - 5 is not a lonely number since 6 appears in nums and vice versa.Hence, the lonely numbers in nums are [10, 8].Note that [8, 10] may
 *  also be returned.
 */
public class lonelyNumsByAdjacent {
    public static void lonelyNums(ArrayList<Integer> list){
        //Sorting
        Collections.sort(list);
        for(int i=1;i<list.size()-1;i++){
            int inc = list.get(i)+1;
            int dsc = list.get(i)-1;
            if((list.get(i-1) != dsc) && (list.get(i+1) != inc && (list.get(i) != list.get(i-1)) && (list.get(i) != list.get(i+1))) ){
                System.out.println(list.get(i));
            }
        }
        if(list.size() > 1){
             if(list.get(list.size()-2) +1  != list.get(list.size()-1)){
                 System.out.println(list.get(list.size()-1));
             }
             if(list.get(0)+1 < list.get(1)){
                System.out.println(list.get(0));
             }
        }
    }
    //5 6 8 10 = 8 10
    // 1 3 3 5 -moutput=1 5
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(10);
        // list.add(6);
        // list.add(5);
        // list.add(8);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);
        lonelyNums(list);
    }
}
