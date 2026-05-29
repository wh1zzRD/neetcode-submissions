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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, preorder.length);
    }

    public TreeNode helper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        System.out.println(pl + " " + pr + " " + il + " " + ir);
        if (pl == pr) return null;
        if (pl == pr - 1) return new TreeNode(preorder[pl]);
        // if (il >= preorder.length || ir >= preorder.length) return null;
        // if (pl >= preorder.length || pr >= preorder.length) return null;

        TreeNode parent = new TreeNode(preorder[pl]);

        int i = il;
        for (; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) break;
        }

        parent.left = helper(preorder, pl+1, pl+1+i-il, inorder, il, i);
        parent.right = helper(preorder, pl+1+i-il, pr, inorder, i+1, ir);

        return parent;
    }
}
