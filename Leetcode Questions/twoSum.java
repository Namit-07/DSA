// Problem Statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order. Example 1: Input: nums = [2,7,11,15], target = 9. Output: [0,1] .Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.*;

class twoSum {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        twoSum solution = new twoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices of the two numbers: " + Arrays.toString(result));
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array once to fill the hash map and check for complements.
// Space Complexity: O(n) for the hash map that stores the elements and their indices.