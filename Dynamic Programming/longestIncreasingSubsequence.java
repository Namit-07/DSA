// Problem Statement: Given an array nums, find the length of the longest strictly increasing subsequence(LIS).
// Logic: This problem can be solved using Dynamic Programming by maintaining a 1D array where each cell dp[i] represents the length of the longest increasing subsequence that ends with the element at index i. We iterate through the array and for each element, we check all previous elements to find the longest subsequence that can be extended by the current element.

public class longestIncreasingSubsequence {
    public static int lengthOfLis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will store the length of the longest increasing subsequence that ends with nums[i]

        // every element itself is LIS of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initialize dp[i] to 1 for all i
        }
        int maxLen = 1; // To keep track of the maximum length of LIS found

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update dp[i] if we can extend the subsequence ending at j
                }
            }
            maxLen = Math.max(maxLen, dp[i]); // Update the maximum length of LIS found so far
        }
        return maxLen; // Return the length of the longest increasing subsequence
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        longestIncreasingSubsequence solution = new longestIncreasingSubsequence();
        int result = solution.lengthOfLis(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n^2) - We have two nested loops where the outer loop runs n times and the inner loop also runs up to n times in the worst case.
// Space Complexity: O(n) - We use a dp array of size n to store the length of the longest increasing subsequence that ends with each element.
