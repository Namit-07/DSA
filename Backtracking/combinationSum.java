// Problem Statement: Given an array of unique integers candidates and a target, return all combinations that sum to target.
// Logic: At each index, take candidate[i] or move to next index. Use backtracking to explore all combinations.

package Backtracking;
import java.util.*;

public class combinationSum {
    public static void backTrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            current.add(candidates[i]);
            backTrack(i, candidates, target - candidates[i], current, result); // not i+1 because we can reuse same elements
            current.remove(current.size() - 1); // undo (backtrack)
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println(combinations);
    }
}

// Complexity Analysis:
// Time Complexity: O(N^(T/M + 1)), where N is the number of candidates, T is the target, and M is the minimum value in candidates.
// Space Complexity: O(T/M), for the recursion stack and the current combination storage.
