class Solution {
    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // int[] inDeg = new int[n];

        for (int[] edge : edges) {
            if (edge[0] == edge[1]) return false;
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

            // inDeg[edge[0]]++;
            // inDeg[edge[1]]++;
        }

        // if (n == 1) return true;

        int[] cameFrom = new int[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        cameFrom[0] = -1;
        for (int x : adjList.get(0)) cameFrom[x] = 0;

        while (!q.isEmpty()) {
            int tmp = q.remove();
            visited[tmp] = true;

            for (int x : adjList.get(tmp)) {
                if (visited[x] && cameFrom[tmp] != x) return false;
                
                if (!visited[x]) {
                    q.add(x);
                    cameFrom[x] = tmp;
                }
            }
        }

        for (boolean v : visited) if (!v) return false;
        return true;
    }
}
