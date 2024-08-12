package Graphs;
import java.util.*;
/*
 * Strongly Connected Components
 * =============================
 * SCC is a component in which we can reach every vertex of the
 * component from every other vertex in that component
 * 
 * -->It is valid only for directed graph
 * 
 * eg === 
 *      
*     1 --->0 -----> 3
 *    ^     |        |
 *    |     |        |
 *    |     |        v
 *    2<-----        4
 * 
 * From above there are 3 strongly connected componenets
 * 1. 0 1 2
 * 2. 3
 * 3. 4
 * 
 * --->So for finding this we use Kosarajus Algorithm
 * --> and can be done using dfs
 * 
 * Steps
 * =====
 * 1. Get nodes in stack (by using topological sort)
 * 2.Transpose the Graph
 * 3. Do DFS according to stack nodes on the transpose graph
 * 
 * Implementation
 * ==============
 * 1. Do topological sort
 *  algo==
 *   topsort{
 *     vis[curr] = true;
 *     for(neighbours){
 *        if(not visited):
 *           topsort(neighbour)
 *     s.push(curr)
 *   }
 * 
 * ==> for above example in stack there are 0,3,4,2,1
 * 
 * 2.Do tanspose 
 * ->transpose means just make reverse 
 *  eg == src--> dest
 * just make dest-->src
 * 
 * 3.Do dfs from stack values
 * 
 * TC===O(V+E)
 */
public class KosarajuAlgoSCC {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //create Graph
    public static void creategraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    //Dfs
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }

    }
    public static void topologicalsort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalsort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    //Kosaraju algo
    public static void kosaraju(ArrayList<Edge>graph[],int V){
        //Step 1
        //Topological sort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topologicalsort(graph, i, vis, s);
            }
        }

        //step 2
        //transpose graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e= graph[i].get(j); //e.src --> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
            }
        }

        //step 3 
        // do dfs from stack
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("SCC --> ");
                dfs(transpose, curr, vis); //to print scc
                System.out.println();
            }
        }

    }
    public static void main(String[] args) { //Tc==O(V+E)
        int V=5;
        ArrayList<Edge> graph[] =new ArrayList[V];
        creategraph(graph);
        kosaraju(graph, V);
    }   
}
