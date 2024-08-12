package arrayLists;
import java.util.*;
/*
 * Find if any pair in a sorted ArrayList has a target sum
 * list = [1,2,3,5,6], target =5;
 */
public class pairSum1 {
    public static boolean bruteForcePairSum1(ArrayList<Integer> list,int target) {
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j) == target){
                    return true;
                }

            }
        }
        return false;
    }
    public static boolean pairSumOptimized(ArrayList<Integer> list,int target){
        int lp=0;
        int rp = list.size()-1;
        while(lp!=rp){
            int sum = list.get(lp)+list.get(rp);
            //case1
            if(sum== target){
                return true;
            }
            //case2
            if(sum < target){
                lp++;
            } else{
                //case3
               rp--;  
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(bruteForcePairSum1(list, target));
        System.out.println(pairSumOptimized(list,target));
    }
}
