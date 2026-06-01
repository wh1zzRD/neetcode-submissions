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
        insertHelper(word, 0, head);
    }

    private void insertHelper(String word, int idx, Node node) {
        Node n = node.hasChild(Character.valueOf(word.charAt(idx)));
        if (idx == word.length()-1 && n != null) {
            n.exists = true;
            return;
        }
        if (idx == word.length()-1) {
            node.children.put(Character.valueOf(word.charAt(idx)), new Node(Character.valueOf(word.charAt(idx)), true));
            return;
        }

        if (n == null) {
            Node tmp = new Node(Character.valueOf(word.charAt(idx)), false);
            node.children.put(Character.valueOf(word.charAt(idx)), tmp);
            insertHelper(word, idx+1, tmp);
        } else {
            insertHelper(word, idx+1, n);
        }
    }

    public boolean search(String word) {
        return searchHelper(word, 0, head);
    }

    private boolean searchHelper(String word, int idx, Node node) {
        Node n = node.hasChild(Character.valueOf(word.charAt(idx)));

        if (n == null) return false;

        if (idx == word.length() - 1) {
            if (n.exists) return true;
            return false;
        } else {
            return searchHelper(word, idx + 1, n);
        }
    }

    public boolean startsWith(String prefix) {
        return startsWithHelper(prefix, 0, head);
    }

    private boolean startsWithHelper(String word, int idx, Node node) {
        Node n = node.hasChild(Character.valueOf(word.charAt(idx)));

        if (idx == word.length()-1 && n != null) return true;
        if (n == null) return false;
        return startsWithHelper(word, idx + 1, n);
    }
}
