class Solution {
    int maxArea = 0;
    int currArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int cols = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    maxArea = Math.max(maxArea, currArea);
                    currArea = 0;
                }
            }
        }
        return maxArea;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        currArea++;
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
    }
}
