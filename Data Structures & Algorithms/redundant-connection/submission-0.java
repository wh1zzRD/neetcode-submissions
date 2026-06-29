class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        // for (ArrayList<Integer> arr : adjList) {
        //     for (Integer v : arr) System.out.print(v + " ");
        //     System.out.println();
        // }
        // System.out.println();

        for (int i = edges.length - 1; i >= 0; i--) {
            boolean[] visited = new boolean[edges.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while (!q.isEmpty()) {
                int tmp = q.remove();
                for (int v : adjList.get(tmp)) {
                    if ((tmp == edges[i][0] - 1 && v == edges[i][1] - 1) || (tmp == edges[i][1] - 1 && v == edges[i][0] - 1)) {
                        // System.out.println(edges[i][0] + " " + edges[i][1]);
                        continue;
                    }
                    if (visited[v]) continue;

                    q.add(v);
                }
                visited[tmp] = true;
            }
            boolean stillConnected = true;
            for (boolean v : visited) {
                // System.out.print(v + " ");
                if (!v) stillConnected = false;
            }
            // System.out.println();
            if (stillConnected) {
                return edges[i];
            }
        }
        return null;
    }
}
