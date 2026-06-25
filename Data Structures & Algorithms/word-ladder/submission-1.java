class Solution {
    public boolean oneLetterDifference(String word1, String word2) {
        boolean differenceFound = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && differenceFound) return false;
            else if (word1.charAt(i) != word2.charAt(i) && !differenceFound) differenceFound = true;
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < wordList.size() + 1; i++) adjList.add(new ArrayList<Integer>());

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (oneLetterDifference(wordList.get(i), wordList.get(j))) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (oneLetterDifference(wordList.get(i), beginWord)) {
                adjList.get(i).add(wordList.size());
                adjList.get(wordList.size()).add(i);
            }
        }

        int indexEnd = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (endWord.equals(wordList.get(i))) indexEnd = i;
        }
        if (indexEnd == -1) return 0;

        int[] distance = new int[wordList.size() + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(wordList.size());
        distance[wordList.size()] = -1;
        for (Integer v : adjList.get(wordList.size())) {
            distance[v] = 1;
            q.add(v);
        }

        while (!q.isEmpty()) {
            int tmp = q.remove();

            for (Integer v : adjList.get(tmp)) {
                if (distance[v] == 0) {
                    q.add(v);
                    distance[v] = distance[tmp] + 1;
                }
            }
        }

        if (distance[indexEnd] == -1 || distance[indexEnd] == 0) return 0;
        return distance[indexEnd] + 1;
    }
}
