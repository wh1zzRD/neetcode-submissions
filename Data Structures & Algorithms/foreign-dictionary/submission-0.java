class Solution {
    ArrayList<Integer> post = new ArrayList<>();
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    int[] state = new int[26];
    boolean cycle = false;

    public String foreignDictionary(String[] words) {
        for (int i = 0; i < 26; i++) adjList.add(new ArrayList<>());
        HashSet<Character> set = new HashSet<>();

        int[] inDeg = new int[26];
        for (int i = 0; i < words.length-1; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i+1].length() && words[i].charAt(j) == words[i+1].charAt(j)) j++;
            //System.out.println(i + " " + j);
            if (j < words[i].length() && j < words[i+1].length()) {
                adjList.get(words[i].charAt(j) - 'a').add(words[i+1].charAt(j) - 'a');
                inDeg[words[i].charAt(j) - 'a']++;
            }
            if (j == words[i+1].length() && words[i+1].length() < words[i].length()) return "";
            
            for (int c = 0; c < words[i].length(); c++) set.add(words[i].charAt(c));
        }
        for (int c = 0; c < words[words.length - 1].length(); c++) set.add(words[words.length - 1].charAt(c));

        for (int i = 0; i < 26; i++) {
            if (state[i] != 2) dfs(i);
        }

        if (cycle) return "";
        String res = "";
        //System.out.println(post.toString());
        for (int i = post.size() - 1; i >= 0; i--) {
            //System.out.println((char) ('a' + post.get(i)));
            if (set.contains((char) ('a' + post.get(i)))) {
                //System.out.println(post.get(i));
                res += String.valueOf((char) ('a' + post.get(i)));
            }
        }
        return res;

    }

    public void dfs(int v) {
        state[v] = 1;

        for (Integer e : adjList.get(v)) {
            if (state[e] == 1) cycle = true;
            if (state[e] == 0) dfs(e);
        }
        state[v] = 2;
        post.add(v);
    }
}
