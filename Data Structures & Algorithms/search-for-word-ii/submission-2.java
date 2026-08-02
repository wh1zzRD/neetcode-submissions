class Solution {
    HashSet<Integer> res = new HashSet<>();

    class Node {
        public boolean isWord;
        private int idxInWords;
        public HashMap<Character, Node> map;

        public Node(boolean isWord) {
            this.isWord = isWord;
            map = new HashMap<>();
        }

        public void addWordFromStartingHere(String word, int s, int idx) {
            if (s >= word.length()) {
                this.isWord = true;
                this.idxInWords = idx;
                return;
            }
            
            Node n = new Node(false);
            map.put(word.charAt(s), n);
            n.addWordFromStartingHere(word, s + 1, idx);
        }

        public void lookForWords(char[][] grid, boolean[][] visited, int i, int j) {
            if (isWord) res.add(idxInWords);
            
            visited[i][j] = true;
            if (i - 1 >= 0 && !visited[i-1][j] && map.containsKey(grid[i-1][j])) {
                map.get(grid[i-1][j]).lookForWords(grid, visited, i-1, j);
            }
            if (i + 1 < grid.length && !visited[i+1][j] && map.containsKey(grid[i+1][j])) {
                map.get(grid[i+1][j]).lookForWords(grid, visited, i+1, j);
            }
            if (j - 1 >= 0 && !visited[i][j-1] && map.containsKey(grid[i][j-1])) {
                map.get(grid[i][j-1]).lookForWords(grid, visited, i, j-1);
            }
            if (j + 1 < grid[i].length && !visited[i][j+1] && map.containsKey(grid[i][j+1])) {
                map.get(grid[i][j+1]).lookForWords(grid, visited, i, j+1);
            }
            visited[i][j] = false;
        }
    }   

    public List<String> findWords(char[][] board, String[] words) {
        Node trie = new Node(false);

        int idx = 0;
        for (String word : words) {
            Node cur = trie;
            int i = 0;
            while (i < word.length() && cur.map.containsKey(word.charAt(i))) {
                cur = cur.map.get(word.charAt(i));
                i++;
            }

            if (i == word.length()) {
                cur.isWord = true;
                cur.idxInWords = idx;
            }
            else cur.addWordFromStartingHere(word, i, idx);
            idx++;
        }

        HashSet<Integer> found = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length && found.size() < words.length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (trie.map.containsKey(board[i][j])) {
                    //visited[i][j] = true;
                    trie.map.get(board[i][j]).lookForWords(board, visited, i, j);
                }
            }
        }

        List<String> ret = new ArrayList<>();
        for (Integer x : res) ret.add(words[x]);
        return ret;
    }

}
