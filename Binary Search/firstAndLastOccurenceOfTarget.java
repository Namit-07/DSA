// Problem Statement: Given a sorted array nums and a target, return the the first and last index of the target if found, else -1.
// Logic: Use binary search twice, once to find the first occurrence and once to find the last occurrence.



public class firstAndLastOccurenceOfTarget {
    public static int findFirst(int[] nums, int target){
        int left = 0; 
        int right = nums.length - 1;
        int ans = -1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                right = mid - 1; // go left to find first occurence
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    
    public static int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                ans = mid;
                left = mid + 1; // go right to find last occurence
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int[] searchRange(int[] nums, int target){
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);

        System.out.println("First and Last Occurrence of target " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}

// Complexity Analysis:
// Time complexity: O(log n), where n is the number of elements in the array. We perform two binary searches.
// Space complexity: O(1), since we are using only a constant amount of extra space.
