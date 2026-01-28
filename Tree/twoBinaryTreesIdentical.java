// Problem Statement: Check if two binary trees are identical.
// Logic: Two binary trees are identical if they have the same structure and the same node values. We can use a recursive approach to compare the nodes of both trees.

package Tree;

public class twoBinaryTreesIdentical {
    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static boolean isSameTree(TreeNode p, TreeNode q){

        // Case 1: Both nodes are null, trees are identical up to this point
        if(p == null && q == null){
            return true;
        }
        // Case 2: One node is null and the other is not, trees are not identical
        if(p == null || q == null){
            return false;
        }
        // Case 3: Values of the current nodes are different, trees are not identical
        if(p.val != q.val){
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println("Are the two binary trees identical? " + isSameTree(tree1, tree2)); // Expected Output: true
    }
}

// Complexity Analysis:
// Time Complexity: O(min(n, m)), where n and m are the number of nodes in the two binary trees.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
