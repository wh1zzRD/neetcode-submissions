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
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int max) {
        if (root == null) return 0;

        if (root.val >= max) {
            return 1 + helper(root.left, Math.max(root.val, max)) + helper(root.right, Math.max(root.val, max));
        } else {
            return helper(root.left, Math.max(root.val, max)) + helper(root.right, Math.max(root.val, max));
        }
    }
}
