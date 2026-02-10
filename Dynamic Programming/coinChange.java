// Problem Statement: Given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money, return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// Logic: This problem can be solved using Dynamic Programming by recognizing that the minimum number of coins needed to make up a certain amount can be expressed as the minimum of the number of coins needed to make up the amount minus each coin denomination plus one (for the coin itself).

import java.util.*;

public class coinChange {
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1); // Initialize dp array with a value greater than the maximum possible coins
        dp[0] = 0; // Base case: 0 coins needed to make up amount 0

        for(int i=1; i<=amount; i++){
            for(int coin : coins){
                if(i - coin>=0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Update dp[i] with the minimum coins needed
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; // Return -1 if amount cannot be made up, else return minimum coins
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 6, 10};
        int amount = 11;
        int result = coinChange(coins, amount); 
        System.out.println("Fewest number of coins needed: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*m) - where n is the amount and m is the number of coin denominations. We compute the minimum coins for each amount from 1 to n, and for each amount, we iterate through all coin denominations.
// Space Complexity: O(n) - We use a dp array of size amount + 1 to store the minimum coins needed for each amount.
