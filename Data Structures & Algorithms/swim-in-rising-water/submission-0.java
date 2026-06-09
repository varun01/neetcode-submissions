class Solution {
    public int swimInWater(int[][] grid) {
    int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visitArr = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        pq.offer(new Pair(0, 0, grid[0][0]));
        int time = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (visitArr[p.row][p.col]) {
                continue;
            }
            visitArr[p.row][p.col] = true;
            if (p.row == rows - 1 && p.col == cols - 1) {
                return Math.max(time, p.time);
            }
            time = Math.max(time, p.time);
            for (int[] direction : directions) {
                int newRow = p.row + direction[0];
                int newCol = p.col + direction[1];
                if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols || visitArr[newRow][newCol]) {
                    continue;
                }
                pq.offer(new Pair(newRow, newCol, grid[newRow][newCol]));
            }
        }
        return time;
    }

    class Pair {

        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

    }
}
