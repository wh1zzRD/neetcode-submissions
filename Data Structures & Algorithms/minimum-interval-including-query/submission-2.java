class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] copyQueries = new int[queries.length];
        for (int i = 0; i < queries.length; i++) copyQueries[i] = queries[i];

        Arrays.sort(copyQueries);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int l = leftMost(copyQueries, intervals[i][0]);
            int r = rightMost(copyQueries, intervals[i][1]);

            for (int j = l; j <= r; j++) {
                map.put(copyQueries[j], Math.min(intervals[i][1] - intervals[i][0] + 1, map.getOrDefault(copyQueries[j], Integer.MAX_VALUE)));
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.getOrDefault(queries[i], -1);
        }

        return res;
    }

    public int leftMost(int[] queries, int n) {
        int l = 0;
        int r = queries.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (queries[mid] < n) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    public int rightMost(int[] queries, int n) {
        int l = 0;
        int r = queries.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (queries[mid] <= n) l = mid + 1;
            else r = mid;
        }

        return l - 1;
    }
}
