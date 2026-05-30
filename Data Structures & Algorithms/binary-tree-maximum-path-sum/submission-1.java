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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            int a = helper(root.left);
            int b = helper(root.right);

            // System.out.println(a + " " + b + " " + root.val + " " + sum);
            int m = Math.max(Math.max(a + b + root.val, root.val), Math.max(a + root.val, b + root.val));
            if (max < m) max = m;
            return Math.max(Math.max(a + root.val, b + root.val), root.val);
        } else if (root.left == null && root.right != null) {
            int b = helper(root.right);

            int sum = b + root.val;
            int m = Math.max(b + root.val, root.val);
            if (max < m) max = m;
            System.out.println(m);
            return m;
        } else if (root.left != null && root.right == null) {
            int a = helper(root.left);

            int sum = a + root.val;
            int m = Math.max(a + root.val, root.val);
            if (max < m) max = m;
            System.out.println(m);
            return m;
        } else {
            if (max < root.val) max = root.val;
            System.out.println(root.val);
            return root.val;
        }
    }
}
