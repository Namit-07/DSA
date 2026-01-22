// Problem Statement: Given an array nums, return all possible permutations.
// Logic: Use backtracking to generate all possible arrangements by swapping elements.

package Backtracking;
import java.util.*;

public class Permutations {
    public static void  backTrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result){
        
        // one full permutation is formed
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]){
                continue;
            }

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            backTrack(nums, used, current, result);

            // undo (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        System.out.println(permutations);
    }
}

// Complexity Analysis:
// Time Complexity: O(N * N!), where N is the number of elements in the input array.
// Space Complexity: O(N), for the recursion stack and the current permutation storage.