package Graphs;
/*
 * Cycle Detection
 * =================
 * ->Undirected Graph
 * 
 * There are 3 cases to check cycle detection
 * -------------------------------
 * case1 : Already vis[neighbour]  ------(True)(cycle detected)
 *         and parent not same 
 * 
 * case 2: already visited[neighbour]
 *         and parent same            ------(falsee) (cycle not detected)
 * 
 * Egg == here we can say that cycle not detected because
 * if we observe for this example
 *          
 *               0
 *               |
 *               2 --- 4 (here parent same bcz 2 first vist 0 and 4 )
 *   -> but we can observe that there is no pattern that cycle is detected
 * 
 * case 3 : didnot visited neighbour
 *   ----then just visit and make true
 *         
 */
import java.util.*;
public class CycleDetection {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void create(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        //0 - vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        //1 vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        //2-vertex
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        //3-vertex
        graph[3].add(new Edge(3,0));

        //4 vertex
        graph[4].add(new Edge(4,2));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean [graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                    //cycle exits
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr] =true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            //case 3
            if(!vis[e.dest] ){
                if(detectCycleUtil(graph, vis,e.dest,curr)){
                    return true;
                }
            }
            //case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
            //case 3
            //just do nothing
        }
        return false;
    }
    /*
     *     0 --- 3
     *   / |
     * 1   |
     *  \  | 
     *     2----4
     */
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);
        System.out.println(detectCycle(graph));
    }
}
