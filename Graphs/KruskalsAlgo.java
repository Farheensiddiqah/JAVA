package Graphs;
import java.util.*;
/*
 * Kruskals algorithm
 * ==================
 * -->Updated version for finding minimum spanning tree
 * --> Using Greedy approcah
 * --> also updated version of prims algorithm
 * 
 * Eg==
 * 
 *              0
          10  / | \ 15
             /  |  \
            1   |30 2
             \  |  /
          40  \ | / 50
                3

 ANS===  Edges== 0,1,2
         cost = 55
 * 
 * Approach
 * =========
 * 1.Sort edges
 * 2.take minimum cost edge
 * 3. assure that no cycle is formed
 * 4. and include in ans
 * 
 * approach TC==O(v+ElogE)
 * ========
 * 1.Al<Edge> -->collections.sort()
 * 2.for(i=0 to (v-1)) , v=vertexs(nodes){
 *     edges== 1. a (src) 2. b (dest)
 *     take parA, parB
 *     if(parA==parB):
 *            same--> donot consider (no cycle must be there)
 *        diff --> union(parA,parB)
 * }
 * 
 * 
 */
public class KruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }

    //create Graph
    public static void creategraph(ArrayList<Edge>edges){
        //edges
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    //See disJointSet ds for explanation
    static int n=4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    //initialization
    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }

    //find
    public static int find(int x){
        if(par[x] == x){
            return x;
        }

        return par[x] = find(par[x]);
    }

    //union
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(parA==parB){
            par[parB] = parA;
        } else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        } else{
            par[parB] = parA;
        }
    }

    //TC== O(v+ElogE)
    public static void kruskalMST(ArrayList<Edge> edges,int V){
        init();
        Collections.sort(edges); //O(ElogE)
        int mstCost = 0;
        int count = 0;

        for(int i=0;count<V-1;i++){ //O(V)
            Edge e= edges.get(i);
            //src,dest,wt

            int parA = find(e.src); //src=a
            int parB = find(e.dest); //dest =b
            if(parA != parB){
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        creategraph(edges);
        kruskalMST(edges, V);
    }
}
