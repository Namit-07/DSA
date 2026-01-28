// Problem Statement: Invert a binary tree.
// Logic: To invert a binary tree, we can use a recursive approach where we swap the left and right children of each node in the tree.

package Tree;

public class invertBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode invertTree(TreeNode root){
        // Base case: if the node is null, return null
        if(root == null){
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    // Helper function to perform inorder traversal and print the tree
    public static void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original tree inorder traversal:");
        inorderTraversal(root); // Expected Output: 4 2 5 1 3
        System.out.println();

        invertTree(root);

        System.out.println("Inverted tree inorder traversal:");
        inorderTraversal(root); // Expected Output: 3 1 5 2 4
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree, as we visit each node once.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
