package Graphs;
import java.util.*;
/*
 * Topological Sorting
 * ===================
 * Directed Acyclic Graph(DAG) is a directed graph with no cycles.
 * Topological sorting is used only for DAGs (not for non-DAGs).
 * It is a linear order of vertices such that every directed edge
 * (u -> v) the vertex u comes before v in the order.
 * 
 * 
 * Example
 * =======
 *   
 *    5      4
 *   | \    / |
 *   |  V  V  |
 *   V    0    V
 *   2-->3--->1
 * 
 * Here we use dfs appraoch along with a stack to store
 * 
 */
public class TopologicalSortByDFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));   
    }

    public static void topsort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){ //modified dfs
                topsortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void topsortUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
   public static void main(String[] args) {
    int V=6;
    ArrayList<Edge> [] graph = new ArrayList[V];
    creategraph(graph);
    topsort(graph);
   } 
}
