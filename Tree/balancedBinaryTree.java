// Problem Statement: Check if a binary tree is height-balanced.
// Logic: A binary tree is height-balanced if for every node, the difference in heights between its left and right subtrees is at most 1. We can use a recursive approach to calculate the height of each subtree and check the balance condition.

package Tree;

public class balancedBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) 
            return -1;

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.left.left.left = new TreeNode(6);

        System.out.println("Is the binary tree balanced? " + isBalanced(root)); // true
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the tree. We visit each node once.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
