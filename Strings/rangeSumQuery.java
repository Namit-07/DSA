// Problem Statement: You are given an array nums, and mulitple queries: sumRange(left, right). Return the sum of elements from index left to right
// Logic: We can use a prefix sum array to store the cumulative sums up to each index. This allows us to calculate the sum for any range in constant time.

package Strings;

public class rangeSumQuery {

    static class NumArray {
        int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            prefix[0] = 0;

            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}

// Complexity Analysis:
// Time Complexity: O(n) for preprocessing the prefix sum array, O(1) for each sumRange query.
// Space Complexity: O(n) for storing the prefix sum array.