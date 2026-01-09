// Problem Statement: Given an array of stock prices where the ith element represents the price of a stock on day i, find the maximum profit you can achieve by buying and selling the stock once.
// Logic: Traverse the array while keeping track of the minimum price seen so far and calculate the maximum profit at each step.

public class buyStocks {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE; // Best price to buy the stock
        int maxProfit = 0;  // Maximum profit achievable

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;   // Update the minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};;
        System.out.println(maxProfit(prices));
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once to find the maximum profit.
// Space Complexity: O(1) - No extra space is used.
