// Problem Statement: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
// Logic: We can use a recursive approach to traverse the tree, subtracting the node values from the sum as we go down each path. If we reach a leaf node and the remaining sum equals the node's value, we have found a valid path.

package Tree;

import java.util.*;

public class pathSumll {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    private static void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result){
        if (node==null){
            return;
        }
        // Choose
        path.add(node.val);
        
        // Check only at the leaf nodes
        if(node.left==null && node.right==null && remainingSum==node.val){
            result.add(new ArrayList<>(path));
        }
        // Explore
        dfs(node.left, remainingSum - node.val, path, result);
        dfs(node.right, remainingSum - node.val, path, result);

        // BackTrack
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = pathSum(root, targetSum);
        System.out.println("Paths with sum " + targetSum + ": " + paths); // Output: [[5, 4, 11, 2]]
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the tree. We may need to visit all nodes in the worst case.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack and the path list.
