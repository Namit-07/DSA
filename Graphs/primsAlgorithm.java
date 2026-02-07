// Problem Statement: Given a connected, undirected graph with weighted edges, find the minimum spanning tree (MST) using Prim's algorithm.
// Logic: Prim's algorithm builds the MST by starting from an arbitrary vertex and repeatedly adding the smallest edge that connects a vertex in the MST to a vertex outside the MST until all vertices are included.

package Graphs;
import java.util.*;

public class primsAlgorithm {
    // Helper class to represent a pair of (node, weight)
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static int primMST(int n, int[][] edges){
        // Build graph
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // Add edges
        for(int[] e : edges){
            graph.get(e[0]).add(new Pair(e[1], e[2]));
            graph.get(e[1]).add(new Pair(e[0], e[2]));
        }
        // Prim's Algorithm
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0)); // Start from node 0 with weight 0
        int mstWeight = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;

            if(visited[node]) continue;

            visited[node] = true;
            mstWeight += wt;

            for(Pair nei : graph.get(node)){
                if(!visited[nei.node]){
                    pq.add(new Pair(nei.node, nei.weight));
                }
            }
        }
        return mstWeight;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        int mstWeight = primMST(n, edges);
        System.out.println("Total weight of MST: " + mstWeight);
    }
}

// Complexity Analysis:
// Time Complexity: O(E log V), where E is the number of edges and V is the number of vertices. Each edge is processed once, and inserting into the priority queue takes O(log V) time.
// Space Complexity: O(V + E) for storing the graph and the priority queue.
