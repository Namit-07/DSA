// Problem: Given a set of non-negative integers and a value sum, determine if there is a subset of the given set with sum equal to the given sum.
// Logic: This problem can be solved using Dynamic Programming by maintaining a boolean array that tracks which sums can be formed using the elements of the set.

public class subsetSum{
    public static boolean subsetSum(int[] nums, int target){
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 always possible with empty subset

        for(int num : nums){
            for(int s=target; s>=num; s--){
                dp[s] = dp[s] || dp[s-num]; // Update dp[s] if sum s can be formed
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 11;
        boolean result = subsetSum(nums, target);
        System.out.println("Subset with sum " + target + " exists: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*target) - where n is the number of elements in the set and target is the desired sum. We compute the possibility of forming each sum from 1 to target for each element.
// Space Complexity: O(target) - We use a 1D dp array of size (target+1) to store the possibility of forming each sum, optimizing space usage compared to a 2D approach.