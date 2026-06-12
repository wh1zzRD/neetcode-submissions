/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, List<Node>> adjList = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        adjList.put(node, node.neighbors);
        q.add(node);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            for (Node n : tmp.neighbors) {
                if (!adjList.containsKey(n)) {
                    adjList.put(n, n.neighbors);
                    q.add(n);
                }
            }
        }
        
        HashMap<Node, Node> nodes = new HashMap<>();
        for (Node n : adjList.keySet()) {
            nodes.put(n, new Node(n.val));
        }

        for (Map.Entry<Node, List<Node>> e : adjList.entrySet()) {
            Node cur = nodes.get(e.getKey());
            for (Node n : e.getValue()) {
                cur.neighbors.add(nodes.get(n));
            }
        }

        return nodes.get(node);
    }
}