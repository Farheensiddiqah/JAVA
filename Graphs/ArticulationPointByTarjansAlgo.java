package Graphs;
import java.util.*;
/*
 * Articulation Point
 * =================
 * A vertex in an undirected connected graph is an articulation
 * point (or cut vertex) if removing it (and edges through it)
 * increases the connected components of graph.
 * 
 *     1 ----0 ----3
 *     |    /      |
 *     |   /       |
 *     | /         |
 *     2           4
 * 
 * --> Here if we see the example if we remove the 0  and remove all
 * connected edges to 0 then we can observe that the components
 * of the graph increases
 * 
 * -->and the points are called articulation point solved by using Tarjans Algorithm
 * 
 * TARJANS ALGO
 * =============
 * 1.Ancestor and Child
 * --------------------
 * A node A that was discovered before curr node in DFS, is the
 * ancestor of curr 
 * 
 * There are 3 cases that should satisfy to become articulation point
 * 
 * case1 == par == -1 && disconnected children > 1(Ap)
 * 
 * case 2 = dt[u] < low[v]
 * 
 * case 3 = dt[u] = low[v]
 * 
 */
public class ArticulationPointByTarjansAlgo {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //create graph
    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3)); 
    }

    public static void dfs(ArrayList<Edge>[] graph,int curr,int par,int dt[],int low[],int time,boolean vis[],boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh){
                continue;
            } else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            } else {
                dfs(graph, neigh,curr,dt, low, time, vis,ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children>1){
            ap[curr] = true;
        }
    }
    public static void getAp(ArrayList<Edge>[] graph,int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, time, vis,ap);
            }
        }

        //To print ap
        for(int i=0;i<V;i++){
            if(ap[i]){
                System.out.println("AP: "+i);
            }
        }
    }
    public static void main(String[] args) { //O(v+E)
        int V=5;
        ArrayList<Edge>[] graph  = new ArrayList[V];
        creategraph(graph);
        getAp(graph, V);
    }
}
