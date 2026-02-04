 // Problem Statement: Given an undirected graph, detect if there is a cycle present using BFS.
 // Logic: We can use Breadth-First Search (BFS) to detect a cycle in an undirected graph. During the BFS traversal, we keep track of the parent node to avoid counting the immediate back edge to the parent as a cycle. If we encounter a visited node that is not the parent of the current node, we have found a cycle.
 
package Graphs;
import java.util.*;

public class detectCycleUndirectedGraphBFS{
    public static boolean hasCycle(int n, int[][] edges){
        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // Undirected graph
        }
        boolean[] visited = new boolean[n];

        // Check each component
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                if(bfsCycle(graph, visited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean bfsCycle(List<List<Integer>> graph, boolean[] visited, int start){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // {node, parent}
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];

            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if(neighbor != parent){
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}};
        boolean result = hasCycle(n, edges);
        System.out.println("Graph contains cycle: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each vertex and edge is processed once.
// Space Complexity: O(V), for the visited array and the queue used in BFS.