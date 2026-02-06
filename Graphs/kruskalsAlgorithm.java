// Problem Statement: Implement Kruskal's algorithm to find the Minimum Spanning Tree (MST) of a connected, undirected graph.
// Logic: Kruskal's algorithm sorts all edges in non-decreasing order of their weight and adds them one by one to the MST, ensuring no cycles are formed using the Union-Find data structure.

package Graphs;
import java.util.*;

public class kruskalsAlgorithm {
    // Supporting Edge class
    static class Edge{
        int u, v, wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    // Union-Find (Disjoint Set Union) class
    static class UnionFind{
        int[] parent, rank;
        // Constructor
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        // Find with path compression
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        // Union by rank
        boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            
            if(rank[px]<rank[py]){
                parent[px] = py;
            } else if(rank[px]>rank[py]){
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }
    // Kruskal's Algorithm
    public static int kruskal(int n, List<Edge> edges){
        // Sort edges by weight
        Collections.sort(edges, (a,b)-> a.wt - b.wt);

        // Initialize Union-Find
        UnionFind uf = new UnionFind(n);
        int mstWeight = 0;
        int edgesUsed = 0;

        // Iterate through sorted edges
        for(Edge e : edges){
            if(uf.union(e.u, e.v)){
                mstWeight += e.wt;
                edgesUsed++;
                if(edgesUsed == n-1) break; // MST complete
            }
        }
        return mstWeight;
    }
    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int mstWeight = kruskal(n, edges);
        System.out.println("Weight of Minimum Spanning Tree: " + mstWeight);
    }
}

// Complexity Analysis:
// Time Complexity: O(E log E) due to sorting the edges, where E is the number of edges.
// Space Complexity: O(V) for the Union-Find data structure, where V is the number of vertices.
