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
    public ArrayList<Integer> bst;
    public int kthSmallest(TreeNode root, int k) {
        bst = new ArrayList<>();
        inOrder(root);
        return bst.get(k-1);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        bst.add(root.val);
        inOrder(root.right);
    }
}
