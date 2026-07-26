class Vertex implements Comparable<Vertex> {
    int cost = -1;

    ArrayList<Vertex> edges;
    ArrayList<Integer> costs;
    public Vertex(ArrayList<Vertex> edges, ArrayList<Integer> cost) {
        this.edges = edges;
        this.costs = costs;
    }
    public Vertex() {
        this.edges = new ArrayList<>();
        this.costs = new ArrayList<>();
    }
    public void addEdgeTo(Vertex v, Integer cost) {
        edges.add(v);
        costs.add(cost);
    }
    public int compareTo(Vertex other) {
        return this.cost - other.cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Vertex> graph = new ArrayList<>();
        for (int i = 0; i < n + n + k * n; i++) graph.add(new Vertex());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                graph.get(n * j + i).addEdgeTo(graph.get(n * (j + 1) + i), 0);
            }
        }

        for (int[] flight: flights) {
            for (int j = 0; j < k + 1; j++) {
                graph.get(n * j + flight[0]).addEdgeTo(graph.get(n * (j + 1) + flight[1]), flight[2]);
            }
        }

        graph.get(src).cost = 0;
        PriorityQueue<Vertex> heap = new PriorityQueue<>();
        heap.add(graph.get(src));

        while (!heap.isEmpty()) {
            Vertex tmp = heap.poll();

            for (int i = 0; i < tmp.edges.size(); i++) {
                if (tmp.edges.get(i).cost != -1 && tmp.edges.get(i).cost <= tmp.cost + tmp.costs.get(i)) continue;

                tmp.edges.get(i).cost = tmp.cost + tmp.costs.get(i);
                heap.add(tmp.edges.get(i));
            }
        }

        return graph.get(n * (k + 1) + dst).cost;

    }
}
