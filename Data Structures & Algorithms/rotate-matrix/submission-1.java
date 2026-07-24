class Solution {
    public void rotate(int[][] matrix) {

        // [1,  2, 3, 4, 5, 6]
        // [5,  6, 7, 8, 9,10]
        // [9, 10,11,12,13,14]
        // [13,14,15,16,17,18]
        // [3,  4, 5, 6, 7, 8]
        // [8,  7, 6, 5, 4, 3]

        for (int layer = 0; layer < matrix.length/2; layer++) {
            for (int i = 0; i < matrix.length - 2 * layer - 1; i++) {
                int a = matrix[layer][layer+i];
                int b = matrix[layer+i][matrix.length-layer-1];
                int c = matrix[matrix.length-layer-1-i][layer];
                int d = matrix[matrix.length-layer-1][matrix.length-layer-1-i];

                //System.out.println(a + " " + b + " " + c + " " + d);

                matrix[layer][layer+i] = c;
                matrix[matrix.length-layer-1-i][layer] = d;
                matrix[matrix.length-layer-1][matrix.length-layer-1-i] = b;
                matrix[layer+i][matrix.length-layer-1] = a;
            }
        }
    }
}
