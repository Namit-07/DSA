// Probem Statement: Implement Union-Find data structure to determine connectivity between nodes in a graph.
// Logic: The Union-Find (Disjoint Set Union) data structure helps in managing and merging sets. It supports two main operations: 'find' to determine the root of a set, and 'union' to merge two sets. This is useful for checking connectivity in graphs.

package Graphs;

public class unionFindForConnectivity {

    int[] parent;
    int[] rank;

    // Constructor
    unionFindForConnectivity(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    // Find with path compression
    int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }
    // Union by rank
    boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return false; // cycle connected

        if(rank[px]<rank[py]){
            parent[px] = py;
        } else if(rank[py]<rank[px]){
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 5;
        unionFindForConnectivity uf = new unionFindForConnectivity(n);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println("Are 0 and 2 connected? " + (uf.find(0) == uf.find(2))); // true
        System.out.println("Are 0 and 3 connected? " + (uf.find(0) == uf.find(3))); // false
        
    }
}

// Complexity Analysis:
// Time Complexity: O(α(N)) per operation, where α is the Inverse Ackermann function, which grows very slowly. Thus, for practical purposes, it can be considered almost constant time.
// Space Complexity: O(N) for storing the parent and rank arrays.
