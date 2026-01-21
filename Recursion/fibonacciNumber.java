// Problem Statement: Calculate the Nth Fibonacci number using recursion.
// Logic: Use a recursive function that returns the sum of the two preceding Fibonacci numbers until it reaches the base cases of 0 or 1.

package Recursion;

public class fibonacciNumber {
    public static int fib(int n){
        if(n==0){
            return 0; // Base case: Fibonacci of 0 is 0
        }
        if(n==1){
            return 1; // Base case: Fibonacci of 1 is 1
        }

        return fib(n - 1) + fib(n - 2); // Recursive call
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));
    }
}

// Complexity Analysis:
// Time Complexity: O(2^N) - The function makes two recursive calls for each non-base case, leading to an exponential number of calls.
// Space Complexity: O(N) - The recursion stack will hold N function calls at most.