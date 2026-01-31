// Problem Statement: Given a binary tree, find its maximum depth.
// Logic: The maximum depth of a binary tree can be found using a recursive approach. The depth of a tree is the maximum depth of its left and right subtrees plus one for the root node.

package Tree;

public class maximumDepthOfBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static int maxDepth(TreeNode root){
        // Base case: if the node is null, depth is 0
        if (root == null){
            return 0;
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Current depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int depth = maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth); // Output: 3    
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the tree. We visit each node once.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack. In the worst case (skewed tree), h can be n.
