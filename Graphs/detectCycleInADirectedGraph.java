// Problem Statement: Given a directed graph with V vertices and an adjacency list adj. Determine whether the graph contains a cycle or not. A cycle is a path of edges and vertices wherein a vertex is reachable from itself.
// Logic: We can use Depth First Search (DFS) to detect a cycle in a directed graph. During the DFS traversal, we maintain a recursion stack to keep track of the nodes currently in the recursion stack. If we encounter a node that is already in the recursion stack, we have found a cycle.

package Graphs;

import java.util.*;

public class detectCycleInADirectedGraph {
    static boolean dfs(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj){
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, visited, recStack, adj)){
                    return true;
                }
            }
            // back-edge found
            else if(recStack[neighbor]){
                return true;
            }
        }
        recStack[node] = false; // backtrack
        return false;
    }
    public static boolean hasCycle(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, visited, recStack, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        // Example graph with a cycle
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        if(hasCycle(V, adj)){
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each vertex and edge is processed once.
// Space Complexity: O(V), for the visited and recursion stack arrays.