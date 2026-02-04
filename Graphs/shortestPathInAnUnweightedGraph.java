// Problem Statement: Given an unweighted graph, find the shortest path between two nodes.
// Logic: Use Breadth-First Search (BFS) to explore the graph level by level, keeping track of the distance from the starting node to each visited node. The first time we reach the target node, we can return the distance as the shortest path length.

package Graphs;
import java.util.*;

public class shortestPathInAnUnweightedGraph {
    public static int[] shortestPath(int n, int[][] edges, int src){
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // Undirected graph
        }
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;

        while(!queue.isEmpty()){
            int node = queue.poll(); // Dequeue a node

            for(int neighbor : graph.get(node)){
                if(dist[neighbor] == -1){
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        int src = 0;
        int[] distances = shortestPath(n, edges, src);
        System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(distances));
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each vertex and edge is processed once.
// Space Complexity: O(V), for the distance array and the queue used in BFS.
