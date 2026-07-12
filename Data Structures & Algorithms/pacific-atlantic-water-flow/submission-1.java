class Solution {
    boolean[][] visited1;
    boolean[][] visited2;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        visited1 = new boolean[heights.length][heights[0].length];
        visited2 = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i++) {
            bfs1(0, i, heights);
            bfs2(heights.length - 1, i, heights);
        }
        for (int i = 0; i < heights.length; i++) {
            bfs1(i, 0, heights);
            bfs2(i, heights[0].length - 1, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    res.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }

        return res;
    }

    public void bfs1(int i, int j, int[][] heights) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<Integer>(Arrays.asList(i, j)));
        visited1[i][j] = true;

        while (!q.isEmpty()) {
            ArrayList<Integer> tmp = q.remove();
            int a = tmp.get(0);
            int b = tmp.get(1);

            if (a + 1 < heights.length && !visited1[a+1][b] && heights[a+1][b] >= heights[a][b]) {
                bfs1(a + 1, b, heights);
            } if (a - 1 >= 0 && !visited1[a-1][b] && heights[a-1][b] >= heights[a][b]) {
                bfs1(a - 1, b, heights);
            } if (b + 1 < heights[0].length && !visited1[a][b+1] && heights[a][b+1] >= heights[a][b]) {
                bfs1(a, b + 1, heights);
            } if (b - 1 >= 0 && !visited1[a][b-1] && heights[a][b-1] >= heights[a][b]) {
                bfs1(a, b - 1, heights);
            }
        }
    }

    public void bfs2(int i, int j, int[][] heights) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<Integer>(Arrays.asList(i, j)));
        visited2[i][j] = true;

        while (!q.isEmpty()) {
            ArrayList<Integer> tmp = q.remove();
            int a = tmp.get(0);
            int b = tmp.get(1);

            if (a + 1 < heights.length && !visited2[a+1][b] && heights[a+1][b] >= heights[a][b]) {
                bfs2(a + 1, b, heights);
            } if (a - 1 >= 0 && !visited2[a-1][b] && heights[a-1][b] >= heights[a][b]) {
                bfs2(a - 1, b, heights);
            } if (b + 1 < heights[0].length && !visited2[a][b+1] && heights[a][b+1] >= heights[a][b]) {
                bfs2(a, b + 1, heights);
            } if (b - 1 >= 0 && !visited2[a][b-1] && heights[a][b-1] >= heights[a][b]) {
                bfs2(a, b - 1, heights);
            }
        }
    }
}
