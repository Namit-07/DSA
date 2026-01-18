// Problem Statement: Given a sorted array of integers where each integer is in the range 0 to 2, sort the array in-place using the Dutch National Flag algorithm.
// Logic: Maintain three pointers: low, mid, and high. low points to the next position for 0, mid is the current element under consideration, and high points to the next position for 2. Swap elements accordingly to sort the array.

package Strings;

public class sortColoursDutchFlag {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[mid] and nums[low]
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // nums[mid]==2
                // swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        System.out.print("Sorted array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}

// Complexity Analysis:
// Time complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space complexity: O(1), since we are sorting the array in place without using any extra space.