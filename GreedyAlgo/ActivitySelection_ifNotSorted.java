package GreedyAlgo;

import java.util.ArrayList;
import java.util.*;

/*
 * Question
 * =========
 * You are given n activities with their start and end times.
 * Select the minimum number of activities that can be 
 * performed by a single person, assuming that a person can 
 * only work on a single activity at a time.Activities are not sorted according
 * to the end time
 * 
 * Importantly:  Given an unsorted array of endtime
 * 
 * Input:
 * Start = [10,12,20]
 * end = [20,25,30]
 *  
 * output:
 * ans = 2(A0 & A2) //Tc:0(n)
 */
public class ActivitySelection_ifNotSorted {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //Since not sorted do sorting
        int activities[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //sorting using a lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basics sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        //we can always add the first index directly to ans
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=0;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                //activity can be selected
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("maximum activites that can be performed are = " + maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
