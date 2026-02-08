// Problem Statement: Given a number n, find the nth Fibonacci number using Dynamic Programming(Top Down).
// Logic: We will use memoization to store the results of previously computed Fibonacci numbers to avoid redundant calculations.

import java.util.*;

public class Fibonacci{
    // Memoization array
    int[] dp;
    // Function to compute nth Fibonacci number
    public int fib(int n){
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    // Helper function for recursion with memoization
    private int solve(int n){
        // Base cases
        if(n<=1) return n;

        // Already computed
        if(dp[n]!=-1) return dp[n];

        // Recursive computation with memoization
        dp[n] = solve(n-1) + solve(n-2);
        return dp[n];
    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 10; // Example input
        int result = fibonacci.fib(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n) - Each Fibonacci number from 0 to n is computed only once.
// Space Complexity: O(n) - The space used for the memoization array.