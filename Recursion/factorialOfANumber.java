// Problem Statement: Calculate the factorial of a number using recursion.
// Logic: Use a recursive function that multiplies the current number by the factorial of the number minus one until it reaches 1.

package Recursion;

public class factorialOfANumber {
    public static int factorial(int n){
        
        if(n==0){
            return 1; // Base case: factorial of 0 is 1
        }
        
        return n * factorial(n - 1); // Recursive call
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + "! is: " + factorial(n));
    }
}

// Complexity Analysis:
// Time Complexity: O(N) - The function makes N recursive calls.
// Space Complexity: O(N) - The recursion stack will hold N function calls at most.