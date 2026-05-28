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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean helper(TreeNode root, double atLeast, double atMost) {
        if (root == null) return true;

        if (root.val >= atMost) return false;
        if (root.val <= atLeast) return false;

        return helper(root.left, atLeast, root.val) && helper(root.right, root.val, atMost);
    }
}
