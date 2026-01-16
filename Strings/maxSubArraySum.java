// Problem Statement: Find the maximum sum of a contiguous subarray within a one-dimensional array of numbers.
// Logic: Use Kadane's Algorithm which involves iterating through the array while keeping track of the current subarray sum and the maximum sum found so far.

package Strings;

public class maxSubArraySum {
    public static int maxSubArray(int[] nums){
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result); // Output: Maximum Subarray Sum: 6
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space Complexity: O(1), as we are using only a constant amount of extra space
