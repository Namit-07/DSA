// Problem Statement: Perform level order traversal of a binary tree. 
// Logic: Use a queue to visit nodes level by level from left to right. We are using a bfs(breadth-first search) approach.

package Tree;

import java.util.*;


public class levelOrderTraversal {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Initialize a queue for BFS
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " "); // Visit current node

            if (current.left != null)
                queue.add(current.left); // Add left child to queue

            if (current.right != null)
                queue.add(current.right); // Add right child to queue
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Level Order Traversal of the binary tree:");
        levelOrder(root); // Expected Output: 1 2 3 4 5
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the binary tree. 
// Space Complexity: O(w), where w is the maximum width of the tree (the maximum number of nodes at any level).

