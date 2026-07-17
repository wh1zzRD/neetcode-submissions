/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;
        
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int l = 0;
        int r = 0;

        int maxOngoing = 0;

        while (l < intervals.size()) {
            while (l < intervals.size() && start[l] < end[r]) l++;
            if (l == intervals.size()) break;
            maxOngoing = Math.max(maxOngoing, l - r);
            while (end[r] <= start[l]) r++;
        }

        maxOngoing = Math.max(maxOngoing, l - r);

        return maxOngoing;
    }
}
