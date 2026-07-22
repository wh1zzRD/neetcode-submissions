class Solution {
    public boolean exist(char[][] board, String word) {
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[i].length; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;

                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, visited, word, 1, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int current, int i, int j) {
        if (current == word.length()) return true;
        //System.out.println();
        //System.out.println(i + " " + j + " " + board[i][j]);

        // if (i - 1 >= 0 && !visited[i-1][j]) {
        //     System.out.print(board[i-1][j] + " ");
        // } else System.out.print("- ");
        // if (i + 1 < board.length && !visited[i+1][j]) {
        //     System.out.print(board[i+1][j] + " ");
        // } else System.out.print("- ");
        // if (j - 1 >= 0 && !visited[i][j-1]) {
        //     System.out.print(board[i][j-1] + " ");
        // } else System.out.print("- ");
        // if (j + 1 < board[i].length && !visited[i][j+1]) {
        //     System.out.print(board[i][j+1] + " ");
        // } else System.out.print("- ");
        // System.out.println();

        visited[i][j] = true;
        boolean result = false;
        if (i - 1 >= 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(current)) {
            //System.out.println(i + " " + j + " (1)");
            result = result || dfs(board, visited, word, current + 1, i-1, j);
        }
        if (i + 1 < board.length && !visited[i+1][j] && board[i+1][j] == word.charAt(current)) {
            //System.out.println(i + " " + j + " (2)");
            result = result || dfs(board, visited, word, current + 1, i+1, j);
        }
        if (j - 1 >= 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(current)) {
            //System.out.println(i + " " + j + " (3)");
            result = result || dfs(board, visited, word, current + 1, i, j - 1);
        }
        if (j + 1 < board[i].length && !visited[i][j+1] && board[i][j+1] == word.charAt(current)) {
            //System.out.println(i + " " + j + " (4)");
            result = result || dfs(board, visited, word, current + 1, i, j + 1);
        }

        visited[i][j] = false;

        return result;
    }
}
