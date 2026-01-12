// Problem Statement: GIven a binary array, find the length of the longest contiguous subarray with equal number of 0s and 1s.
// logic: Use a hashmap to store the first occurrence of each count of (number of 1s - number of 0s).

import java.util.HashMap;

public class longestEqualZeroOne {
    public static int findMaxLength(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        // Base case
        map.put(0, -1);

        for(int i=0; i<nums.length; i++){
            // Convert to Zeroes to -1
            sum += (nums[i] == 0) ? -1 : 1;

            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1};
        System.out.println(findMaxLength(nums)); // Output: 4
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once.
// Space Complexity: O(n) - In the worst case, we may store all prefix sums in the hashmap.
