package Graphs;
import java.util.*;
/*
 * ALL PATHS FROM SOURCE TO TARGET
 * ===============================
 * For (Directed Graph)
 * 
 * Given src = 5 and dest = 1
 *   
 * eg:
 * 
 *  *  eg:
 *       5      4
 *       | \   / |
 *       |  V V  |
 *       |   0   |
 *       |   |   |
 *       V   V   V
 *       2-->3-->1 
 * 
 * paths from 5 to 1 are
 *   5 0 3 1 
 *   5 2 3 1
 * 
 * TC=== O(v^(V))--for worst case
 */
public class AllPathFromSrcToDest {
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

        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void printallPaths(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            printallPaths(graph, e.dest, dest, path+src);
        }
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        creategraph(graph);
        int src = 5,dest = 1;

        printallPaths(graph, src, dest,"");
    }
}
