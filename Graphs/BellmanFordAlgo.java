package Graphs;
/*
 * Bellman Ford Algorithm
 * =========================
 * Shoertest paths from the source to all vertices(negative edges)
 * 
 * NOTE===(IMP)
 * -->Here the cycle formed then the sum should not be equal to negative value
 * -->If we get sum == negative value
 * (bellman Ford Algo) cant be performed
 * 
 * -->Dijkstras algo cant be used for negative indixes
 * 
 *            -1
 *  2 / > 1 <-------4
 *   /    |         ^
 * 0      |-4       |
 *   \    |         | 4
 *  4 \   V         |
 *      > 2--------> 3 
 *             2
 * 
 * 
 * Approach
 * ========
 * Perform V-1 operations
 * 
 * make dis array
 * intialize with +infy first
 * and find all edges(u,v)
 *     if dis[u] + wt(u,v) < dis[v]
 *         dis[v] = dis[v] + wt(u,v)
 * 
 */
import java.util.*;
public class BellmanFordAlgo {
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

    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph,int src){
        int dis[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        //algo
        //O(V*E)
        for(int i=0;i<V-1;i++){//O(v)
            //Take edges --O(E)
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e= graph[j].get(k);
                    //u,v,wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //relaxation
                    if(dis[u] != Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v] = dis[u]+wt;
                    }
                }
            }
        }
        //print
        for(int i =0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        creategraph(graph);
        bellmanFord(graph, 0);
    }
}
