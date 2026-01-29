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
    
}
