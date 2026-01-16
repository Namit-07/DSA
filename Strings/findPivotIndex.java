// Problem Statement: Sum of elements to the left and right of the pivot index are equal.
// Logic: Let totalSum = sum of all elements in the array. At each index i, leftSum = sum of elements from index 0 to i-1. Then rightSum = totalSum - leftSum - nums[i]. If leftSum == rightSum, then i is the pivot index.

package Strings;

public class findPivotIndex {
    public static int pivotIndex(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIndex = pivotIndex(nums);
        System.out.println("Pivot Index: " + pivotIndex); // Output: Pivot Index: 3
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array twice.
// Space Complexity: O(1), as we are using only a constant amount of extra space.
