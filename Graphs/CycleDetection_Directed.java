package Graphs;
import java.util.*;
/*
 * Cycle Detection(Directed Graphs)
 * ================================
 * Approach of directed and undirected are not same
 * if we use the same appraoch we get the different answer
 * 
 *  Cycle
 * =========
 *      1------> 0-->3 
 *               |  /\  (cycle)
 *               |  /
 *               V /
 *               2 
 * 
 * 
 * no cycle
 * ==========
 *           0
 *          / \
 *         /   \
 *        V     V
 *       2      1   (no cycle)
 *       \      /
 *         \   /
 *          V V
 *           3
 * 
 * Approach
 * =========
 * using dfs only by here we will be using 
 * 1.stack,2.visited for marking
 * and detecting
 * 
 * 
 * 
 */
public class CycleDetection_Directed {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> [] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                //cycle
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] =  new ArrayList<>();
        }

        //Graph of cycle case from above
        //0 vertex
        graph[0].add(new Edge(0,2));

        //1 vertex
        graph[1].add(new Edge(1,0));

        //2 vertex
        graph[2].add(new Edge(2,3));

        //3 vertex
        graph[3].add(new Edge(3,0));

    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> [] graph = new ArrayList[V];
        creategraph(graph);
        System.out.println(isCycle(graph));
    }
}
