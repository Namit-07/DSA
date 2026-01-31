// Problem Statement: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
// Logic: We can use a recursive approach to traverse the tree, subtracting the node values from the sum as we go down each path. If we reach a leaf node and the remaining sum equals the node's value, we have found a valid path.

package Tree;

public class pathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        // If leaf node, check sum
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        int remaining = sum - root.val;

        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
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

        int sum = 22;
        boolean result = hasPathSum(root, sum);
        System.out.println("Tree has path sum of " + sum + ": " + result); // Output: true
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the tree. We may
// need to visit all nodes in the worst case.
// Space Complexity: O(h), where h is the height of the tree, due to the
// recursion stack.