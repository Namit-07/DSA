// Problem Statement: Given an undirected graph with V vetices and an adjacency list adj. Determine whether the graph contains a cycle or not. A cycle is a path of edges and vertices wherein a vertex is reachable from itself.
// Logic: We can use Depth First Search (DFS) to detect a cycle in an undirected graph. During the DFS traversal, we keep track of the parent node to avoid counting the immediate back edge to the parent as a cycle. If we encounter a visited node that is not the parent of the current node, we have found a cycle.

package Graphs;

import java.util.*;

public class detectCycleInAUndirectedGraph {
    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, node, visited, adj)){
                    return true;
                }
            }
            // visted neighbor which is not parent means cycle
            else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
    public static boolean hasCycle(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        // Example graph with a cycle
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);
        adj.get(1).add(4);

        if(hasCycle(V, adj)){
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each vertex and edge is processed once.
// Space Complexity: O(V) for the visited array and the recursion stack in the worst case.
