package Heaps;
import java.util.*;
/*
 * Near by cars(or near by type of any qn in 2d axis)
 * =============
 * ----->We are given N points in a 2d plane which
 * are locations of N cars. If we are at the origin,
 * print the nearest K cars.
 * 
 *      c2|   c0
 * -  ----------
 *        |    c1
 * 
 * given c0(3,3) , c1(5,-1), c2(-2,4)  and k=2
 * 
 * in represntation  as above 
 * 
 * we can find the distance with the formula
 *  Math.sqrt((X)^2+(y)^2)
 */       
public class NeabyKcars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        int idx;
        public Point(int x,int y,int disSqrt,int idx){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.dist -p2.dist;  //ascending order sorting
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int dist = pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0],pts[i][1],dist,i));
        }

        //nearest K cars
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().idx);
        }
    }
}
