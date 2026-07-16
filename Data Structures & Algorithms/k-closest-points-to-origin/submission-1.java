class Point implements Comparable<Point>{
    public int a;
    public int b;
    public Point(int a, int b) {this.a = a; this.b = b;}

    public int compareTo(Point other) {
        double tmp = Math.sqrt(this.a * this.a + this.b * this.b) - Math.sqrt(other.a * other.a + other.b * other.b);
        if (tmp < 0) return -1;
        if (tmp > 0) return 1;
        return 0;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<Point>();

        for (int[] point : points) {
            heap.add(new Point(point[0], point[1]));
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = heap.poll();
            res[i][0] = p.a;
            res[i][1] = p.b;
        }

        return res;

    }
}
