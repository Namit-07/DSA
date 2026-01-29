// Problem Statement: Search for a value in a binary tree and return true if it exists, otherwise false.
// Logic: To search for a value in a binary tree, we can use a recursive approach where we check the current node's value and recursively search in the left and right subtrees.

package Tree;

public class searchInBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode searchBST(TreeNode root, int val){
        if(root==null || root.val==val){
            return root;
        }
        if(val<root.val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int valToSearch = 2;
        TreeNode result = searchBST(root, valToSearch);
        if(result != null){
            System.out.println("Value " + valToSearch + " found in the binary tree.");
        } else {
            System.out.println("Value " + valToSearch + " not found in the binary tree.");
        }
    }
}

// Complexity Analysis: 
// Time Complexity: O(n) in the worst case for an unbalanced tree, where n is the number of nodes in the binary tree. In a balanced BST, it would be O(log n).
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
