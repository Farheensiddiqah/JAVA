package GreedyAlgo;
/*
 * chocola Problem
 * =============
 * 
 * We are given a bar of Chocolate Composed of m*n square
 * pieces. One should break the Chocolate into single squares.
 * Each break of a part of the choclate is charged
 * a cost expressed by a positive integer. This cost
 * does not depend on the size of the part that is being 
 * broken but only depends on the line the break goes along. Let
 * us donate the costs of breaking along consecutive vertical
 * lines with x1,x2....xm-1 and along horizantal lines
 * with y1,y2,.....yn-1.
 * Compute the minimal cost of breaking the whole chocolate 
 * into single squares
 * 
 * consider chocolate
 *    |      |
 * ---------------y1
 *    |      |
 * ---------------y2
 *    |      |
 *    x1    x2
 * 
 * 
 * Approch
 * =======
 * Observations
 * ============
 * 1. we have to do all cuts ---> oders of cuts may change
 * 2.After each cut --> chocolate pieces increases 
 * --> and also expensive must be cut first
 * --->and cheap must be cut later
 * 3.Cost of vertical cuts ---> horizantal Pieces*x;
 * 4.cost of horizantal cuts ---> Vertical Pieces*y;
 * 
 * 
 */  
import java.util.*;
public class ChocolaProblem {
    public static void main(String[] args) {
        int n=4,m=6;
        Integer costVer[] ={2,1,3,1,4}; //m-1
        Integer costHor[] ={4,1,2}; //n-1

        //sort in descending order
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;

        while(h < costHor.length && v < costVer.length){
            //vertical cost < hor cost
            if(costVer[v] <= costHor[h]){ //horizantal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else{//vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        //remaining horizantal cuts
        while(h<costHor.length){
            cost += (costHor[h] *vp);
            hp++;
            h++;
        }
        //remaining vertical cuts
        while(v<costVer.length){
            cost += (costVer[h] *hp);
            vp++;
            v++;
        } 
        System.out.println("Minimum cost of cuts = "+ cost);       
    }
}
