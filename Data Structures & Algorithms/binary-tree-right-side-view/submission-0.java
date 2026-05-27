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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int c = 1;
        while (!q.isEmpty()) {
            int tmp = 0;
            for (int i = 0; i < c - 1; i++) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    q.add(n.left);
                    tmp++;
                }
                if (n.right != null) {
                    q.add(n.right);
                    tmp++;
                }
            }
            TreeNode last = q.poll();
            res.add(last.val);
            if (last.left != null) {
                q.add(last.left);
                tmp++;
            }
            if (last.right != null) {
                q.add(last.right);
                tmp++;
            }
            c = tmp;
        }
        return res;
    }
}
