// Problem Statement: Implement Dijkstra's algorithm to find the shortest path from a source node to all other nodes in a weighted graph.
// Logic: Dijkstra's algorithm uses a priority queue to explore the nearest unvisited node and updates the shortest path to its neighbors. It continues this process until all nodes have been visited.

package Graphs;
import java.util.*;

public class Dijkstra {
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;   
        }
    }
    public static int[] dijkstra(int n, int[][] edges, int src){

        // Build graph
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        // Add edges
        for(int[] e : edges){
            graph.get(e[0]).add(new Pair(e[1], e[2]));
            graph.get(e[1]).add(new Pair(e[0], e[2])); // For undirected graph
        }
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);
        pq.add(new Pair(src,0));

        // Dijkstra's Algorithm
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.dist;

            // Ignore if we have already found a better path
            if(currDist>dist[node]) continue;

            // Explore neighbors
            for(Pair nei : graph.get(node)){
                int newDist = currDist + nei.dist;
                if(newDist<dist[nei.node]){
                    dist[nei.node] = newDist;
                    pq.add(new Pair(nei.node, newDist));
                }
            }
        }
        return dist; // Return distances from source to all nodes
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 3},
            {1, 2, 1},
            {1, 3, 2},
            {2, 1, 4},
            {2, 3, 8},
            {2, 4, 2},
            {3, 4, 7},
            {4, 3, 9}
        };
        int src = 0;
        int[] distances = dijkstra(n, edges, src);
        System.out.println("Shortest distances from source node " + src + ":");
        for(int i=0; i<distances.length; i++){
            System.out.println("To node " + i + " - Distance: " + distances[i]);
        }
    }
}

// Complexity Analysis:
// Time Complexity: O((E + V) log V), where E is the number of edges and V is the number of vertices. The log V factor comes from the priority queue operations.
// Space Complexity: O(V + E) for storing the graph and O(V) for the distance array and priority queue. 
