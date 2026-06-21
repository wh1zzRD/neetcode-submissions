class Solution {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                Queue<ArrayList<Integer>> q = new LinkedList<>();
                HashSet<ArrayList<Integer>> visited = new HashSet<>();
                q.add(new ArrayList<Integer>(Arrays.asList(0, i)));

                while (!q.isEmpty()) {
                    ArrayList<Integer> tmp = q.remove();
                    int y = tmp.get(0);
                    int x = tmp.get(1);

                    visited.add(tmp);
                    board[y][x] = 'Z';

                    if (y - 1 >= 0 && board[y-1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y-1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y-1, x)));
                    }
                    if (y + 1 < board.length && board[y+1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y+1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y+1, x)));
                    }
                    if (x - 1 >= 0 && board[y][x-1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x-1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x-1)));
                    }
                    if (x + 1 < board[y].length && board[y][x+1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x+1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x+1)));
                    }
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length-1][i] == 'O') {
                Queue<ArrayList<Integer>> q = new LinkedList<>();
                HashSet<ArrayList<Integer>> visited = new HashSet<>();
                q.add(new ArrayList<Integer>(Arrays.asList(board.length-1, i)));

                while (!q.isEmpty()) {
                    ArrayList<Integer> tmp = q.remove();
                    int y = tmp.get(0);
                    int x = tmp.get(1);

                    visited.add(tmp);
                    board[y][x] = 'Z';

                    if (y - 1 >= 0 && board[y-1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y-1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y-1, x)));
                    }
                    if (y + 1 < board.length && board[y+1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y+1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y+1, x)));
                    }
                    if (x - 1 >= 0 && board[y][x-1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x-1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x-1)));
                    }
                    if (x + 1 < board[y].length && board[y][x+1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x+1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x+1)));
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length-1] == 'O') {
                Queue<ArrayList<Integer>> q = new LinkedList<>();
                HashSet<ArrayList<Integer>> visited = new HashSet<>();
                q.add(new ArrayList<Integer>(Arrays.asList(i, board[0].length-1)));

                while (!q.isEmpty()) {
                    ArrayList<Integer> tmp = q.remove();
                    int y = tmp.get(0);
                    int x = tmp.get(1);

                    visited.add(tmp);
                    board[y][x] = 'Z';

                    if (y - 1 >= 0 && board[y-1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y-1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y-1, x)));
                    }
                    if (y + 1 < board.length && board[y+1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y+1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y+1, x)));
                    }
                    if (x - 1 >= 0 && board[y][x-1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x-1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x-1)));
                    }
                    if (x + 1 < board[y].length && board[y][x+1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x+1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x+1)));
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                Queue<ArrayList<Integer>> q = new LinkedList<>();
                HashSet<ArrayList<Integer>> visited = new HashSet<>();
                q.add(new ArrayList<Integer>(Arrays.asList(i, 0)));

                while (!q.isEmpty()) {
                    ArrayList<Integer> tmp = q.remove();
                    int y = tmp.get(0);
                    int x = tmp.get(1);

                    visited.add(tmp);
                    board[y][x] = 'Z';

                    if (y - 1 >= 0 && board[y-1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y-1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y-1, x)));
                    }
                    if (y + 1 < board.length && board[y+1][x] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y+1, x)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y+1, x)));
                    }
                    if (x - 1 >= 0 && board[y][x-1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x-1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x-1)));
                    }
                    if (x + 1 < board[y].length && board[y][x+1] == 'O' && !visited.contains(new ArrayList<Integer>(Arrays.asList(y, x+1)))) {
                        q.add(new ArrayList<Integer>(Arrays.asList(y, x+1)));
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Z') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}
