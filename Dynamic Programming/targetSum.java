// Problem Statement: Given an array of integers and a target sum, return the number of ways to make the target.
// Logic: This problem can be solved using Dynamic Programming by maintaining an array that counts the number of ways to form each sum up to the target using the elements of the array.

public class targetSum {
    public static int findTargetSumWays(int[] nums, int target){
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }
        if((target + totalSum)%2!=0 || totalSum<Math.abs(target)){
            return 0; // If (target + totalSum) is odd or totalSum is less than absolute target, no valid partitions exist
        } 
        int SubsetSum = (target + totalSum)/2;
        int[] dp = new int[SubsetSum+1]; // dp[s] will store the number of ways to make sum s
        dp[0] = 1; // There's one way to make sum 0: use no elements

        for(int num : nums){
            for(int s=SubsetSum; s>=num; s--){
                dp[s] += dp[s-num]; // Update dp[s] by adding ways to form (s - num)
            }
        }
        return dp[SubsetSum]; // Return the number of ways to form the target sum
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = findTargetSumWays(nums, target);
        System.out.println("Number of ways to make target sum " + target + ": " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*SubsetSum) - where n is the number of elements in the array and SubsetSum is (target + totalSum)/2. We compute the number of ways to form each sum from 1 to SubsetSum for each element.    
// Space Complexity: O(SubsetSum) - We use a 1D dp array of size (SubsetSum+1) to store the number of ways to form each sum, optimizing space usage compared to a 2D approach.
