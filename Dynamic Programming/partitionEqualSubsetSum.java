// Problem Statement: Given a set of non-negative integers, determine if it can be partitioned into two subsets such that the sum of elements in both subsets is equal.
// Logic: This problem can be reduced to finding a subset with sum equal to half of the total sum of the array. If such a subset exists, the other subset will automatically have the same sum.

public class partitionEqualSubsetSum {
    public static boolean getTotalSum(int[] nums){
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }
        if(totalSum%2!=0){
            return false; // If total sum is odd, cannot partition into two equal subsets
        }

        int target = totalSum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 always possible with empty subset

        for(int num : nums){
            for(int s=target; s>=num; s--){
                dp[s] = dp[s] || dp[s-num]; // Update dp[s] if sum s can be formed
            }
        }
        return dp[target]; // Return whether subset with sum equal to target exists
    }
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean result = getTotalSum(nums); 
        System.out.println("Can the array be partitioned into two subsets with equal sum? " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*target) - where n is the number of elements in the set and target is half of the total sum. We compute the possibility of forming each sum from 1 to target for each element.
// Space Complexity: O(target) - We use a 1D dp array of size (target+1) to store the possibility of forming each sum, optimizing space usage compared to a 2D approach.
