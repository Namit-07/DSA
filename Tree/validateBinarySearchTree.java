// Problem Statement: Validate if a binary tree is a binary search tree (BST).
// Logic: To validate a BST, we can use a recursive approach by ensuring that each node's value falls within a valid range defined by its ancestors.

package Tree;

public class validateBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max){
        // Base case
        if (node == null) {
            return true;
        }
        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }
        // Recursively validate the left and right subtrees with updated ranges
        return validate(node.left, min, node.val) &&
         validate(node.right, node.val, max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean isValidBST = isValidBST(root);

        System.out.println("Is the binary tree a valid BST? " + isValidBST); // Expected Output: true
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree, as we visit each node once.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
