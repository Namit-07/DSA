// Problem Statement: Insert a value into a binary search tree (BST).
// Logic: To insert a value into a BST, we can use a recursive approach by comparing the value to be inserted with the current node's value and deciding to go left or right accordingly until we find the correct position.

package Tree;

public class insertIntoBST {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode insertIntoABST(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left = insertIntoABST(root.left, val);
        } else {
            root.right = insertIntoABST(root.right, val);
        }
        return root;
    }
    // Inorder traversal to verify insertion
    public static void inorderTraversal(TreeNode root){
        if(root==null)
            return;
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int valToInsert = 5;
        root = insertIntoABST(root, valToInsert);

        System.out.print("Inorder Traversal after insertion: ");
        inorderTraversal(root); // Expected Output: 1 2 3 4 5 7
    }
}

// Complexity Analysis:
// Time Complexity: O(h), where h is the height of the tree, as we may need to traverse from the root to a leaf node in the worst case.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
