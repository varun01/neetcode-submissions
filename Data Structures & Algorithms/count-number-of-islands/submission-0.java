class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
    }
}
