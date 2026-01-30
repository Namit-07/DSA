// Problem Statement: Find the lowest common ancestor (LCA) of two nodes in a binary tree.
 // Logic: To find the LCA, we can use a recursive approach where we traverse the tree and check if the current node is one of the target nodes or if the target nodes are found in different subtrees.

package Tree;

public class lowestCommonAncestor {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode lCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        // If root is one of nodes
        if(root==p || root==q) return root;

        TreeNode left = lCA(root.left, p, q);
        TreeNode right = lCA(root.right, p, q);

        // If p and q are found in different subtrees
        if(left!=null && right!=null) return root;

        // Else return the non-null child
        return left!=null ? left : right;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        TreeNode lca = lCA(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val); // Output: 3
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the tree. We may need to visit all nodes in the worst case.
// Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
