class WordDictionary {
    class Node {
        Character c;
        boolean word;
        HashMap<Character, Node> children;

        public Node(Character c, boolean word) {
            this.c = c;
            this.word = word;
            children = new HashMap<>();
        }

        public Node hasChild(Character c) {
            return children.getOrDefault(c, null);
        }
    }

    Node head;
    public WordDictionary() {
        head = new Node('#', false);
    }

    public void addWord(String word) {
        addWordHelper(word, 0, head);
    }

    private void addWordHelper(String word, int idx, Node node) {
        if (idx == word.length()) {
            node.word = true;
            return;
        }

        Node n = node.hasChild(word.charAt(idx));

        if (n != null) addWordHelper(word, idx + 1, n);
        else {
            Node tmp = new Node(word.charAt(idx), false);
            node.children.put(Character.valueOf(word.charAt(idx)), tmp);
            addWordHelper(word, idx + 1, tmp);
        }
    }

    public boolean search(String word) {
        System.out.println(word);
        return searchHelper(word, 0, head);
    }

    private boolean searchHelper(String word, int idx, Node node) {
        if (idx == word.length() && node.word) {
            return true;
        }
        if (idx == word.length()) return false;

        if (word.charAt(idx) == '.') {
            for (Map.Entry<Character, Node> e : node.children.entrySet()) {
                if (searchHelper(word, idx + 1, e.getValue())) return true;
            }
            return false;
        } else {
            Node n = node.hasChild(word.charAt(idx));
            if (n == null) return false;
            else {
                return searchHelper(word, idx + 1, n);
            }
        }
    }
}
