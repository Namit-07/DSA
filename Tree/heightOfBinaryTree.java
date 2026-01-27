// Problem Statement: Calculate the height of a binary tree.
// Logic: The height of a binary tree is the number of edges on the longest path from the root to a leaf node. We can calculate this using a recursive approach by finding the height of left and right subtrees and taking the maximum of the two heights plus one for the current node.

package Tree;

public class heightOfBinaryTree {
    
    static class TreeNode{
        int val;
        TreeNode left, right;
    
        TreeNode(int val){
            this.val = val;
        }
    }
    // Function to calculate the height of the binary tree
    public static int height(TreeNode root){
        if(root==null){
            return 0; // Base case: height of empty tree is 0
        }

        int leftHeight = height(root.left); // Height of left subtree
        int rightHeight = height(root.right); // Height of right subtree

        return 1 + Math.max(leftHeight, rightHeight); // Height of current node
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of the binary tree: " + height(root)); // Expected Output: 3
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
