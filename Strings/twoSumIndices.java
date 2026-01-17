// Problem Statement: Given a sorted array, return indices of the two numbers such that they add up to a specific target.
// Logic: Use a two-pointer approach, starting with one pointer at the beginning and the other at the end of the array, and move them towards each other based on the sum compared to the target.

package Strings;

public class twoSumIndices {
    public static int[] twoSum(int[] numbers, int target){
        int left =0;
        int right = numbers.length -1;

        while(left<right){
            int sum = numbers[left] + numbers[right];

            if(sum==target){
                return new int[]{left+1, right+1}; // +1 for 1-based indexing
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Return an invalid pair if no solution is found
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println("Indices of the two numbers: [" + result[0] + ", " + result[1] + "]");
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array with two pointers.
// Space Complexity: O(1), as we are using only a constant amount of extra space.