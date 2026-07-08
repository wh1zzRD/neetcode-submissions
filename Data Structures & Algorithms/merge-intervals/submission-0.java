class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] < b[0]? -1 : a[0] == b[0]? 0 : 1);
        
        int countFinalIntervals = 1;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prevEnd) {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            } else {
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
                countFinalIntervals++;
            }
        }

        int[][] res = new int[countFinalIntervals][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int c = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= res[c][1]) {
                res[c][1] = Math.max(res[c][1], intervals[i][1]);
            } else {
                res[c+1][0] = intervals[i][0];
                res[c+1][1] = intervals[i][1];
                c++;
            }
        }
        return res;
    }
}
