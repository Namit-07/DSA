// Problem Statement: Perform postorder traversal of a binary tree.
// Logic: Use recursion to visit the left subtree first, then the right subtree, and finally the root node.

package Tree;

public class postorderTraversal {
    
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static void postorder(TreeNode root){
        if(root==null){
            return;
        }
        postorder(root.left); // Visit left subtree
        postorder(root.right); // Visit right subtree
        System.out.print(root.val + " "); // Visit root node
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Postorder Traversal of the binary tree:");
        postorder(root); // Expected Output: 4 5 2 3 1
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once.
// Space Complexity: O(h), where h is the height of the tree.   