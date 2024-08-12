package Graphs;
import java.util.*;
/*
 * Cheapest Flights within K stops (Leetcode 787)
 * ================================
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [from,to,price]
 * indicates that there is a flight. 
 * You are also given three integers src,dst,and k return the chepest
 * price from src to dst within k stops
 * 
 * (All values are positive)
 * 
 *      />1
 *  100/  |
 *    /   |100
 *  0---->2
 *   500
 * 
 * Sample input == 
 * flights = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0,dst = 2,k=1
 * ans = 200
 * 
 * Approach
 * ========
 * 1.Can use both dijkstras or bellman ford
 * 2.Because they are also used to find shortest path
 * 
 * 1.We can use pq or a queue to store (vertex,cost,stops) in info
 * 
 * 2.we stop not stop all paths till last with stops <= k are processed
 * 
 */
public class CheapestFlightsWithinKStops {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void creategraph(int flights[][],ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;

        public Info(int v,int cost,int stops){
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public static int cheapestFlight(int n,int src,int dest,int k,int flights[][]){
        ArrayList<Edge>graph[] = new ArrayList[n];
        creategraph(flights, graph);

        int dist[] = new int [n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        //Modified Dijikstras Algo
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost+wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }

        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        int n=4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int sr = 0,dst = 3,k=1;
        System.out.println(cheapestFlight(n, sr, dst, k, flights));
    }
}
