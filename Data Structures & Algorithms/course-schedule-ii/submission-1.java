class Solution {
    public int[] visited;
    public int[] topo;
    public int c;

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        topo = new int[numCourses];
        c = numCourses - 1;

        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<Integer>());
        for (int[] p : prerequisites) adjList.get(p[1]).add(p[0]);

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != 2) {
                if (!visit(i)) return new int[]{};
            }
        }

        return topo;

    }

    public boolean visit(int n) {
        if (visited[n] == 2) return true;
        if (visited[n] == 1) return false;

        System.out.println(n);

        visited[n] = 1;

        for (int m : adjList.get(n)) if (!visit(m)) return false;

        visited[n] = 2;
        topo[c--] = n;

        return true;
    }
}
