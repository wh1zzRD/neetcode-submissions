class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> allIntervals = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if (interval[0] > newInterval[0] && !added) {
                allIntervals.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
                added = true;
            }
            allIntervals.add(new ArrayList<Integer>(Arrays.asList(interval[0], interval[1])));
        }
        if (!added) allIntervals.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(allIntervals.getFirst());
        for (int i = 1; i < allIntervals.size(); i++) {
            if (res.getLast().get(1) >= allIntervals.get(i).get(0)) {
                res.getLast().set(1, Math.max(res.getLast().get(1), allIntervals.get(i).get(1)));
            } else {
                res.addLast(allIntervals.get(i));
            }
        }

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i][0] = res.get(i).get(0);
            r[i][1] = res.get(i).get(1);
        }

        return r;
    }
}
