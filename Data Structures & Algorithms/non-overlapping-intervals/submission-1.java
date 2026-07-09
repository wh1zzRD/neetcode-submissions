class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] < b[0]? -1: a[0] == b[0]? (a[1] < b[1]? -1: a[1] == b[1]? 0 : 1) : 1);

        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
