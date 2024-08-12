package GreedyAlgo;
/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second
 * number. A pair (c,d) can come after the pair(a,b) if b<c.
 * Find the longest chain which can be formed from the given set of pairs.
 * 
 * pairs = (5,24) (39,60) (5,28) (27,40) (50,90)
 * ans = 3
 * 
 * Approch == This question is similar to the Activity Selection question we can visulize by that diagram
 * TC== O(nlogn)
 */
import java.util.*;
public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        //sort
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        //how ever we can add first pair so
        int chainLen = 1;
        int chainEnd = pairs[0][1]; //used for comparing first from the above qn example pair end is now 24

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max Length of the chain length = "+chainLen);

    }
}
