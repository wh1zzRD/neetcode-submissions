class Node {
    public boolean isWord;
    public HashMap<Character, Node> map;

    public Node(boolean isWord) {
        this.isWord = isWord;
        map = new HashMap<>();
    }

    public void addWordFromStartingHere(String word, int s) {
        if (s >= word.length()) {
            this.isWord = true;
            return;
        }
        
        Node n = new Node(false);
        map.put(word.charAt(s), n);
        n.addWordFromStartingHere(word, s + 1);
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Node trie = new Node(false);

        for (String word : wordDict) {
            Node cur = trie;
            int i = 0;
            //System.out.println(i);
            while (i < word.length() && cur.map.containsKey(word.charAt(i))) {
                cur = cur.map.get(word.charAt(i));
                i++;
            }
            //System.out.println(i);

            if (i == word.length()) cur.isWord = true;
            else cur.addWordFromStartingHere(word, i);
        }

        // if (true) return true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        boolean[] dp = new boolean[s.length()];

        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            //if (tmp >= s.length()) continue;

            int i = 0;
            Node cur = trie;
            while (tmp + i < s.length() && cur.map.containsKey(s.charAt(tmp + i))) {
                cur = cur.map.get(s.charAt(tmp + i));

                if (cur.isWord && !dp[tmp + i]) {
                    dp[tmp + i] = true;
                    //System.out.println(tmp + i);
                    stack.push(tmp + i + 1);
                }
                i++;
            }
        }
        return dp[s.length() - 1];
    }
}
