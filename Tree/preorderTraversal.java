// Problem Statement: Perform preorder traversal of a binary tree.
// Logic: Use recursion to visit the root node first, then the left subtree, and finally the right subtree.

package Tree;

public class preorderTraversal {
    
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + " "); // Visit root node
        preorder(root.left); // Visit left subtree
        preorder(root.right); // Visit right subtree
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Preorder Traversal of the binary tree:");
        preorder(root); // Expected Output: 1 2 4 5 3
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once.
// Space Complexity: O(h), where h is the height of the tree.