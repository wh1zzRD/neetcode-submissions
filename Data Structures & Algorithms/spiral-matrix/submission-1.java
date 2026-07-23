class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (left <= right && up <= down) {
            res.add(matrix[up][left]);

            if (left == right) {
                for (int i = up+1; i <= down; i++) res.add(matrix[i][left]);
                break;
            }
            if (up == down) {
                for (int i = left + 1; i <= right; i++) res.add(matrix[up][i]);
                break;
            }

            for (int i = left+1; i < right; i++) res.add(matrix[up][i]);
            for (int i = up + (left == right? 1: 0); i < down; i++) res.add(matrix[i][right]);
            for (int i = right; i > left; i--) res.add(matrix[down][i]);
            for (int i = down; i > up; i--) res.add(matrix[i][left]);

            left++; right--;
            up++; down--;
        }
        

        return res;
    }

    public int length(int[][] matrix) {
        int l = Math.min(matrix.length, matrix[0].length);
        if (l % 2 == 1) return l / 2 + 1;
        return l / 2;
    }
}
