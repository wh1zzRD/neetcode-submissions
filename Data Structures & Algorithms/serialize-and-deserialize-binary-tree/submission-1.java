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

        for (Integer n : bfsList) System.out.print(n + " ");
        System.out.println();
        
        String res = "";
        for (Integer n : bfsList) {
            if (n == null) {
                res += "4null";
            } else {
                res += (n.toString().length() + n.toString());
            }
        }
        System.out.println(res);
        return res;
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

        for (Integer n : bfsList) System.out.print(n + " ");
        System.out.println();
        
        return bfsDecode(bfsList);
    }

    // public TreeNode deserializeHelper(ArrayList<Integer> bfsList, int currIdx, int start) {
    //     if (currIdx >= bfsList.size() || bfsList.get(currIdx) == null) return null;

    //     TreeNode parent = new TreeNode(bfsList.get(currIdx));
    //     parent.left = deserializeHelper(bfsList, 2 * (currIdx + 1) - 1);
    //     parent.right = deserializeHelper(bfsList, 2 * (currIdx + 1) - 1 + 1);

    //     return parent;
    // }

    public TreeNode bfsDecode(ArrayList<Integer> bfsList) {
        TreeNode parent = null;
        if (bfsList.getFirst() != null) parent = new TreeNode(bfsList.getFirst());
        else return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(parent);

        for (int i = 1; i < bfsList.size(); i++) {
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
