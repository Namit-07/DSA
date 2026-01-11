// Problem Statement: Given an array of integers and an integer k, return the the number of contiguous subarrays that sum to k.
// Logic: Use a hashmap to store the cumulative sum and its frequency. Iterate through the array, updating the cumulative sum and checking if (cumulative sum - k) exists in the hashmap. If it does, it means there is a subarray that sums to k. Update the count accordingly.

import java.util.*;

public class subArraySumEqualsK {
    public static int subarraySum(int[] nums, int k){

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 occurring once

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;

            if(map.containsKey(sum - k)){
                count +=map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Number of subarrays that sum to " + k + " : " + subarraySum(nums, k));
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space Complexity: O(n), in the worst case, we may store all cumulative sums in the hashmap.
