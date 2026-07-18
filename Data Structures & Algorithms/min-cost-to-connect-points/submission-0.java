class Pair implements Comparable<Pair> {
    public int distance;
    public int pointIndex;

    public Pair(int distance, int pointIndex) {
        this.distance = distance;
        this.pointIndex = pointIndex;
    }

    public int compareTo(Pair other) {
        return this.distance - other.distance;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 0) return 0;
        
        boolean[] visited = new boolean[points.length];
        int totalVisited = 0;
        int cur = 0;
        int totalLength = 0;

        PriorityQueue<Pair> heap = new PriorityQueue<>();

        for (int i = 1; i < points.length; i++) {
            heap.add(new Pair(Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]), i));
        }

        visited[0] = true;
        totalVisited++;

        while (totalVisited < points.length) {
            while (visited[heap.peek().pointIndex]) heap.poll();

            cur = heap.peek().pointIndex;
            totalLength += heap.peek().distance;
            visited[cur] = true;
            totalVisited++;

            for (int i = 0; i < points.length; i++) {
                if (visited[i]) continue;

                heap.add(new Pair(Math.abs(points[cur][0] - points[i][0]) + Math.abs(points[cur][1] - points[i][1]), i));
            }
        }

        return totalLength;

    }
}
