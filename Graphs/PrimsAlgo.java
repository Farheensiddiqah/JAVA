package Graphs;
import java.util.*;
/*
 * Minimum Spanning Tree (MST)
============================
A minimum spanning tree (MST) or minimum weight spanning 
tree is a subset of the edges of a connected, 
edge-weighted undirected graph that connects all the 
vertices together, without any cycles and with the minimum
possible total edge weight

--> Note==  1.Subgraph,2.No cycle,3.Vertices connected,4.weight(minimum)


Eg====          0
          10  / | \ 15
             /  |  \
            1   |30 2
             \  |  /
          40  \ | / 50
                3

 ANS===  Edges== 0,1,2
         cost = 55

 Approach to find minimum spanning Tree
 ==========================================
 1. boolean vis[] array
 2.Pq (vertex and cost)--minPair
 3.add first pq.add(0,0)
 4.while(pq!Empty){
    curr-->(V,cost)
    if(not visited){
        vis
        mast (add edge or wt)
        call for neighours
    }
 }
 */
import java.util.*;
public class PrimsAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest =dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v,int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void prims(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost = 0; //mst cost/total min wgt

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost+=curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println("Final(min) cost == "+finalCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        creategraph(graph);
        prims(graph);
    }
}
