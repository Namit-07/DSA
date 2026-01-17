// Problem Statement: Find all unique triplets in the array which gives the sum of zero.
// Logic: Sort the array. Fix one element i and then use two pointers, left = i+1 and right = n-1. Then move pointers based on the sum compared to zero.

package Strings;
import java.util.*;

public class threeSum {
    public static List<List<Integer>> threeeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                } else if (sum < 0) {

                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeeSum(nums);
        System.out.println("Unique Triplets that sum to zero: " + triplets);
    }
}

// Complexity Analysis:
// Time Complexity: O(n^2), where n is the number of elements in the array. Sorting takes O(n log n) and the two-pointer approach takes O(n^2) in total.
// Space Complexity: O(k), where k is the number of unique triplets found. This is for storing the result.
