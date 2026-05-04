class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Integer>> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) squares.add(new HashSet<>());

        ArrayList<HashSet<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) rows.add(new HashSet<>());

        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < 9; i++) columns.add(new HashSet<>());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                if (columns.get(j).contains(board[i][j] - '0')) return false;
                columns.get(j).add(board[i][j] - '0');

                if (rows.get(i).contains(board[i][j] - '0')) return false;
                rows.get(i).add(board[i][j] - '0');

                if (squares.get((i/3)*3 + j / 3).contains(board[i][j] - '0')) return false;
                squares.get((i/3)*3 + j / 3).add(board[i][j] - '0');
            }
        }
        return true;
    }
}
