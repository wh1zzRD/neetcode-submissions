class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<ArrayList<Integer>>(
            (a, b) -> Math.sqrt(a.get(0) * a.get(0) + a.get(1) * a.get(1)) - Math.sqrt(b.get(0) * b.get(0) + b.get(1) * b.get(1)) < 0? -1 : 1
        );

        for (int[] point : points) {
            heap.add(new ArrayList<Integer>(Arrays.asList(point[0], point[1])));
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> p = heap.poll();
            res[i][0] = p.get(0);
            res[i][1] = p.get(1);
        }

        return res;

    }
}
