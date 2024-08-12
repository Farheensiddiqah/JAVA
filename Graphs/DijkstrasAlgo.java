package Graphs;
import java.util.*;
/*
 * Dijkstras Algorithm
 * ===================
 * Shortest paths from the source to all vertices
 * (weighted graph)
 * -->By using greedy algo we can solve
 * 
 * eg==
 *           7
 *     >(1)------>(3)
 *  2 / |         ^ \ 1
 *  (0) |1       2|  \>
 *  4 \ v         |  > (5)
 *     >(2)----->(4)/5
 *          3
 * 
 * The qn is we have to find the shortest path from src to each destination
 * 
 * eg == if source is given as 0
 * 
 * Approach
 * =========
 *      2 (+infy)  4   (+infy)
 *  (0) --> (1) ---> (4)
 *  src      
 * 
 * dist[u] + weight(u,v) < dist[v]
 * == dist[v] == dist[u] + wt(u,v)
 * 
 * 1.First initialize with +infinity and then apply these eqns and do calculate
 * 
 */
public class DijkstrasAlgo { //Tc==O(V+ElogV) log bcq we used pq
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //path based sorting for my pairs
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph,int src){
        int dis[] = new int[graph.length]; //dist[i] -> src to i
        boolean vis[] = new boolean[graph.length]; 
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE; //+ infinity
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                //neighbours
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt = e.wt;
                    if(dis[u]+wt < dis[v]){  //update src to v
                        dis[v] = dis[u]+wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }

        //print all distances
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
        
    } 
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        creategraph(graph);
        dijkstra(graph, 0);
    }
}
