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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> bfsList = new ArrayList<>();
        
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.removeFirst();
            if (cur == null) {
                bfsList.addLast(null);
                continue;
            }
            bfsList.addLast(cur.val);

            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        
        StringBuilder res = new StringBuilder();
        for (Integer n : bfsList) {
            if (n == null) {
                res.append("4null");
            } else {
                res.append((n.toString().length() + n.toString()));
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<Integer> bfsList = new ArrayList<>();
        int i = 0;
        while (i < data.length()) {
            int len = data.charAt(i) - '0';
            i++;

            String val = data.substring(i, i + len);
            i += len;
            if (val.equals("null")) bfsList.add(null);
            else bfsList.add(Integer.parseInt(val));
        }

        TreeNode parent = null;
        if (bfsList.getFirst() != null) parent = new TreeNode(bfsList.getFirst());
        else return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(parent);

        for (i = 1; i < bfsList.size(); i++) {
            TreeNode curr = q.remove();

            System.out.println(i);
            if (bfsList.get(i) != null) {
                curr.left = new TreeNode(bfsList.get(i));
                if (curr.left != null) q.add(curr.left);
            }
            i++;

            if (bfsList.get(i) != null) {
                curr.right = new TreeNode(bfsList.get(i));
                if (curr.right != null) q.add(curr.right);
            }
        }

        return parent;
    }
}
