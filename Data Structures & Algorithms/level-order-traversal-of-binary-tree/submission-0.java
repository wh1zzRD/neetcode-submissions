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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int c = 1;
        while (!q.isEmpty()) {
            res.add(new ArrayList<>());
            int tmp = 0;
            for (int i = 0; i < c; i++) {
                TreeNode n = q.poll();
                res.getLast().add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                    tmp++;
                }
                if (n.right != null) {
                    q.add(n.right);
                    tmp++;
                }
            }
            c = tmp;
        }
        return res;
    }
}
