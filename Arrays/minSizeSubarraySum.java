// Problem Statement: Given an array of positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// Logic: Use a sliding window approach to expand and contract the window while maintaining the sum of the current subarray and checking if it meets the condition.

public class minSizeSubarraySum{
    public static int minSubArrayLen(int target, int [] nums){
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right=0; right<nums.length; right++){
            sum += nums[right];

            while(sum>=target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space Complexity: O(1), as we are using a constant amount of extra space.