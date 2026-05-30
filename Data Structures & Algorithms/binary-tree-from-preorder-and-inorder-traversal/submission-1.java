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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(map, preorder, 0, preorder.length, inorder, 0, preorder.length);
    }

    public TreeNode helper(HashMap<Integer, Integer> map, int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        System.out.println(pl + " " + pr + " " + il + " " + ir);
        if (pl == pr) return null;
        if (pl == pr - 1) return new TreeNode(preorder[pl]);
    
        TreeNode parent = new TreeNode(preorder[pl]);

        int i = map.get(preorder[pl]);

        parent.left = helper(map, preorder, pl+1, pl+1+i-il, inorder, il, i);
        parent.right = helper(map, preorder, pl+1+i-il, pr, inorder, i+1, ir);

        return parent;
    }
}
