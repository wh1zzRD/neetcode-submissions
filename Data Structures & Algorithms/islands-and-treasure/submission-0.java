class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new ArrayList<Integer>(Arrays.asList(i, j, 0)));
                }
            }
        }

        while (!q.isEmpty()) {
            ArrayList<Integer> l = q.remove();
            int i = l.get(0);
            int j = l.get(1);
            int d = l.get(2);

            if (i - 1 >= 0 && grid[i-1][j] == Integer.MAX_VALUE) {
                grid[i-1][j] = d + 1;
                q.add(new ArrayList<Integer>(Arrays.asList(i-1, j, d + 1)));
            }
            if (i + 1 < grid.length && grid[i+1][j] == Integer.MAX_VALUE) {
                grid[i+1][j] = d + 1;
                q.add(new ArrayList<Integer>(Arrays.asList(i+1, j, d + 1)));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == Integer.MAX_VALUE) {
                grid[i][j-1] = d + 1;
                q.add(new ArrayList<Integer>(Arrays.asList(i, j-1, d + 1)));
            }
            if (j + 1 < grid[i].length && grid[i][j+1] == Integer.MAX_VALUE) {
                grid[i][j+1] = d + 1;
                q.add(new ArrayList<Integer>(Arrays.asList(i, j+1, d + 1)));
            }
        }
    }
}
