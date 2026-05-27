class Solution {
    public int islandPerimeter(int[][] grid) {
        Set<String> visits = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid, visits);
                }
            }
        }
        return 0;
    }

    public int dfs(int i, int j, int[][] grid, Set<String> visits) {
        int perimeter = 0;
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }

        if (visits.contains(i + "," + j)) {
            return 0;
        }

        visits.add(i + "," + j);
        perimeter = dfs(i, j + 1, grid, visits);
        perimeter += dfs(i, j - 1, grid, visits);
        perimeter += dfs(i - 1, j, grid, visits);
        perimeter += dfs(i + 1, j, grid, visits);
        return perimeter;
    }
}