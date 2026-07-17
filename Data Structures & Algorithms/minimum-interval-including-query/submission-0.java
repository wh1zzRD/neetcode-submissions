class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            boolean found = false;
            int minLength = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] <= queries[i] && queries[i] <= intervals[j][1]) {
                    //System.out.println(queries[i] + " " + (intervals[j][1] - intervals[j][0]));

                    if (intervals[j][1] - intervals[j][0] < minLength) {
                        minLength = intervals[j][1] - intervals[j][0];
                    }
                    found = true;
                }
            }
            if (found) res[i] = minLength + 1;
            else res[i] = -1;
        }

        return res;
    }
}
