// Problem Statement: Print numbers from 1 to N using recursion.
// Logic: Use a recursive function that prints the current number and then calls itself with the next number until it reaches N.

package Recursion;

public class printNumber1ToN {
    public static void printNumbers(int n){

        if(n==0){
            return; // Base case: if n is 0, stop the recursion
    }
        printNumbers(n-1); // Recursive call with n-1 and also we have to call before print to get 1 to N
        System.out.print(n + " "); // Print the current number after the recursive call
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Printing numbers from 1 to " + n + ":");
        printNumbers(n);
    }
}

// Complexity Analysis:
// Time Complexity: O(N) - The function makes N recursive calls.
// Space Complexity: O(N) - The recursion stack will hold N function calls at most.