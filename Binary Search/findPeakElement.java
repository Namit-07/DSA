// Problem Statement: A peak element is an element that is strictly greater than its neighbors. Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// Logic: If nums[mid] < nums[mid + 1], then the peak must be in the right half, else it is in the left half. Basically binary search on the condition of peak.

public class findPeakElement {
    public static int findPeak(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int mid = left + (right - left)/2;

            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }    

        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int peakIndex = findPeak(nums);

        System.out.println("Peak element index: " + peakIndex);
    }
}

// Complexity Analysis:
// Time complexity: O(log n), where n is the number of elements in the array. The search space is halved each time.
// Space complexity: O(1), since we are using only a constant amount of extra space.
