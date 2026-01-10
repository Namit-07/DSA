// Problem Statement: Given an array and an integer k, find the maximum sum of a subarray of size k.
// Logic: Use a sliding window approach to maintain the sum of the current subarray of size k and update the maximum sum found.


public class maxSumSubarray {
    public static int maxSum(int[] arr, int k){
        
        int windowSum = 0;
        int maxSum = 0;

        // First Window
        for (int i=0; i<k; i++){
            windowSum += arr[i];
        }
        
        maxSum = windowSum;

        // Sliding the window
        for(int i=k; i<arr.length; i++){
            windowSum += arr[i]; // Add new element
            windowSum -= arr[i-k];      // Remove the element going out of the window
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }    
    public static void main(String[] args) {   
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSum(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space Complexity: O(1), as we are using a constant amount of extra space.
