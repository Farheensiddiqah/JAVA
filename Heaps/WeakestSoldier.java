package Heaps;
/*
 * Weakest soilder
 * ===============
 * We are given an m*n binary matrix of 1's(soilders)
 * and 0's(civilians). The soilders are positioned in front 
 * of the civilians. That is, all the 1swill appear to
 * the left of all the 0s in each row
 * 
 * A row is weaker than a row j if one of the following
 * is true:
 * ->The number of soilders in row i is less than the number
 * of soilders in row j
 * ->Both rows have the same number of soilders and i<j
 * 
 * Find the k weakest rows
 * 
 * input== m=4 n=4 k=2
 *    1 0 0 0
 *    1 1 1 1
 *    1 0 0 0
 *    1 0 0 0
 * ans = row0 and row2
 * 
 */
import java.util.*;
public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soilders;
        int idx;

        public Row(int soilders,int idx){
            this.soilders = soilders;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soilders == r2.soilders){
                return this.idx-r2.idx;
            } else{
                return this.soilders-r2.soilders;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k=2;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count = 0;
            for(int j=0;j<army[0].length;j++){
                if(army[i][j] == 1){
                    count = count+1;
                }else{
                    count = count+0;
                }
            }
            pq.add(new Row(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}
