// Problem Statement Given a sorted array and a target sum, return true if there are two numbers in the array that add up to the target sum.
// Logic: Use two pointers, one starting at the beginning and the other at the end of the array, and move them based on the sum compared to the target.

public class twoSumSorted {
    public static boolean twoSum(int[] arr, int target){

        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            }
            else if(sum < target){
                left++; // need bigger sum
            }
            else{
                right--; // need smaller sum
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target1 = 6;
        int target2 = 10;
        int target3 = 20;

        System.out.println(twoSum(arr, target1)); // true
        System.out.println(twoSum(arr, target2)); // true
        System.out.println(twoSum(arr, target3)); // false
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once with two pointers.
// Space Complexity: O(1) - We use constant space for pointers and variables.
