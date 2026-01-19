// Problem Statement: Given a sorted array nums and a target, return the the index if found, else -1.
// Logic: Search space shrinks every step. If target > mid -> search right half, else search left half.


public class binarySearch {
    public static int binarySearch(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                return mid;
           } else if (nums[mid] < target){
            left = mid + 1;
           } else {
            right = mid - 1;
           }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;
        int result = binarySearch(nums, target);

        System.out.println("Index of target " + target + ": " + result);
    }
}

// Complexity Analysis:
// Time complexity: O(log n), where n is the number of elements in the array. The search space is halved each time.
// Space complexity: O(1), since we are using only a constant amount of extra space.
