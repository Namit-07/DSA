// Problem Statement: Given an array nums, return all possible subsets.
// Logic: Use backtracking to explore all combinations of including or excluding each element in the array. 

package Backtracking;
import java.util.*;

public class generateAllSubsets {
    public static void backTrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result){

        // add the current subset
        result.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++){
            // choose
            current.add(nums[i]);

            // explore
            backTrack(i+1, nums, current, result);

            // undo (backtrack)
            current.remove(current.size() - 1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    
    }
}

// Complexity Analysis:
// Time Complexity: O(N * 2^N), where N is the number of elements in the input array.
// Space Complexity: O(N), for the recursion stack and the current subset storage.
