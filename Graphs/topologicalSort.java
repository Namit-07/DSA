// Problem Statement: Given a directed acyclic graph (DAG) with V vertices and an adjacency list adj, perform a topological sort on the graph. A topological sort is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before vertex v in the ordering. (Kahn's Algorithm)
// Logic: We can use Depth First Search (DFS) to perform a topological sort. During the DFS traversal, we add each vertex to a stack after all its neighbors have been visited. Finally, we pop vertices from the stack to get the topological ordering.    

package Graphs;
import java.util.*;

public class topologicalSort{
    public static List<Integer> topoSort(int V, List<List<Integer>> adj){
        int[] indegree = new int[V];

        // Step 1: Calculate indegree of each vertex
        for(int i=0; i<V; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }
        // Step 2: Initialize queue with all vertices having indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();

        // Step 3: BFS Traversal
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoOrder.add(node);

            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        // Step 4: Cycle check
        if(topoOrder.size() != V){
            System.out.println("Graph contains a cycle, topological sort not possible");
            return new ArrayList<>();
        }
        return topoOrder;
    }
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        // Example DAG
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> topoOrder = topoSort(V, adj);
        System.out.println("Topological Sort Order: " + topoOrder);
    }
}

// Complexity Analysis:
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each vertex and edge is processed once.
// Space Complexity: O(V) for the indegree array, queue, and the result list.