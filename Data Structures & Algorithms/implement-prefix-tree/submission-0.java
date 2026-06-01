class PrefixTree {

    class Node {
        char c;
        boolean exists;
        ArrayList<Node> children;

        public Node(char c, boolean exists) {
            this.c = c;
            this.exists = exists;
            children = new ArrayList<Node>();
        }

        public Node hasChild(char x) {
            for (Node n : children) 
            if (n.c == x) {
                // System.out.println(n.c);
                return n;
            }
            return null;
        }
    }

    Node head;
    public PrefixTree() {
        head = new Node('#', true);
    }

    public void insert(String word) {
        // System.out.println("-------");
        insertHelper(word, 0, head);
    }

    private void insertHelper(String word, int idx, Node node) {
        Node n = node.hasChild(word.charAt(idx));
        // if (n != null) System.out.println(n.c);
        if (idx == word.length()-1 && n != null) {
            n.exists = true;
            return;
        }
        if (idx == word.length()-1) {
            node.children.add(new Node(word.charAt(idx), true));
            return;
        }

        if (n == null) {
            Node tmp = new Node(word.charAt(idx), false);
            node.children.add(tmp);
            insertHelper(word, idx+1, tmp);
        } else {
            insertHelper(word, idx+1, n);
        }
    }

    public boolean search(String word) {
        // System.out.println("-------");
        return searchHelper(word, 0, head);
    }

    private boolean searchHelper(String word, int idx, Node node) {
        Node n = node.hasChild(word.charAt(idx));
        // if (n != null) System.out.println(n.c);

        if (n == null) return false;

        if (idx == word.length() - 1) {
            if (n.exists) return true;
            return false;
        } else {
            return searchHelper(word, idx + 1, n);
        }
    }

    public boolean startsWith(String prefix) {
        // System.out.println("-------");
        return startsWithHelper(prefix, 0, head);
    }

    private boolean startsWithHelper(String word, int idx, Node node) {
        Node n = node.hasChild(word.charAt(idx));
        // System.out.println(idx);
        // if (n != null) System.out.println(n.c);

        if (idx == word.length()-1 && n != null) return true;
        if (n == null) return false;
        return startsWithHelper(word, idx + 1, n);
    }
}
