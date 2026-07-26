class Position implements Comparable<Position> {
    int i;
    int j;
    int cost;
    boolean visited;
    public Position(int i, int j, int cost) {
        this.i = i;
        this.j = j;
        this.cost = cost;
        this.visited = false;
    }
    public int compareTo(Position other) {return this.cost - other.cost;}
}

class Solution {
    public int swimInWater(int[][] grid) {
        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid[0].length; j++) {
        //         if (i == 0 && j == 0) continue;
        //         grid[i][j] -= grid[0][0];
        //     }
        // }
        // grid[0][0] = 0;

        Position[][] minNeeded = new Position[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                minNeeded[i][j] = new Position(i, j, -1);
            }
        }
        minNeeded[0][0].cost = grid[0][0];

        PriorityQueue<Position> heap = new PriorityQueue<>();
        heap.add(minNeeded[0][0]);

        while (!heap.isEmpty()) {
            Position tmp = heap.poll();
            tmp.visited = true;
            int i = tmp.i;
            int j = tmp.j;

            if (i - 1 >= 0 && !minNeeded[i-1][j].visited) {
                if (minNeeded[i-1][j].cost == -1 || minNeeded[i-1][j].cost >= Math.max(tmp.cost, grid[i-1][j])) {
                    minNeeded[i-1][j].cost = Math.max(tmp.cost, grid[i-1][j]);
                    heap.add(minNeeded[i-1][j]);
                }
            }
            if (i + 1 < grid.length && !minNeeded[i+1][j].visited) {
                if (minNeeded[i+1][j].cost == -1 || minNeeded[i+1][j].cost >= Math.max(tmp.cost, grid[i+1][j])) {
                    minNeeded[i+1][j].cost = Math.max(tmp.cost, grid[i+1][j]);
                    heap.add(minNeeded[i+1][j]);
                }
            }
            if (j - 1 >= 0 && !minNeeded[i][j-1].visited) {
                if (minNeeded[i][j-1].cost == -1 || minNeeded[i][j-1].cost >= Math.max(tmp.cost, grid[i][j-1])) {
                    minNeeded[i][j-1].cost = Math.max(tmp.cost, grid[i][j-1]);
                    heap.add(minNeeded[i][j-1]);
                }
            }
            if (j + 1 < grid[0].length && !minNeeded[i][j+1].visited) {
                if (minNeeded[i][j+1].cost == -1 || minNeeded[i][j+1].cost >= Math.max(tmp.cost, grid[i][j+1])) {
                    minNeeded[i][j+1].cost = Math.max(tmp.cost, grid[i][j+1]);
                    heap.add(minNeeded[i][j+1]);
                }
            }
        }

        return minNeeded[grid.length-1][grid[0].length-1].cost;
    }
}
