package GreedyAlgo;
/*
 * Given the weights and values of n items put these items
 * in a knapsack of capacity W to get the maximum total value
 * in the knapsack
 * value = [60,100,120]
 * weight = [10,20,30]
 * w=50
 * 
 */
import java.util.*;
public class FunctionalKnapSack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50;

        double ratio[][] = new double[val.length][2];
        //0th col = idx,1st col = ratio

        for(int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalVal = 0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { //include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else{
                //include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("full value = "+finalVal);
    }
}
