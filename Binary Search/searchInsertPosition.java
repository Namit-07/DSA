// Problem Statement: Given a sorted array nums and a target, return the index where it would be if inserted in order.
// Logic: Binary search but instead of returning -1, we return left pointer after loop ends.

public class searchInsertPosition {
    public static int searchInsert(int[] nums, int target){
        
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        int result = searchInsert(nums, target);

        System.out.println("Insert position of target " + target + ": " + result);
    }
}


// Complexity Analysis:
// Time complexity: O(log n), where n is the number of elements in the array. The search space is halved each time.
// Space complexity: O(1), since we are using only a constant amount of extra space.