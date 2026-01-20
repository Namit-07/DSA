// Problem Statement: You are given a sorted array rotated at an unknown pivot. Return the index of target, else -1 if not found.
// Logic: At every mid, one half is always sorted. Either left half sorted or right half sorted. Then decide if target lies inside that sorted half. 

public class searchInRotatedSortedArray {
    public static int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left<=right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } 

            // Left half is sorted 
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(nums, target);

        System.out.println("Index of target " + target + ": " + result);
    }
}


// Complexity Analysis:
// Time complexity: O(log n), where n is the number of elements in the array. The search space is halved each time.
// Space complexity: O(1), since we are using only a constant amount of extra space.