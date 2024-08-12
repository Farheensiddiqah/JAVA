package GreedyAlgo;
/*
 * Question
 * =========
 * You are given n activities with their start and end times.
 * Select the minimum number of activities that can be 
 * performed by a single person, assuming that a person can 
 * only work on a single activity at a time.Activities are sorted according
 * to the end time
 * 
 * Importantly:  given end time is Sorted other wise another code can be found in this folder
 * 
 * Input:
 * Start = [10,12,20]
 * end = [20,25,30]
 *  
 * output:
 * ans = 2(A0 & A2) //Tc:0(n)
 * --> the main target is that we should select lines without over lapping
 * 
 * 
 *      -----20 to 30
 *    ---- 12 to 25
 *  ---- 10 to 20
 *  |  |   |
 * 10  20  30
 */
import java.util.*;
public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //end time basics sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        //we can always add the first index directly to ans
        maxAct=1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=0;i<end.length;i++){
            if(start[i]>=lastEnd){
                //activity can be selected
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("maximum activites that can be performed are = " + maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
