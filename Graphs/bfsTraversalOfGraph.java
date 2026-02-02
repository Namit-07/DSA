// Problem Statement: Given a graph, print all nodes using BFS starting from node 0.
// Logic: Use a queue to implement BFS and a boolean array to keep track of visited nodes.

package Graphs;
import java.util.*;

public class bfsTraversalOfGraph {
    static void bfsTraversal(int start, ArrayList<ArrayList<Integer>> graph, int V){
        boolean[] visited = new boolean[V]; // keep track of visited nodes
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true; // mark the starting node as visited
        q.add(start); // enqueue the starting node

        while(!q.isEmpty()){
            int node = q.poll(); // dequeue a node
            System.out.println(node + " "); // process the current node

            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){ // if neighbor is not visited
                    visited[neighbor] = true; // mark it as visited
                    q.add(neighbor); // enqueue the neighbor
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Adding edges to the graph
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        System.out.println("BFS Traversal starting from node 0:");
        bfsTraversal(0, graph, V);
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and the queue in the worst case.