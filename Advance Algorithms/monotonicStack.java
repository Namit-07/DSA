// Problem Statement: For each element in the array, find the next greater element to its right. If there is no greater element, return -1 for that position. (Next greater element problem)
// Logic: Use a monotonic stack to keep track of indices of elements. As we iterate through the array, we pop from the stack until we find a greater element or the stack is empty. We then update the result for the popped indices and push the current index onto the stack. 

import java.util.*;

public class monotonicStack {
    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result array with -1

        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){ 
                result[stack.pop()] = nums[i]; // Update result for the index at the top of the stack
            }
            stack.push(i); // Push current index onto the stack
        }
        return result; // Return the result array
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(nums);
        System.out.println("Next greater elements: " + Arrays.toString(result));
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the input array. Each element is pushed and popped from the stack at most once.
// Space Complexity: O(n) in the worst case, if all elements are in increasing order, we will have all indices in the stack.
