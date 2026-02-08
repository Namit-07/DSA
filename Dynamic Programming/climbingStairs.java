// Problem Statement: You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Logic: This problem can be solved using Dynamic Programming by recognizing that the number of ways to reach the nth step is the sum of the ways to reach the (n-1)th and (n-2)th steps.

import java.util.*;

public class climbingStairs{
    public static int climbStairs(int n){
        if(n <= 1) return 1; // Base case: There is one way to climb 0 or 1 step

        int[] dp = new int[n + 1]; // Create a DP array to store the number of ways to climb to each step
        dp[0] = 1; 
        dp[1] = 1; 

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2]; 
        }
        return dp[n]; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of steps: ");
        int n = sc.nextInt();
        int result = climbStairs(n);
        System.out.println("Number of distinct ways to climb to the top: " + result);
        sc.close();
    }
}

// Complexity Analysis:
// Time Complexity: O(n) - We compute the number of ways to climb to each step from 2 to n.
// Space Complexity: O(n) - We use an array of size n+1 to store the number of ways to climb to each step.