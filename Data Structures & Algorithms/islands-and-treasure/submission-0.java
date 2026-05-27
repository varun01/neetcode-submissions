class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, grid[i][j], visited);
                }
            }
        }
    }

    public void dfs(int row, int col, int[][] grid, int path, Set<String> visited) {
        String str = String.format("%s,%s", row, col);
        if (row < 0 || col < 0 || row >= grid.length
                || col >= grid[0].length
                || grid[row][col] == -1
                || grid[row][col] < path
                || (visited.contains(str) && grid[row][col] - path <= 1)) {
            return;
        }

        visited.add(str);
        if (grid[row][col] > path) {
            grid[row][col] = path + 1;
        }

        dfs(row, col - 1, grid, grid[row][col], visited);
        dfs(row, col + 1, grid, grid[row][col], visited);
        dfs(row - 1, col, grid, grid[row][col], visited);
        dfs(row + 1, col, grid, grid[row][col], visited);
    }
}
