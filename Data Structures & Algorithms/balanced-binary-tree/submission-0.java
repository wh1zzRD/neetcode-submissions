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

    public boolean isBalanced(TreeNode root) {
        if (balanced(root) == -1) return false;
        return true;
    }

    public int balanced(TreeNode root) {
        if (root == null) return 0;

        int a = balanced(root.left);
        int b = balanced(root.right);

        if (a == -1 || b == -1 || (a - b != 1 && a - b != -1 && a != b)) return -1;
        return 1 + Math.max(a, b);
    }
}
