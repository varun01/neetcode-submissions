class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int time = 0;
        int freshOranges = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.push(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty() && freshOranges > 0) {
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                int[] position = queue.pollFirst();
                for (int[] pos : directions) {
                    int row = pos[0] + position[0];
                    int col = pos[1] + position[1];
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
                        continue;
                    }
                    grid[row][col] = -2;
                    queue.offerLast(new int[]{row, col});
                    freshOranges--;
                }
            }
            time++;
        }
        return freshOranges == 0 ? time : -1;
    }
}
