class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] copyQueries = new int[queries.length];
        for (int i = 0; i < queries.length; i++) copyQueries[i] = queries[i];

        Arrays.sort(copyQueries);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<ArrayList<Integer>>((a, b) -> a.get(0) - b.get(0));
        int p = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            while (p < intervals.length && intervals[p][0] <= copyQueries[i]) {
                heap.add(new ArrayList<Integer>(Arrays.asList(intervals[p][1] - intervals[p][0] + 1, intervals[p][1])));
                p++;
            }

            while (!heap.isEmpty() && heap.peek().get(1) < copyQueries[i]) heap.poll();

            if (!heap.isEmpty())
                map.put(copyQueries[i], heap.peek().get(0));
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) res[i] = map.getOrDefault(queries[i], -1);

        return res;
    }
}
