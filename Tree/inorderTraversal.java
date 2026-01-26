// Problem Statement: Perform inorder traversal of a binary tree.
// Logic: Use recursion to visit the left subtree, then the root node, and finally the right subtree.

package Tree;

public class inorderTraversal {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left); // Visit left subtree
        System.out.print(root.val + " "); // Visit root node
        inorder(root.right); // Visit right subtree
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Inorder Traversal of the binary tree:");
        inorder(root); // Expected Output: 4 2 5 1 3
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once.
// Space Complexity: O(h), where h is the height of the tree.