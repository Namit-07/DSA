// Problem Statement: Given an array of integers, find the majority element (the element that appears more than n/2 times).
// Logic: Create a hashmap, then traverse the array to count the frequency of each element. The element with a count greater than n/2 is the majority element.

import java.util.*;

public class majorityElements {
    public static int majorityElement(int[] nums){
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n / 2){
                return num;
            }

        }
        return -1; // Return -1 if no majority element is found
    }
    public static void main(String[] args) {
        int [] arr = {3,3, 5, 5, 5, 5, 3};
        int majority = majorityElement(arr);
        System.out.println("Majority Element: " + majority);
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once to count frequencies.
// Space Complexity: O(n) - In the worst case, we may store all elements in the hashmap.