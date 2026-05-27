class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(rows - 1, i, atlantic, heights[rows - 1][i], heights);
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights[r][0], heights);
            dfs(r, cols - 1, atlantic, heights[r][cols - 1], heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String str = String.format("%s,%s", i, j);
                if (pacific.contains(str) && atlantic.contains(str)) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y, Set<String> visited, int prevHeight, int[][] heights) {
        String str = String.format("%s,%s", x, y);
        if (visited.contains(str)
                || x < 0
                || y < 0
                || x >= heights.length
                || y >= heights[0].length
                || heights[x][y] < prevHeight) {
            return;
        }

        visited.add(String.format("%s,%s", x, y));
        dfs(x, y - 1, visited, heights[x][y], heights);
        dfs(x, y + 1, visited, heights[x][y], heights);
        dfs(x + 1, y, visited, heights[x][y], heights);
        dfs(x - 1, y, visited, heights[x][y], heights);
    }
}
