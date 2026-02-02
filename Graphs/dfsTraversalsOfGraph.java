// Problem Statement: Given a graph, print all nodes using DFS starting from node 0.
// Logic: Use a stack to implement DFS and a boolean array to keep track of visited nodes.

package Graphs;

import java.util.*;

public class dfsTraversalsOfGraph {
    static void dfsTraversal(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true; // mark current node as visited
        System.out.print(node + " "); // process the current node

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){  // if neighbor is not visited
                dfsTraversal(neighbor, visited, graph); // recursive call
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

        boolean[] visited = new boolean[V];
        System.out.println("DFS Traversal starting from node 0:");
        dfsTraversal(0, visited, graph);
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and the recursion stack in the worst case.
