/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;

        if (root.val == subRoot.val && isNextSubtree(root.left, subRoot.left) && isNextSubtree(root.right, subRoot.right))
            return true;

        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    public boolean isNextSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;

        if (root.val != subRoot.val) return false;
        return isNextSubtree(root.left, subRoot.left) && isNextSubtree(root.right, subRoot.right);
    }
}
