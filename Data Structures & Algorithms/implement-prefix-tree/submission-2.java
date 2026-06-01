class PrefixTree {

    class Node {
        Character c;
        boolean exists;
        // ArrayList<Node> children;
        HashMap<Character, Node> children;

        public Node(Character c, boolean exists) {
            this.c = c;
            this.exists = exists;
            children = new HashMap<Character, Node>();
        }

        public Node hasChild(Character x) {
            return children.getOrDefault(x, null);
        }
    }

    Node head;
    public PrefixTree() {
        head = new Node('#', true);
    }

    public void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node(c, false));
            cur = cur.children.get(c);
        }
        cur.exists = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.exists;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}
