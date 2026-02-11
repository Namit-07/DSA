// Problem Statement: Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
// Logic: This problem can be solved using Dynamic Programming by recognizing that the maximum value that can be obtained with a given capacity can be expressed as the maximum of the value obtained by including the current item (if it fits) and the value obtained by excluding the current item.

public class knapsackOptimized {
    public static int knapsack(int[] weights, int[] values, int W){
        int n = weights.length;
        int[] dp = new int[W + 1];

        for(int i=0; i<n; i++){
            for(int w=W; w>=weights[i]; w--){
                dp[w] = Math.max(dp[w],
                    values[i] + dp[w - weights[i]]
                );
            }
        }
        return dp[W];
    }
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int W = 50;
        int result = knapsack(weights, values, W); 
        System.out.println("Maximum value in Knapsack: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*W) - where n is the number of items and W is the capacity of the knapsack. We compute the maximum value for each item and each capacity from 1 to W.
// Space Complexity: O(W) - We use a 1D dp array of size (W+1) to store the maximum values for each capacity, optimizing space usage compared to the 2D approach.