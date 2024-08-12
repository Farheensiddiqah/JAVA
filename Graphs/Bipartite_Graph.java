package Graphs;
import java.util.*;
/*
 * Bipartite Graph (2 parts)
 * ================
 * A bipartite Graph is a graph whose vertices can be divided into
 * two independent sets, U and V such that every edge (u,v) 
 * either connects a vertex from u to v or a vertex from V to u.
 * In other words, for every edge (u,v), either u belongs to U and V,
 * or u belongs to V and v to U. We can also that there is no edge 
 * that there is no edge that connects vertices of same set
 * 
 * Approach =========
 *            0 
 * 1)       /  \ 
 *         1     2
 *          \   /
 *            3
 * 
 * 
 *  Set1(U)      Set2(V)
 *  (yellow)      (blue)
 *   0             1
 *   3             2     (True) --->bcz we can divide in 2 parts
 * 
 * 2)      
 *           0
 *         /   \
 *        1     \
 *        \      2
 *         \    /
 *          3--4
 * 
 *  set1(U)   set2(V)    (False)--bcz we cant divide in 2 parts
 *  (yellow)  (blue)
 *   0          1
 *   3          4
 *   2
 * 
 * Approach
 * ========
 * 1.by using 2 different colours like yellow and blue
 * 2.seperate them by colours in sets
 * 
 * 3.Using bfs we will assign first (-1)
 * where (-1) means first no colour is assigned
 * 
 * 4.and then first start with source and set 0(means yellow colour)
 * and then in next level as bfs process using queue add numbers in queue
 * and set the neighbours with another colour as (1 as blue) colour
 * 
 * 5.Then after colouring or whike colouring there comes these 3 cases
 * 
 * IMP
 * ===
 * CaSe1 :  neigbour colour and present colour are same
 *         ans =  print false directly
 * case2 : neighbour colour and present colour different 
 *         ans = continue
 * case3 : if neighbour doesnot habe any colour
 *         ans = just give different colour
 * 
 * Another approach
 * ===============
 * 1) Acyclic -- True 
 * That means if the graph is not cuclic then it is bipartite graph
 * 2) if even cycle  -- true
 * (it is bipartite graph)
 * 3)odd cycle -- false
 * (not bipartite graph -- cant divide in two parts)
 * 
 */
public class Bipartite_Graph {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src= src;
            this.dest = dest;
        }
    }
    
    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        //0 vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        //1 vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        //2 vertex
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        //3 vertex
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        //4 vertex
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
    }

    //bipartite graph
    public static boolean bipartiteGraph(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length]; //colour filling array
        for(int i=0;i<col.length;i++){
            col[i] = -1; //no colour intially
        }

        //yellow 0
        // //1 blue

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){//BFS
            if(col[i] == -1){
                q.add(i);
                col[i] = 0; //yellow 
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j); //e.dest
                        //case 3
                        if(col[e.dest] == -1){
                            int nextcol = col[curr] == 0? 1 :0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]){
                            //case 1 (if neighbour and curr same)
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*
         *  *           0
            *         /   \
            *        1     \
            *        \      2
            *         \    /
            *          3--4 
            false
         */

         int V=5;
         ArrayList<Edge> [] graph = new ArrayList[V];
         creategraph(graph);
         System.out.println(bipartiteGraph(graph));
    }
}
