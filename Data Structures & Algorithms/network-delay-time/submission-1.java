class Solution {
    class Node implements Comparable<Node> {
        public int idx;
        public int dist;
        public boolean visited;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
            this.visited = false;
        }

        public int compareTo(Node other) {
            if (this.dist < other.dist) return -1;
            if (this.dist > other.dist) return 1;
            return 0;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> cost = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
            cost.add(new ArrayList<Integer>());
        }

        for (int[] time : times) {
            adjList.get(time[0] - 1).add(time[1] - 1);
            cost.get(time[0] - 1).add(time[2]);
        }

        // for (ArrayList<Integer> arr : adjList) {
        //     for (Integer i : arr) System.out.print(i + " ");
        //     System.out.println();
        // }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add(new Node(i, Integer.MAX_VALUE));
        nodes.get(k - 1).dist = 0;
        pq.add(nodes.get(k - 1));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            //System.out.println(cur.idx);
            if (cur.visited) continue;

            for (int v = 0; v < adjList.get(cur.idx).size(); v++) {
                if (!nodes.get(adjList.get(cur.idx).get(v)).visited) {
                    //System.out.println(adjList.get(cur.idx).get(v) + " " + cur.idx + " " + cur.dist);
                    nodes.get(adjList.get(cur.idx).get(v)).dist = Math.min(nodes.get(adjList.get(cur.idx).get(v)).dist, cur.dist + cost.get(cur.idx).get(v));
                    pq.add(nodes.get(adjList.get(cur.idx).get(v)));
                }
                // } else {
                //     System.out.println(". " + adjList.get(cur.idx).get(v) + " " + cur.idx + " " + cur.dist);
                //     if (nodes.get(adjList.get(cur.idx).get(v)).dist > cur.dist + cost.get(cur.idx).get(v)) {
                //         nodes.get(adjList.get(cur.idx).get(v)).dist = cur.dist + cost.get(cur.idx).get(v);
                //         nodes.get(adjList.get(cur.idx).get(v)).visited = false;
                //         pq.add(nodes.get(adjList.get(cur.idx).get(v)));
                //     }
                // }
            }

            cur.visited = true;
        }

        // for (Node node : nodes) 
        //     System.out.println(node.idx + " " + node.dist + " " + node.visited);

        int max = 0;
        boolean all = true;
        for (Node node : nodes) {
            if (node.dist > max) max = node.dist;
            if (node.dist == Integer.MAX_VALUE) all = false;
        }

        if (all) return max;
        return -1;
    }
}
