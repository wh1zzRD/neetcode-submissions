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
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int atLeast, int atMost) {
        if (root == null) return true;

        if (root.left != null) {
            if (root.left.val >= root.val) return false;
            if (root.left.val <= atLeast) return false;
            if (root.left.val >= atMost) return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            if (root.right.val <= atLeast) return false;
            if (root.right.val >= atMost) return false;
        }

        int newAtLeast = Math.max(atLeast, root.val);
        int newAtMost = Math.min(atMost, root.val);

        return helper(root.left, atLeast, newAtMost) && helper(root.right, newAtLeast, atMost);
    }
}
