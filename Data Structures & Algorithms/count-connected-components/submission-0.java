class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        for (int start = 0; start < n; start++) {
            if (visited[start]) continue;
            connectedComponents++;

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            while (!q.isEmpty()) {
                int tmp = q.remove();
                visited[tmp] = true;
                for (Integer v : adjList.get(tmp)) {
                    if (!visited[v]) q.add(v);
                }
            }
        }

        return connectedComponents;
    }
}
