class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visitedArr = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.diff - t2.diff);
        pq.offer(new Tuple(0, 0, 0));

        while (!pq.isEmpty()) {
            Tuple rowColDiff = pq.poll();
            if (visitedArr[rowColDiff.row][rowColDiff.col]) {
                continue;
            }
            visitedArr[rowColDiff.row][rowColDiff.col] = true;
            if (rowColDiff.row == rows - 1 && rowColDiff.col == cols - 1) {
                return rowColDiff.diff;
            }

            for (int[] direction : directions) {
                int newRow = rowColDiff.row + direction[0];
                int newCol = rowColDiff.col + direction[1];
                if (newRow < 0 || newCol < 0 || newRow == rows || newCol == cols || visitedArr[newRow][newCol]) {
                    continue;
                }
                int newDiff = Math.max(rowColDiff.diff, Math.abs(heights[rowColDiff.row][rowColDiff.col] - heights[newRow][newCol]));
                pq.add(new Tuple(newDiff, newRow, newCol));
            }
        }
        return 0;
    }

    class Tuple {

        int diff;
        int row;
        int col;

        Tuple(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }

    }
}