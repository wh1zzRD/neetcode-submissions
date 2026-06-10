class Solution {
    public int islands = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    ArrayDeque<ArrayList<Integer>> q = new ArrayDeque<>();
                    q.addLast(new ArrayList<Integer>(Arrays.asList(i, j)));

                    while (!q.isEmpty()) {
                        ArrayList<Integer> tmp = q.removeFirst();
                        int a = tmp.get(0);
                        int b = tmp.get(1);
                        grid[a][b] = 0;

                        if (a - 1 >= 0 && grid[a-1][b] == '1') {
                            q.addLast(new ArrayList<Integer>(Arrays.asList(a - 1, b)));
                        }
                        if (b - 1 >= 0 && grid[a][b-1] == '1') {
                            q.addLast(new ArrayList<Integer>(Arrays.asList(a, b - 1)));
                        }
                        if (a + 1 < grid.length && grid[a+1][b] == '1') {
                            q.addLast(new ArrayList<Integer>(Arrays.asList(a + 1, b)));
                        }
                        if (b + 1 < grid[a].length && grid[a][b+1] == '1') {
                            q.addLast(new ArrayList<Integer>(Arrays.asList(a, b + 1)));
                        }
                    }
                }
            }
        }
        return islands;
    }
}
