class Pair implements Comparable<Pair>{
    public int length;
    public int right;

    public Pair(int length, int right) {
        this.length = length;
        this.right = right;
    }

    public int compareTo(Pair other) {
        return this.length - other.length;
    }

}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] copyQueries = new int[queries.length];
        for (int i = 0; i < queries.length; i++) copyQueries[i] = queries[i];

        Arrays.sort(copyQueries);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int p = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            while (p < intervals.length && intervals[p][0] <= copyQueries[i]) {
                heap.add(new Pair(intervals[p][1] - intervals[p][0] + 1, intervals[p][1]));
                p++;
            }

            while (!heap.isEmpty() && heap.peek().right < copyQueries[i]) heap.poll();

            if (!heap.isEmpty())
                map.put(copyQueries[i], heap.peek().length);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) res[i] = map.getOrDefault(queries[i], -1);

        return res;
    }
}
