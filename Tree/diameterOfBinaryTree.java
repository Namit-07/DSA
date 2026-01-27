// Problem Statement: Calculate the diameter of a binary tree.(longest path between any two nodes)
// Logic: The diameter of a binary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root. We can calculate this using a recursive approach by finding the heights of left and right subtrees for each node and updating the maximum diameter found so far.

package Tree;

public class diameterOfBinaryTree {

    static class TreeNode{
        int val;
        TreeNode left, right;
    
        TreeNode(int val){
            this.val = val;
        }
    }
    
    static int diameter = 0; // Variable to store the maximum diameter found

    public static int height(TreeNode root){
        
        if(root == null){
            return 0; // Base case: height of empty tree is 0
        }

        int leftHeight = height(root.left); // Height of left subtree
        int rightHeight = height(root.right); // Height of right subtree

        // Update diameter at this node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height
        return 1 + Math.max(leftHeight, rightHeight); // Height of current node
    }
    public static int diameterOfBinaryTree(TreeNode root){
        height(root); // Calculate heights and update diameter
        return diameter; // Return the maximum diameter found
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of the binary tree: " + diameterOfBinaryTree(root)); // Expected Output: 4
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
