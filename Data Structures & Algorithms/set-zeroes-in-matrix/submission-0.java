class Solution {
    public void setZeroes(int[][] matrix) {
        List<Pair> pairs = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        traverseMatrix(matrix, pairs);
        for (Pair entry : pairs) {
            int row = entry.row;
            int col = entry.col;
            for (int i = col; i >= left; i--) {
                matrix[row][i] = 0;
            }
            for (int i = col; i < right; i++) {
                matrix[row][i] = 0;
            }
            for (int i = row; i < bottom; i++) {
                matrix[i][col] = 0;
            }
            for (int i = row; i >= top; i--) {
                matrix[i][col] = 0;
            }
        }
    }

    public void traverseMatrix(int[][] matrix, List<Pair> list) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
    }

    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
