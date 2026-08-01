class Pair implements Comparable<Pair> {
    char c;
    int frequency;
    int lastUsed;
    public Pair(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public int compareTo(Pair other) {
        return this.frequency - other.frequency;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);

        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> e : map.entrySet()) 
            heap.add(new Pair(e.getKey(), e.getValue()));

        Queue<Pair> q = new LinkedList<>();

        int counter = 0;
        while (!heap.isEmpty() || !q.isEmpty()) {
            while (!q.isEmpty() && q.peek().lastUsed < counter - n) heap.add(q.remove());

            Pair mostFrequent = heap.poll();
            if (mostFrequent == null) {
                counter++;
                continue;
            }
            mostFrequent.lastUsed = counter;
            mostFrequent.frequency--;
            counter++;

            if (mostFrequent.frequency > 0)
                q.add(mostFrequent);
        }
        return counter;
    }
}
