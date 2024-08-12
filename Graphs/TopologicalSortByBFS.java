package Graphs;
import java.util.*;
/*
 * Topological sort using dfs
 * ==========================
 * (Kahn's algorithm)
 * 
 *  eg:
 *       5      4
 *       | \   / |
 *       |  V V  |
 *       |   0   |
 *       V       V
 *       2-->3-->1     
 * 
 * Concept of in degree and outdegree
 * 
 * 1.in degree == incomming value
 *  eg: for 0 incomming is 2(1. from 5->0)(2.from 4->0)
 * 2.outgoing == outgoing values
 * 
 * Approch
 * ============
 * 1.By using one indegree array and a queue
 * we can solve like
 * 
 * solve == 210 leetcode qn
 *       
 */
public class TopologicalSortByBFS {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calcIndeg(ArrayList<Edge>[] graph,int[] indeg){
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topsort(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        } 

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" "); //topological sort print

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        creategraph(graph);
        topsort(graph);
    }
}
