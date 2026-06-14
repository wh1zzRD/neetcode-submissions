class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        int countFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    grid[i][j] = 0;
                }

                grid[i][j] *= -1;
            }
        }

        int rotten = 0;
        int time = 0;
        while (!q.isEmpty()) {
            ArrayList<Integer> tmp = q.remove();
            int i = tmp.get(0);
            int j = tmp.get(1);

            if (i - 1 >= 0 && grid[i-1][j] == -1) {
                q.add(new ArrayList<Integer>(Arrays.asList(i-1, j)));
                grid[i-1][j] = grid[i][j] + 1;
            }
            if (j - 1 >= 0 && grid[i][j-1] == -1) {
                q.add(new ArrayList<Integer>(Arrays.asList(i, j-1)));
                grid[i][j-1] = grid[i][j] + 1;
            }
            if (i + 1 < grid.length && grid[i+1][j] == -1) {
                q.add(new ArrayList<Integer>(Arrays.asList(i+1, j)));
                grid[i+1][j] = grid[i][j] + 1;
            }
            if (j + 1 < grid[i].length && grid[i][j+1] == -1) {
                q.add(new ArrayList<Integer>(Arrays.asList(i, j+1)));
                grid[i][j+1] = grid[i][j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) return -1;
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
