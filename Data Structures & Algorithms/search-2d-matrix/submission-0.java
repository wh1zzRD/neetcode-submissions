class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] <= target) l = mid;
            else r = mid;
        }

        int row = l;
        l = 0;
        r = matrix[row].length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] <= target) l = mid;
            else r = mid;
        }

        if (matrix[row][l] == target) return true;
        return false;
    }
}
