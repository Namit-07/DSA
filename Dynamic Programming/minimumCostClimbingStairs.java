// Problem Statement: You are given an array cost where cost[i] is the cost of ith step on a staircase. You can either start from the step with index 0, or the step with index 1. Once you pay the cost, you can either climb one or two steps. Find the minimum cost to reach the top of the floor. 
// Logic: This problem can be solved using Dynamic Programming by recognizing that the minimum cost to reach the nth step is the cost of the nth step plus the minimum of the costs to reach the (n-1)th and (n-2)th steps.

public class minimumCostClimbingStairs {
    public static int minCostClimbStaris(int[] cost) {
        int n = cost.length;
        if (n == 1)
            return cost[0];

        int prev2 = cost[0]; // Cost to reach step 0
        int prev1 = cost[1]; // Cost to reach step 1

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2); // Minimum cost to reach the current step
            prev2 = prev1; // Update prev2 to be the cost to reach the previous step
            prev1 = curr; // Update prev1 to be the cost to reach the current step
        }
        return Math.min(prev1, prev2); // Minimum cost to reach the top of the floor
    }

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        int result = minCostClimbStaris(cost);
        System.out.println("Minimum cost to reach the top of the floor: " + result);
    }
} 

// Complexity Analysis:
// Time Complexity: O(n) - We compute the minimum cost to reach each step from 0 to n.
// Space Complexity: O(1) - We use only a constant amount of space to store the costs of the previous two steps.