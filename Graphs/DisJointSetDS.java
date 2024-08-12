package Graphs;
import java.util.*;
/*
 * Disjoint set Data structure or (Union Find DS) or (Merge DS)
 * =============================
 * --->Mainly used to (find and union operations)
 *   1. Find (Which set element belongs to)
 *   2. Union (Join)
 * -->Also used to store and track == non overlapping sets
 * 
 * Implementation
 * ==============
 * 1. For example take n=8 means 8 elements there
 * 2. make an array of rank(height) to store the ranks
 * 3. Make an array of parents to store parents data
 * 4.And firstly make all the numbers that are parent to them self 
 * 5.And make all ranks(height) as zero
 * 
 * -->Used to compreesion of path 
 * 
 * TC=== O(4K) -- or O(1)
 */
public class DisJointSetDS { //Tc==O(4k) or O(1)
    static int n=7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    //initialization
    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }

    //find function
    public static int find(int x){
        //base case
        if(x == par[x]){
            return x;
        }

        // return find(par[x]);
        //path compression
        return par[x] = find(par[x]);
    }

    //union function
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        //To make parent
        //if same value == can make anyone parent
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        } else{
            par[parB] = parA;
        }

    }
    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);

    }
}
