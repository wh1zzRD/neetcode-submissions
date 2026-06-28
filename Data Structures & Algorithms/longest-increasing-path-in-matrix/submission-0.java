class Solution {
    int[][] longestStartingFrom;
    public int longestIncreasingPath(int[][] matrix) {
        longestStartingFrom = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, calculateLongestStartingFrom(matrix, i, j));
            }
        }

        return max;
    }

    public int calculateLongestStartingFrom(int[][] matrix, int i, int j) {
        if (longestStartingFrom[i][j] != 0) return longestStartingFrom[i][j];

        longestStartingFrom[i][j] = 1;
        if (i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            longestStartingFrom[i][j] = Math.max(longestStartingFrom[i][j], 1 + calculateLongestStartingFrom(matrix, i-1, j));
        } if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
            longestStartingFrom[i][j] = Math.max(longestStartingFrom[i][j], 1 + calculateLongestStartingFrom(matrix, i, j-1));
        } if (i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            longestStartingFrom[i][j] = Math.max(longestStartingFrom[i][j], 1 + calculateLongestStartingFrom(matrix, i+1, j));
        } if (j + 1 < matrix[i].length && matrix[i][j+1] > matrix[i][j]) {
            longestStartingFrom[i][j] = Math.max(longestStartingFrom[i][j], 1 + calculateLongestStartingFrom(matrix, i, j+1));
        }

        return longestStartingFrom[i][j];
    }
}
