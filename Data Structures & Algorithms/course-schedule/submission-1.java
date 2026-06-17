class Solution {
    int[] visited;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<Integer>());

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != 2) {
                if (!visit(i)) return false;
            }
        }

        return true;
        
    }

    public boolean visit(int v) {
        if (visited[v] == 2) return true;
        if (visited[v] == 1) return false;

        visited[v] = 1;
        for (Integer n : adjList.get(v)) {
            if (!visit(n)) return false;
        }

        visited[v] = 2;
        return true;
    }
}
