class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = 0;
        int cols = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        var list = new ArrayList<Integer>();
        while (rows <= cols && top <= bottom) {
            for(int i = rows; i <= cols; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i<=bottom; i++) {
                list.add(matrix[i][cols]);
            }
            cols--;
            if(!(rows <= cols && top <= bottom)) {
                break;
            }
            for (int i = cols; i >= rows; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                list.add(matrix[i][rows]);
            }
            rows++;
        }
        return list;
    }
}
