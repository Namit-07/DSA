// Problem Statement: Given an array of integers where 1<= arr[i] <= n (n = size of array), some elements appear twice and others appear once. Find all the elements that appear twice in this array.
// Logic: We use the array itself as a hashmap. Since values are from 1 -> n, we can mark visited numbers by negating the value at that index.


package Strings;

import java.util.*;

public class duplicatesInAnArray {
    public static List<Integer> findDuplicates(int[] nums){

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;

            if(nums[index]<0){
                result.add(index + 1);
            }else{
                nums[index] = -nums[index];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums)); // Output: [2, 3]
    }
}


// Complexity Analysis:
// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity: O(1) as we are not using any extra space except for the output list.